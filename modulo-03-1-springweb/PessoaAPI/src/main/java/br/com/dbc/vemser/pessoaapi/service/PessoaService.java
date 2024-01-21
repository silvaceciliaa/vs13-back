package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import javax.validation.ConstraintViolationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;


    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        if (cpfAlreadyExists(pessoaCreateDTO.getCpf())) {
            throw new RegraDeNegocioException("CPF já cadastrado para outra pessoa.");
        }

        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);

        pessoaEntity = pessoaRepository.create(pessoaEntity);

        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);

        return pessoaDTO;
    }
//    public Pessoa create(Pessoa pessoa) throws RegraDeNegocioException {
//        if (cpfAlreadyExists(pessoa.getCpf())) {
//            throw new RegraDeNegocioException("CPF já cadastrado para outra pessoa.");
//        }
//        return pessoaRepository.create(pessoa);
//    }

    public List<PessoaDTO> list(){
        List<Pessoa> pessoaEntityList = pessoaRepository.list();

        List<PessoaDTO> pessoaDTOList = new ArrayList<>();

        for (Pessoa pessoaEntity : pessoaEntityList) {
            PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
            pessoaDTOList.add(pessoaDTO);
        }

        return pessoaDTOList;
    }

    public Pessoa update(Integer id,
                         PessoaCreateDTO pessoaCreateDTO) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        Pessoa pessoaAtualizar = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    private Pessoa getPessoa(Integer id) throws Exception {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

    private boolean cpfAlreadyExists(String cpf) {
        return pessoaRepository.list().stream()
                .anyMatch(p -> p.getCpf().equals(cpf));
    }

}
