package interfaces;

public interface IMovimentacao {

    Cliente getCliente();
    String getNumeroConta();
    String getAgencia();
    double getSaldo();
    void setCliente(Cliente cliente);
    void setNumeroConta(String numeroConta);
    void setAgencia(String agencia);
    void setSaldo(double saldo);
}
