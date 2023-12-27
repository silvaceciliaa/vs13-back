import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double valorTotal = 0;

        System.out.print("Digite o código do produto: ");
        String codigo = scanner.next();

        System.out.print("Digite a quantidade comprada: ");
        int quantidade = scanner.nextInt();

        switch (codigo){
            case "ABCD":
                valorTotal = 5.30 * quantidade;
                break;
            case "XYPK":
                valorTotal = 6.00 * quantidade;
                break;
            case "KLMP":
                valorTotal = 3.20 * quantidade;
                break;
            case "QRST":
                valorTotal = 2.50 * quantidade;
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        System.out.println("Valor Total: " + valorTotal);

        scanner.close();
    }
}
