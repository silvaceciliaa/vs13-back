public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();

        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();

        cliente1.nome = "Cecília";
        cliente2.nome = "Arthur";

        conta1.cliente = cliente1;
        conta2.cliente = cliente2;

        conta1.numeroConta = "894747";
        conta2.numeroConta = "783982";
        conta1.agencia = 1;
        conta2.agencia = 1;

        conta1.saldo = 100.00;

        conta2.saldo = 0.50;

        conta1.chequeEspecial = 500.00;

        System.out.println();
        conta1.imprimirContaCorrente();
        System.out.println();
        conta2.imprimirContaCorrente();

        conta1.sacar(90.00);

        conta1.transferir(5.00, conta2);

       conta1.depositar(100.50);

        conta1.sacar(200.00);

        System.out.println();
        conta1.imprimirContaCorrente();
        System.out.println();
        conta2.imprimirContaCorrente();




    }
}
