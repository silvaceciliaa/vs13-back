package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    // idPessoaNulo

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada"; // consertar


    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
//        if (!pessoaJaExiste(contatoCreateDTO.getIdPessoa())) {
//            throw new RegraDeNegocioException("Pessoa não existe!");
//        }

        Pessoa pessoa = pessoaService.returnPersonById(idPessoa); // pensa que é nulo
        contatoCreateDTO.setIdPessoa(pessoa.getIdPessoa());
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }


    public List<ContatoDTO> list(){
        List<Contato> contatos = contatoRepository.findAll();

        List<ContatoDTO> contatosDTO = contatos.stream()
                .map(contato -> new ContatoDTO(contato.getIdContato(),
                        contato.getPessoa().getIdPessoa(),
                        contato.getTipoContato(),
                        contato.getNumero(),
                        contato.getDescricao())).toList();

        return contatosDTO;
    }

    public void delete(Integer id) throws Exception{
        Contato contatoADeletar = returnContactById(id);
        contatoRepository.delete(contatoADeletar);
    }

    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contatoCreateDTO) throws Exception {
        Contato novoContato = returnContactById(id);

        Contato contatoAtualizar = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        novoContato.setTipoContato(contatoAtualizar.getTipoContato());
        novoContato.setNumero(contatoAtualizar.getNumero());
        novoContato.setDescricao(contatoAtualizar.getDescricao());

        ContatoDTO contatoDTOAtualizado = objectMapper.convertValue(novoContato, ContatoDTO.class);

        return contatoDTOAtualizado;
    }

    // - método personalizado feito na repository
//    public List<ContatoDTO> listByPeople(int id){
//        List<Contato> contatos =  contatoRepository.listByPeople(id);
//        List<ContatoDTO> contatoDTOS = new ArrayList<>();
//
//        for (Contato contato : contatos){
//            ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
//            contatoDTOS.add(contatoDTO);
//        }
//
//        return contatoDTOS;
//    }

//    private boolean pessoaJaExiste(int id) {
//        try {
//            pessoaService.findById(id);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }

    private Contato findById(Integer id) throws Exception{
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrado"));
        return contato;
    }

    public Contato returnContactById(Integer id) throws EntidadeNaoEncontradaException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }


}
