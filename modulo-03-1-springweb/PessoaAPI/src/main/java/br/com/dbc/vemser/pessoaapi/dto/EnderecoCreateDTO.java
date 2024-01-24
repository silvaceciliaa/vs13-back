package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
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
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @Schema(description = "Tipo do endereço", required = true, example = "RESIDENCIAL")
    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipoEndereco;

    @Schema(description = "Logradouro", required = true, example = "Cornelia Street")
    @NotBlank(message = "Logradouro não pode ser nulo")
    @Size(max = 250, message = "máximo de 250 caracteres")
    private String logradouro;

    @Schema(description = "Número", required = true, example = "66")
    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;
    @Schema(description = "Complemento", required = false, example = "Apto. 514")
    private String complemento;

    @Schema(description = "CEP", required = true, example = "80045412")
    @NotBlank(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "CEP deve conter 8 dígitos")
    private String cep;

    @Schema(description = "Cidade", required = true, example = "Petrolina")
    @NotBlank(message = "Cidade não pode ser nulo")
    @Size(max = 250, message = "Cidade deve conter no máximo 250 caracteres")
    private String cidade;

    @Schema(description = "Estado", required = true, example = "Pernambuco")
    @NotBlank(message = "Estado não pode ser nulo")
    private String estado;

    @Schema(description = "País", required = true, example = "Brasil")
    @NotBlank(message = "País não pode ser nulo")
    private String pais;

}
