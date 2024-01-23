package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;

    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        if (!pessoaJaExiste(contatoCreateDTO.getIdPessoa())) {
            throw new RegraDeNegocioException("Pessoa não existe!");
        }

        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);

        return contatoDTO;
    }


    public List<ContatoDTO> list(){
        List<Contato> contatoEntityList = contatoRepository.list();
        List<ContatoDTO> contatoDTOList = new ArrayList<>();

        for (Contato contatoEntity : contatoEntityList){
            ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
            contatoDTOList.add(contatoDTO);
        }
        return contatoDTOList;
    }

    public void delete(Integer id) throws Exception{
        Contato contatoADeletar = getContato(id);
        contatoRepository.delete(contatoADeletar);
    }

    public ContatoDTO update(Integer id,
                          ContatoCreateDTO contatoCreateDTO) throws Exception {
        Contato novoContato = getContato(id);

        Contato contatoAtualizar = objectMapper.convertValue(contatoCreateDTO, Contato.class);

        novoContato.setIdPessoa(contatoAtualizar.getIdPessoa());
        novoContato.setTipoContato(contatoAtualizar.getTipoContato());
        novoContato.setNumero(contatoAtualizar.getNumero());
        novoContato.setDescricao(contatoAtualizar.getDescricao());

        ContatoDTO contatoDTOAtualizado = objectMapper.convertValue(novoContato, ContatoDTO.class);

        return contatoDTOAtualizado;
    }

    public List<ContatoDTO> listByPeople(int id){
        List<Contato> contatos =  contatoRepository.listByPeople(id);
        List<ContatoDTO> contatoDTOS = new ArrayList<>();

        for (Contato contato : contatos){
            ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
            contatoDTOS.add(contatoDTO);
        }

        return contatoDTOS;
    }

    private boolean pessoaJaExiste(int id) {
        try {
            pessoaService.getPessoa(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private Contato getContato(Integer id) throws Exception{

        List<Contato> contatos = contatoRepository.list();

        for (Contato contato : contatos) {
            if (contato.getIdContato().equals(id)) {
                return contato;
            }
        }
        throw new RegraDeNegocioException("Contato não encontrado!");
    }
}
