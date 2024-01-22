package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
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

    @NotNull
    private TipoContato tipoContato;

    @NotNull
    @NotBlank
    @Size(max = 13)
    private String numero;

    @NotBlank
    private String descricao;

}