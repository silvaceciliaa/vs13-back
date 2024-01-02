public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente() {
        if (cliente != null) {
            System.out.println("Cliente: " + cliente.nome);
            System.out.println("Agência: " + agencia + " - Número da conta: " + numeroConta);
            System.out.println("Valor em conta: " + this.saldo);
            System.out.println("Valor em conta + cheque especial: " + retornarSaldoComChequeEspecial());
        } else {
            System.out.println("Não há cliente associado à conta corrente.");
        }
    }

    public boolean sacar(double valorSaque){
        if (this.saldo >= valorSaque && valorSaque > 0){
            this.saldo -= valorSaque;
            System.out.println("Saque no valor de: " + valorSaque + " realizado com sucesso!");
            return true;
        } else if(this.saldo + this.chequeEspecial >= valorSaque && valorSaque > 0){
            this.saldo -= valorSaque;
            System.out.println("Saque no valor de: " + valorSaque + " realizado com sucesso!");
            return true;
        }else {
            System.out.println("Não foi possível realizar o saque.");
            return false;
        }
    }

    public boolean depositar(double valorDeposito){
        if (valorDeposito > 0){
            this.saldo += valorDeposito;
            System.out.println("Depósito no valor de: " + valorDeposito + " realizado com sucesso!");
            return true;
        }else {
            System.out.println("Operação de depósito não foi concluída.");
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial(){
        return this.saldo + this.chequeEspecial;
    }

    public boolean transferir(double valorTransferir, ContaCorrente contaDestino) {
        if (valorTransferir > 0 && this.saldo >= valorTransferir) {
            this.saldo -= valorTransferir;
            contaDestino.saldo += valorTransferir;
            System.out.println("Transferência realizada com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possível realizar a transferência.");
            return false;
        }
    }



}
