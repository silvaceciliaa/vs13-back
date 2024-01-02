import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número total de eleitores: ");
        int totalEleitores = scanner.nextInt();

        System.out.print("Digite o número total de votos brancos: ");
        int votosBrancos = scanner.nextInt();

        System.out.print("Digite o número total de votos nulos: ");
        int votosNulos = scanner.nextInt();

        System.out.print("Digite o número total de votos válidos: ");
        int votosValidos = scanner.nextInt();

        double percentualBrancos = (votosBrancos * 100.0) / totalEleitores;
        double percentualNulos = (votosNulos * 100.0) / totalEleitores;
        double percentualValidos = (votosValidos * 100.0) / totalEleitores;

        System.out.println("Percentual votos brancos: " + percentualBrancos + "%");
        System.out.println("Percentual votos nulos: " + percentualNulos + "%");
        System.out.println("Percentual votos válidos: " + percentualValidos + "%");

        scanner.close();
    }
}
