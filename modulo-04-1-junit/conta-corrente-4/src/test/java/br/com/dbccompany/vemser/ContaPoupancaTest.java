package br.com.dbccompany.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Conta Poupança - Teste")
public class ContaPoupancaTest {

    Cliente cliente1 = new Cliente("Cecília", "123456789");
    ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1, "21192140", "002", 1000.00);


    @Test
    void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        contaPoupanca.creditarTaxa();
        contaPoupanca.sacar(40.00);
        double valorObtido = contaPoupanca.getSaldo();
        Assertions.assertEquals(970.00, valorObtido);
    }

    @Test
    void deveTestarSaqueContaPoupancaSemSaldo(){
        contaPoupanca.sacar(1005.00);
        double valorObtido = contaPoupanca.getSaldo();
        Assertions.assertEquals(1000.00, valorObtido);
    }
}
