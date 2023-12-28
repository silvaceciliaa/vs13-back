import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precoComDesconto, precoTotal;

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        System.out.print("Digite o preço do produto: R$ ");
        double precoProduto = scanner.nextDouble();

        System.out.println();
        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço R$: " + precoProduto);

        System.out.println("Promoção: " + nomeProduto);
        System.out.println("------------------------");

        double desconto = 0.05;
        for (int quantidade = 1; quantidade <= 10; quantidade++) {
            precoComDesconto = precoProduto * (1 - desconto);
            precoTotal = precoComDesconto * quantidade;

            System.out.printf("%d x R$ %.2f = R$ %.2f\n", quantidade, precoComDesconto, precoTotal);

            desconto += 0.05;
        }
    }
}
