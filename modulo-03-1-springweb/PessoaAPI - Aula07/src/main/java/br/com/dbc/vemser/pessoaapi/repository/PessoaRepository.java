package br.com.dbc.vemser.pessoaapi.repository;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
    }

    public Pessoa create(Pessoa pessoa) throws RegraDeNegocioException {
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

//    public Pessoa update(Integer id, - passar para repository
//                         Pessoa pessoaAtualizar) {
//        pessoaAtualizar.setCpf(pessoaAtualizar.getCpf());
//        pessoaAtualizar.setNome(pessoaAtualizar.getNome());
//        pessoaAtualizar.setDataNascimento(pessoaAtualizar.getDataNascimento());
//        return pessoaAtualizar;
//    }

    public void delete(Pessoa pessoa) {
        listaPessoas.remove(pessoa);
    }

    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
