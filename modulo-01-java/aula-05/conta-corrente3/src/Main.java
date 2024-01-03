import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contato> contatosCliente1 = new ArrayList<>();
        contatosCliente1.add(new Contato("", "111111111", 1));

        ArrayList<Endereco> enderecosCliente1 = new ArrayList<>();
        enderecosCliente1.add(new Endereco(1, "Rio Branco", 123, "apto 417", "11111-111", "Cidade Canoas", "Rio Grande do Sul", "Brasil"));

        ArrayList<Contato> contatosCliente2 = new ArrayList<>();
        contatosCliente2.add(new Contato("", "222222222", 2));

        ArrayList<Endereco> enderecosCliente2 = new ArrayList<>();
        enderecosCliente2.add(new Endereco(2, "Bahia", 456, "apto 119", "22222-222", "Cidade Alegrete", "Rio Grande do Sul", "Brasil"));


        Cliente cliente1 = new Cliente("Cecília", "123456789");
        Cliente cliente2 = new Cliente("Arthur", "987654321");


        ContaCorrente contaCorrente = new ContaCorrente(cliente1, "14155432", "001", 5666.33, 900.00);
        ContaPagamento contaPagamento = new ContaPagamento(cliente1, contaCorrente.getNumeroConta(), contaCorrente.getAgencia(), contaCorrente.getSaldo());
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente2, "21192140", "002", 43.68);

        contaPagamento.sacar(900.00);
        contaCorrente.sincronizarSaldo(contaPagamento.getSaldo());

        contaCorrente.transferir(contaPoupanca, 500.00);

        contaPoupanca.depositar(100.50);

        contaPagamento.sincronizarSaldo(contaCorrente.getSaldo());

        System.out.println();
        contaCorrente.imprimir();
        System.out.println();
        contaPagamento.imprimir();
        System.out.println();
        contaPoupanca.imprimir();



    }
}
