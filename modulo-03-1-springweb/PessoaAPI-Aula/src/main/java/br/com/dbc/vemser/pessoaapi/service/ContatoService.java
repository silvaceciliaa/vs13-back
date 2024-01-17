package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    public Contato create(Contato contato) {
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public void delete(Integer id) throws Exception{
        Contato contatoADeletar = getContato(id);
        contatoRepository.delete(contatoADeletar);
    }

    public Contato update(Integer id,
                          Contato contatoAtualizar) throws Exception {
        Contato novoContato = getContato(id);

        novoContato.setIdPessoa(contatoAtualizar.getIdPessoa());
        novoContato.setTipoContato(contatoAtualizar.getTipoContato());
        novoContato.setNumero(contatoAtualizar.getNumero());
        novoContato.setDescricao(contatoAtualizar.getDescricao());

        return contatoAtualizar;
    }

    public List<Contato> listByPeople(int id){
        return contatoRepository.listByPeople(id);
    }

    private Contato getContato(Integer id) throws Exception{

        List<Contato> contatos = contatoRepository.list();

        for (Contato contato : contatos) {
            if (contato.getIdContato().equals(id)) {
                return contato;
            }
        }
        throw new Exception("Pessoa não encontrada!");
    }
}
