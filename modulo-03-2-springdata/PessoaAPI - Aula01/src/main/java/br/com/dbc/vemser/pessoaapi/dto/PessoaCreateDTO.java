package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PessoaCreateDTO {

    @Schema(description = "Nome da Pessoa", required = true, example = "Cecília Silva")
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Schema(description = "Data de nascimento", required = true)
    @NotNull
    @PastOrPresent(message = "Data de nascimento deve ser no presente ou no passado")
    private LocalDate dataNascimento;

    @Schema(description = "CPF", required = true, example = "12345678910")
    @NotBlank(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
    private String cpf;

    @Schema(description = "Email", required = true, example = "cecilia@email.com")
    @NotBlank(message = "Email não pode ser nulo")
    @Size(max = 255, message = "Limite de caracteres excedido")
    private String email;
}
