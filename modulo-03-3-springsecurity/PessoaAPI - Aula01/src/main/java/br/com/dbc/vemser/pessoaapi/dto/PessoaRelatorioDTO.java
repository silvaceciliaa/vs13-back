package br.com.dbc.vemser.pessoaapi.dto;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PessoaRelatorioDTO {
    private Integer idPessoa;
    private String nome;
    private String email;
    private List<ContatoRelatorioDTO> contatosPessoa = new ArrayList<>();
    private List<EnderecoRelatorioDTO> enderecosPessoa = new ArrayList<>();
    private String nomeDoPet;

    public PessoaRelatorioDTO(Integer idPessoa, String nome, String email, String nomeDoPet) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.nomeDoPet = nomeDoPet;
    }
}
