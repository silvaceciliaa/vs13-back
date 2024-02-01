package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContatoDTO {
    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;

}