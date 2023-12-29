public class Contato {

    public String descricao;
    public String telefone;
    public int tipo;

    public void imprimirContato(){
        String tipoTelefone = (tipo == 1) ? "Residencial" : (tipo == 2) ? "Comercial" : "N/A";
        String descricaoInformado = descricao.equals("") ? "N/A" : descricao;

        System.out.println("Telefone: " + telefone + " - Tipo: " + tipoTelefone + " - Descrição: " + descricaoInformado);

    }
}
