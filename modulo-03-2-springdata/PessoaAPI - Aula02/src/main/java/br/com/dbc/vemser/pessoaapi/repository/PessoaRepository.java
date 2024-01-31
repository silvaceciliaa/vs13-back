package br.com.dbc.vemser.pessoaapi.repository;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> { // segundo parametro é o tipo de dado do meu ID

    public List<Pessoa> findAllByNomeContainsIgnoreCase(String nome);

    public List<Pessoa> findByCpf(String cpf);

    public List<Pessoa> findByDataNascimentoBetween(LocalDate start, LocalDate end);

//    public List<Pessoa> findByContatos


}
