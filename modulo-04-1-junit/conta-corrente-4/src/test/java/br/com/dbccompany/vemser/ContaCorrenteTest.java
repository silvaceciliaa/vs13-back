package br.com.dbccompany.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Conta Corrente - Teste")
public class ContaCorrenteTest {
    Cliente cliente1 = new Cliente("Cecília", "123456789");
    Cliente cliente2 = new Cliente("Madalena", "987654321");
    ContaCorrente contaCorrente = new ContaCorrente(cliente1,"14155432", "001", 100.00, 900.00);
    ContaCorrente contaCorrente2 = new ContaCorrente(cliente2,"14155433", "001", 100.00, 900.00);

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
