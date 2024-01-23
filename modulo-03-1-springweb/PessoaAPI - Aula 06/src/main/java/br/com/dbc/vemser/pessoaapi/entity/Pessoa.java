package br.com.dbc.vemser.pessoaapi.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pessoa {

    private Integer idPessoa;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

}
