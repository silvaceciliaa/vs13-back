package br.com.dbccompany.vemser;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo;

    public Contato(String descricao, String telefone, int tipo){
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public int getTipo(){
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void imprimirContato(){

        String tipoTelefone;
        if (tipo == 1) {
            tipoTelefone = "Residencial";
        } else if (tipo == 2) {
            tipoTelefone = "Comercial";
        } else {
            tipoTelefone = "Outro";
        }
        String descricaoInformado = descricao.equals("") ? "N/A" : descricao;

        System.out.println("Telefone: " + telefone + " - Tipo: " + tipoTelefone + " - Descrição: " + descricaoInformado);

    }
}
