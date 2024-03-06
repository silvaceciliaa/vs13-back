package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaContatoDTO {
    private Integer idPessoa;
    private String nome;
    private List<ContatoDTO> contatoDTOS;
}
