public class Main {
    public static void main(String[] args) {

        Contato[] contatos = new Contato[2];
        contatos[0] = new Contato("", "111111111", 1);
        contatos[1] = new Contato("Descrição Contato 2", "222222222", 2);


        Endereco[] enderecos = new Endereco[2];
        enderecos[0] = new Endereco(1, "Rio Branco", 123, "apto 417", "11111-111", "Cidade Canoas", "Rio Grande do Sul", "Brasil");
        enderecos[1] = new Endereco(2, "Bahia", 456, "apto 119", "22222-222", "Cidade Alegrete", "Rio Grande do Sul", "Brasil");


        Cliente cliente1 = new Cliente("Cecília", "123456789", contatos, enderecos);
        Cliente cliente2 = new Cliente("Arthur", "987654321", contatos, enderecos);

        Conta conta1 = new Conta(cliente1, "14155432", "001", 5666.33);
        Conta conta2 = new Conta(cliente2, "24459871", "002", 43.99);

        ContaCorrente contaCorrente1 = new ContaCorrente(conta1.getCliente(), conta1.getNumeroConta(), conta1.getAgencia(), conta1.getSaldo(), 900.00);
        ContaCorrente contaCorrente2 = new ContaCorrente(conta2.getCliente(), conta2.getNumeroConta(), conta2.getAgencia(), conta2.getSaldo(), 100.00);

        System.out.println();
        contaCorrente1.imprimir();
        System.out.println();
        contaCorrente2.imprimir();

        contaCorrente1.sacar(900.00);

        contaCorrente1.transferir(contaCorrente2, 500.00);

        contaCorrente1.depositar(100.50);

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(conta1.getCliente(), conta1.getNumeroConta(), conta1.getAgencia(), conta1.getSaldo());
        contaPoupanca1.creditarTaxa();

        System.out.println();
        contaCorrente1.imprimir();
        System.out.println();
        contaCorrente2.imprimir();



    }
}
