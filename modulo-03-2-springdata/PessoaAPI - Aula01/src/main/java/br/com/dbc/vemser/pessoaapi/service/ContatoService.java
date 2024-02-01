package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";


    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        if (!pessoaJaExiste(contatoCreateDTO.getIdPessoa())) {
            throw new RegraDeNegocioException("Pessoa não existe!");
        }

        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity = contatoRepository.save(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }


    public List<ContatoDTO> list(){
        List<Contato> contatoEntityList = contatoRepository.findAll();
        List<ContatoDTO> contatoDTOList = new ArrayList<>();

        for (Contato contatoEntity : contatoEntityList){
            ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
            contatoDTOList.add(contatoDTO);
        }
        return contatoDTOList;
    }

    public void delete(Integer id) throws Exception{
        Contato contatoADeletar = returnContactById(id);
        contatoRepository.delete(contatoADeletar);
    }

    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contatoCreateDTO) throws Exception {
        Contato novoContato = returnContactById(id);

        Contato contatoAtualizar = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        novoContato.setIdPessoa(contatoAtualizar.getIdPessoa());
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

    private boolean pessoaJaExiste(int id) {
        try {
            pessoaService.findById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

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
