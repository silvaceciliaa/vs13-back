package br.com.dbccompany.vemser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Conta Pagamento - Teste")
public class ContaPagamentoTest {

    Cliente cliente1 = new Cliente("Cecília", "123456789");
    ContaCorrente contaCorrente = new ContaCorrente(cliente1,"14155432", "001", 100.00, 900.00);
    ContaPagamento contaPagamento = new ContaPagamento(cliente1, contaCorrente.getNumeroConta(), contaCorrente.getAgencia(), contaCorrente.getSaldo());

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
}
