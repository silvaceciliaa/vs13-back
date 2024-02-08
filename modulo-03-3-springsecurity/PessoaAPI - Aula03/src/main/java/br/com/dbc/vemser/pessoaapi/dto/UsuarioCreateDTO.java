package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCreateDTO {

    private String login;
    private String senha;
    private Integer idCargo;
}
