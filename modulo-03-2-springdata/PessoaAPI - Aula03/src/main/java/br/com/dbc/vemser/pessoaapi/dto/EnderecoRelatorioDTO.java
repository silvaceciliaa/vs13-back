package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoRelatorioDTO {

    public String cep;
    public String cidade;
    public String estado;
    public String pais;
}
