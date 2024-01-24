package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContatoCreateDTO {

    private Integer idPessoa;

    @Schema(description = "Tipo de contato", required = true, example = "COMERCIAL")
    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @Schema(description = "Número", required = true, example = "47984321410")
    @NotBlank(message = "Número não pode ser nulo")
    @Size(max = 13, message = "Número deve ter no máximo 13 dígitos")
    private String numero;

    @Schema(description = "Descrição", required = true, example = "Número da loja")
    @NotBlank(message = "Descriçã não pode ser nula")
    private String descricao;

}