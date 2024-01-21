package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PessoaCreateDTO { // request

    @NotBlank
    private String nome;

    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
}
