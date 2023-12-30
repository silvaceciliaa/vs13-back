public class Endereco {
    public int tipo; // - private
    public String logradouro; // - private
    public int numero; // - private
    public String complemento; // - private
    public String cep; // - private
    public String cidade; // - private
    public String estado; // - private
    public String pais; // - private

    // - getters e setters

    public void imprimirEndereco() {
        String tipoEndereco = (tipo == 1) ? "Residencial" : (tipo == 2) ? "Comercial" : "Outro";
        String complementoInformado = complemento.equals("") ? "N/A" : complemento;

        System.out.println("Rua: " + this.logradouro + " n.º " + this.numero + " - Cidade: " + this.cidade + ", " + this.estado + " - CEP: " + this.cep  + " - " + this.pais +", Tipo: " + tipoEndereco);
    }
}