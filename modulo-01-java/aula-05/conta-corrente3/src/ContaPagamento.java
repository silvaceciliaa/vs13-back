import interfaces.IImpresao;

public class ContaPagamento extends Conta implements IImpresao {

    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public ContaPagamento(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimir() {
        if (getCliente() != null) {
            System.out.println("Cliente conta pagamento: " + getCliente().getNome());
            System.out.println("Agência: " + getAgencia() + " - Número da conta: " + getNumeroConta());
            System.out.println("Valor em conta: " + getSaldo());
        } else {
            System.out.println("Não há cliente associado à conta corrente.");
        }
    }

    public void sincronizarSaldo(double novoSaldo) {
        setSaldo(novoSaldo);
    }

    public boolean sacar(double valor){
        if (getSaldo() >= valor + TAXA_SAQUE && valor > 0) {

            double novoSaldo = (getSaldo() - valor) - TAXA_SAQUE;

            setSaldo(novoSaldo);
            System.out.println("Saque de: " + valor + " realizado com sucesso!");
            System.out.println("Taxa de saque de " + TAXA_SAQUE + " aplicada.");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.");
            return false;
        }
    }
}
