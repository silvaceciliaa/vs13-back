import java.security.PublicKey;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos){
        this.nome = nome;
        this.cpf = cpf;

        if (contatos != null) {
            this.contatos.addAll(contatos);
        }
        if (enderecos != null) {
            this.enderecos.addAll(enderecos);
        }
    }

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
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

    public ArrayList<Contato> getContatos() {
        return this.contatos;
    }

    public void setContatos(ArrayList<Contato> contatos){
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos){
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
            if (!contatos.isEmpty()) {
                System.out.println("Contato cliente " + nome + ": ");
                for (Contato contato : contatos) {
                    contato.imprimirContato();
                }
            } else {
                System.out.println("Contato cliente " + nome + ": Nenhum contato cadastrado.");
            }
    }

    public void imprimirEnderecos() {
        if (!enderecos.isEmpty()) {
            System.out.println("Endereço cliente " + nome + ": ");
            for (Endereco endereco : enderecos) {
                endereco.imprimirEndereco();
            }
        } else {
            System.out.println("Endereço cliente " + nome + ": Nenhum endereço cadastrado.");
        }
    }
    public void imprimirCliente() {
        System.out.println("Imprimindo informações do cliente: " + nome);
        System.out.println("CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }
}
