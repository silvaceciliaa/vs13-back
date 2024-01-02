public class Contato {

    public String descricao;
    public String telefone;
    public int tipo;

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
