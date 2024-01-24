package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.enums.TipoEndereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipoEndereco;

    @NotBlank(message = "Logradouro não pode ser nulo")
    @Size(max = 250, message = "máximo de 250 caracteres")
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;
    private String complemento;

    @NotBlank(message = "CEP não pode ser nulo")
    @Size(min = 8, max = 8, message = "CEP deve conter 8 dígitos")
    private String cep;

    @NotBlank(message = "Cidade não pode ser nulo")
    @Size(max = 250, message = "Cidade deve conter no máximo 250 caracteres")
    private String cidade;

    @NotBlank(message = "Estado não pode ser nulo")
    private String estado;

    @NotBlank(message = "País não pode ser nulo")
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