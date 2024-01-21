package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

}
