import interfaces.IImpresao;

public class ContaCorrente extends Conta implements IImpresao {
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return this.chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    @Override
    public void imprimir() {
        if (getCliente() != null) {
            System.out.println("Cliente: " + getCliente().getNome());
            System.out.println("Agência: " + getAgencia() + " - Número da conta: " + getNumeroConta());
            System.out.println("Valor em conta: " + getSaldo());
            System.out.println("Valor em conta + cheque especial: " + retornarSaldoComChequeEspecial());
        } else {
            System.out.println("Não há cliente associado à conta corrente.");
        }
    }

    public boolean sacar(double valor) {

        double saldoTotal = retornarSaldoComChequeEspecial();

        if (saldoTotal >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque no valor de: " + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.");
            return false;
        }
    }
}

