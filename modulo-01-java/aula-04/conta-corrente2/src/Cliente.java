public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos){
        this.nome = nome;
        this.cpf = cpf;

        for (int i = 0; i < this.contatos.length; i++) {
            this.contatos[i] = contatos[i];
        }
        for (int i = 0; i < this.enderecos.length; i++) {
            this.enderecos[i] = enderecos[i];
        }
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return this.contatos;
    }

    public void setContatos(Contato[] contatos){
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Endereco[] enderecos){
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        for (int i = 0; i < 1; i++) {
            if (contatos[i] != null) {
                System.out.println("Contato cliente " + nome + ": ");
                contatos[i].imprimirContato();
            } else {
                System.out.println("Contato cliente " + nome + ": Nenhum contato cadastrado.");
            }
        }
    }

    public void imprimirEnderecos() {
        for (int i = 0; i < 1; i++) {
            if (enderecos[i] != null) {
                System.out.print("Endereço cliente " + nome + ": ");
                enderecos[i].imprimirEndereco();
            } else {
                System.out.println("Endereço cliente " + nome + ": Nenhum endereço cadastrado.");
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
