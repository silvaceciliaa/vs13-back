package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoContato;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;

    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @NotBlank(message = "Número não pode ser nulo")
    @Size(max = 13, message = "Número deve ter no máximo 13 dígitos")
    private String numero;

    @NotBlank(message = "Descriçã não pode ser nula")
    private String descricao;


    public Contato() {
    }

    public Contato(Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
