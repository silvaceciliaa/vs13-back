public class Cliente {
    public String nome;
    public String cpf;

    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos() {
        for (int i = 0; i < 1; i++) {
            if (contatos[i] != null) {
                System.out.println("Contato cliente " + (i + 1) + ": ");
                contatos[i].imprimirContato();
            } else {
                System.out.println("Contato cliente " + (i + 1) + ": Nenhum contato cadastrado.");
            }
        }
    }

    public void imprimirEnderecos() {
        for (int i = 0; i < 1; i++) {
            if (enderecos[i] != null) {
                System.out.print("Endereço cliente " + (i + 1) + ": ");
                enderecos[i].imprimirEndereco();
            } else {
                System.out.println("Endereço cliente " + (i + 1) + ": Nenhum endereço cadastrado.");
            }
        }
    }
    public void imprimirCliente() {
        System.out.println("Imprimindo informações do cliente: " + nome);
    }
}
