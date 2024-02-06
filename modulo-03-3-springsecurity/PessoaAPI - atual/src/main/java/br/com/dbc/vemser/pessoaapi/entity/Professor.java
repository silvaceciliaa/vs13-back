package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Data
@Entity(name = "PROFESSOR")
public class Professor {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private Double salario;
}
