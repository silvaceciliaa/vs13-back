package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRelatorioDTO {

    private Integer idPessoa;
    private String nomePessoa;
    private String email;
    private List<ContatoRelatorioDTO> contatos = new ArrayList<>();
    private List<EnderecoRelatorioDTO> endereco = new ArrayList<>();
    private String nomePet;
}
