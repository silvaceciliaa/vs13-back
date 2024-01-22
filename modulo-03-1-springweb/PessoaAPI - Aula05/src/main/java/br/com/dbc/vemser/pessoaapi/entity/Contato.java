package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;
import lombok.Data;

@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private TipoContato tipoContato;
    private String numero;
    private String descricao;

}
