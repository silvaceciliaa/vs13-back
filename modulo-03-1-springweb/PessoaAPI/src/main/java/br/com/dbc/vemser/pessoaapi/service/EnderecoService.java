package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco create(Endereco endereco) throws RegraDeNegocioException {
        if (!pessoaJaExiste(endereco.getIdPessoa())){
            throw new RegraDeNegocioException("Pessoa não existe!");
        }
        if(ObjectUtils.isEmpty(endereco.getTipoEndereco())){
            throw new RegraDeNegocioException("Inválido");
        }
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public Endereco update(Integer id,
                           Endereco enderecoAtualizar) throws Exception {
        Endereco novoEndereco = getEndereco(id);

        novoEndereco.setIdPessoa(enderecoAtualizar.getIdPessoa());
        novoEndereco.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        novoEndereco.setLogradouro(enderecoAtualizar.getLogradouro());
        novoEndereco.setNumero(enderecoAtualizar.getNumero());
        novoEndereco.setComplemento(enderecoAtualizar.getComplemento());
        novoEndereco.setCep(enderecoAtualizar.getCep());
        novoEndereco.setCidade(enderecoAtualizar.getCidade());
        novoEndereco.setEstado(enderecoAtualizar.getEstado());
        novoEndereco.setPais(enderecoAtualizar.getPais());

        return enderecoAtualizar;
    }

    public void delete(Integer id) throws Exception{
        Endereco enderecoADeletar = getEndereco(id);
        enderecoRepository.delete(enderecoADeletar);
    }

    public List<Endereco> listByPeople(int id){
        return enderecoRepository.listByPeople(id);
    }

    public List<Endereco> listByEndereco(int id){
        return enderecoRepository.listByEndereco(id);
    }

    private boolean pessoaJaExiste(int id) {
        return enderecoRepository.list().stream()
                .anyMatch(e -> e.getIdEndereco().equals(id));
    }

    private Endereco getEndereco(Integer id) throws Exception{

        List<Endereco> enderecos = enderecoRepository.list();

        for (Endereco endereco : enderecos){
            if (endereco.getIdEndereco().equals(id)){
                return endereco;
            }
        }
        throw new RegraDeNegocioException("Endereço não encontrado");
    }
}
