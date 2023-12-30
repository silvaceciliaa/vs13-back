public class Contato {

    public String descricao; // - private
    public String telefone; // - private
    public int tipo; // - private

    // - getters e setters de descricão, telefone e tipo

    public void imprimirContato(){
        String tipoTelefone = (tipo == 1) ? "Residencial" : (tipo == 2) ? "Comercial" : "N/A";
        String descricaoInformado = descricao.equals("") ? "N/A" : descricao;

        System.out.println("Telefone: " + telefone + " - Tipo: " + tipoTelefone + " - Descrição: " + descricaoInformado);

    }
}
