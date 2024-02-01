package br.com.dbc.vemser.pessoaapi.repository;
import br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> { // segundo parametro é o tipo de dado do meu ID

    public List<Pessoa> findAllByNomeContainsIgnoreCase(String nome);

    public List<Pessoa> findByCpf(String cpf);

    public List<Pessoa> findByDataNascimentoBetween(LocalDate start, LocalDate end);

    @Query(value = "SELECT * " +
            "FROM VEM_SER.PESSOA p " +
            "LEFT JOIN VEM_SER.PESSOA_X_PESSOA_ENDERECO pxpe ON pxpe.ID_PESSOA = p.ID_PESSOA " +
            "LEFT JOIN VEM_SER.ENDERECO_PESSOA e ON pxpe.ID_ENDERECO = e.ID_ENDERECO " +
            "LEFT JOIN VEM_SER.CONTATO c ON p.ID_PESSOA = c.ID_PESSOA " +
            "LEFT JOIN VEM_SER.PET pt ON p.ID_PESSOA  = pt.ID_PESSOA  ",
            nativeQuery = true)
    Set<Pessoa> findPessoaWithDetails();



}
