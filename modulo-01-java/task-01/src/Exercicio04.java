public class Exercicio04 {
    public static void main(String[] args) {

        int variavalA = 10, variavelB = 20, temp;

        System.out.println("Variável A: " + variavalA);
        System.out.println("Variável B: " + variavelB);

        temp = variavalA;
        variavalA = variavelB;
        variavelB = temp;
        
        System.out.println();
        System.out.println("Variável A: " + variavalA);
        System.out.println("Variável B: " + variavelB);
    }
}
