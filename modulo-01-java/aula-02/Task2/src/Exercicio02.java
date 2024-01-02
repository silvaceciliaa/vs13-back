import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numeroTentativa, numeroEscolhido = 168;

        System.out.println("Tente advinhar o número que estou pensando: ");

        do {
            numeroTentativa = scanner.nextInt();

            if (numeroTentativa == numeroEscolhido) {
                System.out.println("Parabéns! Número correto.");
            }
            else if (numeroTentativa < numeroEscolhido) {
                System.out.println("Errou! Escolha um número maior");
            }
            else {
                System.out.println("Errou! Escolha um número menor");
            }

        } while (numeroTentativa != numeroEscolhido);

       scanner.close();
    }
}
