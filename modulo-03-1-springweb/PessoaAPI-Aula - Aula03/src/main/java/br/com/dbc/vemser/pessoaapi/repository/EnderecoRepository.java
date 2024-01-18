package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Cornelia Street", 13, "89045425", "New York", "New York", "United States" ));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Bond Street", 13, "242121", "London", "London", "England" ));
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public void delete(Endereco endereco) {
        listaEnderecos.remove(endereco);
    }

    public List<Endereco> listByEndereco(Integer id) {
        List<Endereco> enderecosPorId = new ArrayList<>();

        for (Endereco endereco : listaEnderecos){
            if (endereco.getIdEndereco().equals(id)) {
                enderecosPorId.add(endereco);
            }
        }
        return enderecosPorId;
    }

    public List<Endereco> listByPeople(Integer id) {
        List<Endereco> enderecosDaPessoa = new ArrayList<>();

        for (Endereco endereco : listaEnderecos) {
            if (endereco.getIdPessoa().equals(id)) {
                enderecosDaPessoa.add(endereco);
            }
        }
        return enderecosDaPessoa;
    }
}