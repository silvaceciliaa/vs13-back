package br.com.dbccompany.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Conta - Teste")
public class ContaTest {
    Cliente cliente1 = new Cliente("Cecília", "123456789");
    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1, "21192140", "002", 1000.00);

    Cliente cliente2 = new Cliente("Madalena", "987654321");
    ContaCorrente contaCorrente = new ContaCorrente(cliente1,"14155432", "001", 100.00, 900.00);
    ContaCorrente contaCorrente2 = new ContaCorrente(cliente2,"14155433", "001", 100.00, 900.00);

    ContaPagamento contaPagamento = new ContaPagamento(cliente1, contaCorrente.getNumeroConta(), contaCorrente.getAgencia(), contaCorrente.getSaldo());

    @Test
    void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        contaCorrente.sacar(500.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(500.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaCorrenteSemSaldo() {
        contaCorrente.sacar(1100.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(1000.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        contaPoupanca.creditarTaxa();
        contaPoupanca.sacar(40.00);
        double valorObtido = contaPoupanca.getSaldo();
        Assertions.assertEquals(970.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaPoupancaSemSaldo() {
        contaPoupanca.sacar(1005.00);
        double valorObtido = contaPoupanca.getSaldo();
        Assertions.assertEquals(1000.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        contaPagamento.sacar(40.75);
        double valorObtido = contaPagamento.getSaldo();
        Assertions.assertEquals(55.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaPagamentoSemSaldo(){
        contaPagamento.sacar(100.00);
        double valorObtido = contaPagamento.getSaldo();
        Assertions.assertEquals(100.00, valorObtido);
    }

    @Test
    void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        contaCorrente.transferir(contaCorrente2, 50.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(950.00, valorObtido);
    }

    @Test
    void deveTestarTransferenciaSemSaldo(){
        contaCorrente.transferir(contaCorrente, 1100.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(1000.00, valorObtido);
    }

    @Test
    void deveTestarDepositoEVerificarSaldoComSucesso(){
        contaCorrente.depositar(200.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(1200.00, valorObtido);
    }

    @Test
    void deveTestarDepositoNegativo(){
        contaCorrente.depositar(-200.00);
        double valorObtido = contaCorrente.retornarSaldoComChequeEspecial();
        Assertions.assertEquals(1000.00, valorObtido);
    }
}
