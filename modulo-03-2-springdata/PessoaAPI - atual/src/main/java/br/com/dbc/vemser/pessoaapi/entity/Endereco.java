package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity(name = "ENDERECO_PESSOA")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column(name = "tipo")
    private TipoEndereco tipoEndereco;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<Pessoa> pessoas;

}