package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class PessoaDTO extends PessoaCreateDTO{ // response

    private Integer idPessoa;

    private String nome;

    private LocalDate dataNascimento;
}
