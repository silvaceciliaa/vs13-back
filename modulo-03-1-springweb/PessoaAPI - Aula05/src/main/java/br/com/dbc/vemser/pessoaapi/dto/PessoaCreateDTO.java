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
public class PessoaCreateDTO {

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    @PastOrPresent(message = "Data de nascimento deve ser no presente ou no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
    private String cpf;
