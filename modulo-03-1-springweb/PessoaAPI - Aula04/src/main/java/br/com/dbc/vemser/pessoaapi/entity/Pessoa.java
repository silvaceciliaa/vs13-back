package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;;

import java.time.LocalDate;

public class Pessoa {

    private Integer idPessoa;

    @NotBlank(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Data de nascimento não pode ser nulo")
    @PastOrPresent(message = "Data de nascimento deve ser no presente ou no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "CPF não pode ser nulo")
    @Size(min = 11, max = 11, message = "CPF deve conter 11 dígitos")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
