import interfaces.IMovimentacao;

public abstract class Conta implements IMovimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo){
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Conta(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }

    public String getAgencia(){
        return this.agencia;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setAgencia(String agencia){
        this.agencia = agencia;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor && valor > 0) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque de: " + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque.");
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0){
            saldo += valor;
            System.out.println("Depósito no valor de: " + valor + " realizado com sucesso!");
            return true;
        }else {
            System.out.println("Operação de depósito não foi concluída.");
            return false;
        }
    }

    @Override
    public boolean transferir(IMovimentacao conta, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            conta.depositar(valor);
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possível realizar a transferência.");
            return false;
        }
    }
}
