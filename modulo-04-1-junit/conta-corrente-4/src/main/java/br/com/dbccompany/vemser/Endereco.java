package br.com.dbccompany.vemser;

public class Endereco {
    private int tipo;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais){
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int getTipo(){
        return this.tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public String getLogradouro(){
        return this.logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getComplemento(){
        return this.complemento;
    }

    public void setComplemento(String complemento){
        this.complemento = complemento;
    }

    public String getCep(){
        return this.cep;
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public String getCidade(){
        return this.cep;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getEstado(){
        return this.estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getPais(){
        return this.pais;
    }

    public void setPais(String pais){
        this.pais = pais;
    }

    public void imprimirEndereco() {
        String tipoEndereco;
        if (tipo == 1) {
            tipoEndereco = "Residencial";
        } else if (tipo == 2) {
            tipoEndereco = "Comercial";
        } else {
            tipoEndereco = "Outro";
        }
        String complementoInformado = complemento.equals("") ? "N/A" : complemento;

        System.out.println("Rua: " + this.logradouro + " n.º " + this.numero + " - Complemento: " + complementoInformado + " - Cidade: " + this.cidade + ", " + this.estado + " - CEP: " + this.cep  + " - " + this.pais +", Tipo: " + tipoEndereco);
    }
}