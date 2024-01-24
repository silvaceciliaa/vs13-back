package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;
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

    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipoEndereco;

    @NotBlank(message = "Logradouro não pode ser nulo")
    @Size(max = 250, message = "máximo de 250 caracteres")
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;
    private String complemento;

    @NotBlank(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "CEP deve conter 8 dígitos")
    private String cep;

    @NotBlank(message = "Cidade não pode ser nulo")
    @Size(max = 250, message = "Cidade deve conter no máximo 250 caracteres")
    private String cidade;

    @NotBlank(message = "Estado não pode ser nulo")
    private String estado;

    @NotBlank(message = "País não pode ser nulo")
    private String pais;

}
