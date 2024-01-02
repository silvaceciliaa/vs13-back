package interfaces;

public interface IMovimentacao {

    String getNumeroConta();
    void setNumeroConta(String numeroConta);
    String getAgencia();
    void setAgencia(String agencia);
    double getSaldo();
    void setSaldo(double saldo);
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(IMovimentacao conta, double valor);
}
