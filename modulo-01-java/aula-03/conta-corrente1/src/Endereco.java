public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

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