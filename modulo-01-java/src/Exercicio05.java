import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a altura do retângulo: ");
        double altura = scanner.nextDouble();

        System.out.print("Digite a base do retângulo: ");
        double base = scanner.nextDouble();

        double area = altura * base;

        System.out.println("Área "+ area);
    }
}
