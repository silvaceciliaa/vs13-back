package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class ContatoRepository {

    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository(){
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "47984694828", "Cornelia Street"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "1234567", "City of Stars"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.RESIDENCIAL, "1298551822", "Sebs"));
    }


    public Contato create(Contato contato) throws RegraDeNegocioException {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }

    public List<Contato> listByPeople(Integer id) {
        List<Contato> contatosDaPessoa = new ArrayList<>();

        for (Contato contato : listaContatos) {
            if (contato.getIdPessoa().equals(id)) {
                contatosDaPessoa.add(contato);
            }
        }

        return contatosDaPessoa;
    }


}