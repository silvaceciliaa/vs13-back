package br.com.dbc.vemser.pessoaapi.repository;
import br.com.dbc.vemser.pessoaapi.dto.ContatoRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> { // segundo parametro é o tipo de dado do meu ID

    public List<Pessoa> findAllByNomeContainsIgnoreCase(String nome);

    public List<Pessoa> findByCpf(String cpf);

    public List<Pessoa> findByDataNascimentoBetween(LocalDate start, LocalDate end);

    @Query(
            """
                    SELECT new br.com.dbc.vemser.pessoaapi.dto.PessoaRelatorioDTO(
                        p.idPessoa,  p.nome,  p.email,  pt.nome)  
                    FROM PESSOA p
                    LEFT JOIN p.pet pt
                    WHERE (:idPessoa IS NULL OR p.idPessoa = :idPessoa)
                    """
    )
    List<PessoaRelatorioDTO> procurarPessoaCompletaDTO(@Param("idPessoa") Integer idPessoa);

    @Query("""
            SELECT new br.com.dbc.vemser.pessoaapi.dto.EnderecoRelatorioDTO(
              e.cep, e.cidade, e.estado, e.pais) 
            FROM PESSOA p 
            JOIN p.enderecos e 
            WHERE p.idPessoa = :idPessoa """)
    List<EnderecoRelatorioDTO> procurarEnderecos(@Param("idPessoa") Integer idPessoa);


    @Query("""
            SELECT new br.com.dbc.vemser.pessoaapi.dto.ContatoRelatorioDTO(
                c.numero) 
            FROM PESSOA p 
            JOIN p.contatos c 
            WHERE c.pessoa.idPessoa = :idPessoa """)
    List<ContatoRelatorioDTO> procurarContatos(@Param("idPessoa") Integer idPessoa);



}
