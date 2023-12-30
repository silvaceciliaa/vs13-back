public class ContaCorrente {
    public double chequeEspecial; // - private

//
//        if (cliente != null) {
//            System.out.println("Cliente: " + cliente.nome);
//            System.out.println("Agência: " + agencia + " - Número da conta: " + numeroConta);
//            System.out.println("Valor em conta: " + this.saldo);
//            System.out.println("Valor em conta + cheque especial: " + retornarSaldoComChequeEspecial());
//        } else {
//            System.out.println("Não há cliente associado à conta corrente.");
//        }
//    }
//
//    public boolean sacar(double valorSaque){
//        if (this.saldo >= valorSaque && valorSaque > 0){
//            this.saldo -= valorSaque;
//            return true;
//        } else if(this.saldo + this.chequeEspecial >= valorSaque && valorSaque > 0){
//            this.saldo -= valorSaque;
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public boolean depositar(double valorDeposito){
//        if (valorDeposito > 0){
//            this.saldo += valorDeposito;
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public double retornarSaldoComChequeEspecial(){
//        return this.saldo + this.chequeEspecial;
//    }
//
//    public boolean transferir(double valorTransferir, ContaCorrente contaDestino) {
//        if (valorTransferir > 0 && this.saldo >= valorTransferir) {
//            this.saldo -= valorTransferir;
//            contaDestino.saldo += valorTransferir;
//            return true;
//        } else {
//            return false;
//        }
//    }



}
