package interfaces;

public interface IMovimentacao {
    boolean sacar(double valor);
    boolean depositar(double valor);
    boolean transferir(IMovimentacao conta, double valor);
}
