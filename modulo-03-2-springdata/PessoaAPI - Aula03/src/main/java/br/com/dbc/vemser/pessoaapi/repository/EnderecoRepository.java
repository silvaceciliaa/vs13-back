package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    //JPQL
    @Query("select e from ENDERECO_PESSOA e where e.pais =:pais")
    Endereco procurarPorPais(@Param("pais") String pais);


    @Query(value = "SELECT * FROM VEM_SER.ENDERECO_PESSOA WHERE cidade = :cidade OR pais = :pais", nativeQuery = true)
    List<Endereco> procurarPorCidadeOuPais(@Param("cidade") String cidade, @Param("pais") String pais);
}