import interfaces.IImpresao;

public class ContaPoupanca extends Conta implements IImpresao {

    static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        if (getCliente() != null) {
            System.out.println("Cliente conta poupança: " + getCliente().getNome());
            System.out.println("Agência: " + getAgencia() + " - Número da conta: " + getNumeroConta());
            System.out.println("Valor em conta: " + getSaldo());
        } else {
            System.out.println("Não há cliente associado à conta corrente.");
        }
    }

    public void creditarTaxa(){
        double saldoNovo = getSaldo() * JUROS_MENSAL;
        setSaldo(saldoNovo);
        System.out.println("Juros aplicado. Valor: " + saldoNovo);
    }
}
