import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double percentualAumento = 0;

        System.out.println("Digite o código do cargo:");
        int codigoCargo = scanner.nextInt();

        System.out.println("Digite o valor do salário atual:");
        double salarioAtual = scanner.nextDouble();

        switch (codigoCargo) {
            case 101:
                percentualAumento = 0.10;
                break;
            case 102:
                percentualAumento = 0.20;
                break;
            case 103:
                percentualAumento = 0.30;
                break;
            default:
                percentualAumento = 0.40;
                break;
        }

        double aumento = salarioAtual * percentualAumento;
        double novoSalario = salarioAtual + aumento;
        double diferenca = aumento;

        System.out.println("Salário anterior: " + salarioAtual);
        System.out.println("Novo salário " + novoSalario);
        System.out.println("Diferença " + diferenca);

        scanner.close();
    }
}
