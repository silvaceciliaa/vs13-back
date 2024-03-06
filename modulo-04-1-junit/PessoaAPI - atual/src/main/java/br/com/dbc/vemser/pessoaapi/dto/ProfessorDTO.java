package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class ProfessorDTO {
    @NotNull
    private ProfessorPK professorPK;

    @NotNull
    private String nome;

    @NotNull
    private Double salario;
}
