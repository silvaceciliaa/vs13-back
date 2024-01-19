package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull
    private TipoEndereco tipoEndereco;

    @NotBlank
    @Size(max = 250)
    private String logradouro;

    @NotNull
    private Integer numero;
    private String complemento;

    @NotBlank
    @Size(max = 8)
    private String cep;

    @NotBlank
    @Size(max = 250)
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

    public Endereco(){

    }

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipoEndereco, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais){
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipoEndereco, String logradouro, Integer numero, String cep, String cidade, String estado, String pais){
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdEndereco(){
        return this.idEndereco;
    }

    public void setIdEndereco(Integer idEndereco){
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    @NotNull
    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipo) {
        this.tipoEndereco = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}