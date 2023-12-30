import interfaces.IMovimentacao;

public class Conta implements IMovimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    @Override
    public Cliente getCliente(){
        return this.cliente;
    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public String getAgencia(){
        return this.agencia;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public void setNumeroConta(String numeroConta){
        this.numeroConta = numeroConta;
    }

    public void setAgencia(String agencia){
        this.agencia = agencia;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}
