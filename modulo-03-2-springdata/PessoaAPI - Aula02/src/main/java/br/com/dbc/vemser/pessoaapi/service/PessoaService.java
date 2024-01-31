package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        if (cpfAlreadyExists(pessoaCreateDTO.getCpf())) {
            throw new RegraDeNegocioException("CPF já cadastrado para outra pessoa.");
        }

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);

        pessoaEntity = pessoaRepository.save(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        //sendWelcomeEmail(pessoaDTO);

        return pessoaDTO;
    }

    public List<PessoaDTO> listByName(String nome) {
        List<Pessoa> pessoaList = pessoaRepository.findAllByNomeContainsIgnoreCase(nome);

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        for (Pessoa pessoaEntity : pessoaList) {
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;

    }

    public List<PessoaDTO> findByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByBday(LocalDate startingDate, LocalDate endingDate) throws Exception {
        List<Pessoa> pessoas = pessoaRepository.findByDataNascimentoBetween(startingDate, endingDate);
        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        for (Pessoa pessoaEntity : pessoas) {
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

    public List<PessoaDTO> list() throws Exception{
        List<Pessoa> pessoaEntityList = pessoaRepository.findAll();

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        for (Pessoa pessoaEntity : pessoaEntityList) {
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

    public List<PessoaEnderecoDTO> listWithAddress(Integer idPessoa) throws EntidadeNaoEncontradaException {
        Stream<Pessoa> pessoaStream;
// id pessoa nulo
        if (idPessoa != null) {
            Pessoa pessoa = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));

            pessoaStream = Stream.of(pessoa);
        } else {
            pessoaStream = pessoaRepository.findAll().stream();
        }

        return pessoaStream
                .map(pessoa -> {
                    PessoaEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoa, PessoaEnderecoDTO.class);

                    List<Endereco> enderecos = pessoa.getEnderecos().stream()
                            .map(enderecoDTO -> objectMapper.convertValue(enderecoDTO, Endereco.class))
                            .collect(Collectors.toList());

                    pessoaEnderecoDTO.setEnderecos(enderecos);


                    return pessoaEnderecoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaContatoDTO> listContactsForPeople(Integer idPessoa) throws EntidadeNaoEncontradaException {
        Stream<Pessoa> pessoaStream;
        if (idPessoa != null) {
            Pessoa pessoa = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));

            pessoaStream = Stream.of(pessoa);
        } else {
            pessoaStream = pessoaRepository.findAll().stream();
        }

        return pessoaStream
                .map(pessoa -> {
                    PessoaContatoDTO pessoaContatoDTO = objectMapper.convertValue(pessoa, PessoaContatoDTO.class);

                    List<ContatoDTO> contatosDTO = pessoa.getContatos().stream()
                            .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                            .collect(Collectors.toList()); // id pessoa nulo

                    pessoaContatoDTO.setContatoDTOS(contatosDTO);

                    return pessoaContatoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<PessoaPetDTO> listWithPet(Integer idPessoa) throws EntidadeNaoEncontradaException {
        Stream<Pessoa> pessoaStream;

        if (idPessoa != null) {
            Pessoa pessoa = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));

            pessoaStream = Stream.of(pessoa);
        } else {
            pessoaStream = pessoaRepository.findAll().stream();
        }

        return pessoaStream
                .map(pessoa -> {
                    PessoaPetDTO pessoaPetDTO = objectMapper.convertValue(pessoa, PessoaPetDTO.class);

                    if (pessoa.getPet() != null) {
                        PetDTO petDTO = objectMapper.convertValue(pessoa.getPet(), PetDTO.class);
                        pessoaPetDTO.setPetDTO(petDTO);
                    }

                    return pessoaPetDTO;
                })
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                         PessoaCreateDTO pessoaCreateDTO) throws Exception {
        Pessoa pessoaRecuperada = returnPersonById(id);

        Pessoa pessoaAtualizar = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        PessoaDTO pessoaDTOAtualizada = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);

        //sendUpdateEmail(pessoaDTOAtualizada);

        return pessoaDTOAtualizada;
    }

    public void delete(Integer id) throws Exception {
        try{
            Pessoa pessoaRecuperada = returnPersonById(id);
            pessoaRepository.delete(pessoaRecuperada);

            PessoaDTO pessoaDTOAtualizada = objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }

        //sendDeleteEmail(pessoaDTOAtualizada);
    }

    public Pessoa returnPersonById(Integer id) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    private boolean cpfAlreadyExists(String cpf) {
        return pessoaRepository.findAll().stream()
                .anyMatch(p -> p.getCpf().equals(cpf));
    }

    public Pessoa converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, Pessoa.class);
    }

    public PessoaDTO retornarDTO(Pessoa pessoa) {
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }


    private void sendWelcomeEmail(PessoaDTO pessoaDTO) throws Exception {
        try {
            emailService.sendEmail("Bem-vindo(a) ao Sistema","welcome-email-template.ftl", pessoaDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void sendUpdateEmail(PessoaDTO pessoaDTO) throws Exception{
        try {
            emailService.sendEmail("Alteração nos dados da sua conta", "alter-data-email-template.ftl", pessoaDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    private void sendDeleteEmail(PessoaDTO pessoaDTO) throws Exception{
        try {
            emailService.sendEmail("Você perdeu acesso ao sistema :(", "delete-email-template", pessoaDTO);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
}
