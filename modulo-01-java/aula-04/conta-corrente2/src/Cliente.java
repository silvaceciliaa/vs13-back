public class Cliente {
    private String nome;
    private String cpf;

    private Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public String getNome(){
        return this.nome;
    }

    public String cpf(){
        return this.cpf;
    }

    public Contato[] getContatos() {
        return this.contatos;
    }

    public Endereco[] getEnderecos() {
        return this.enderecos;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setContatos(Contato[] contatos){
        this.contatos = contatos;
    }

    public void setEnderecos(Endereco[] enderecos){
        this.enderecos = enderecos;
    }

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
        System.out.println("CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
