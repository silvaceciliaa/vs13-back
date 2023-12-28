import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        String nome, jogadorMaisVelho = "", jogadorMaisPesado = "";
        int idade, jogadoresCadastrados = 0, idadeMaisVelho = 0;
        double altura, peso, alturaMaiorJogador = 0, mediaAlturas, pesoJogadorMaisPesado = 0, totalAlturas = 0;

        while (loop) {
            System.out.print("Informe o nome do jogador: ");
            nome = scanner.next();

            if (nome.equals("SAIR")){
                break;
            }

            System.out.print("Informe a idade do jogador: ");
            idade = scanner.nextInt();

            System.out.print("Informe a altura do jogador: ");
            altura = scanner.nextDouble();

            System.out.print("Informe o peso do jogador: ");
            peso = scanner.nextDouble();

            jogadoresCadastrados++;

            if (altura > alturaMaiorJogador) {
                alturaMaiorJogador = altura;
            }

            if (idade > idadeMaisVelho) {
                idadeMaisVelho = idade;
                jogadorMaisVelho = nome;
            }

            if (peso > pesoJogadorMaisPesado) {
                pesoJogadorMaisPesado = peso;
                jogadorMaisPesado = nome;
            }

            totalAlturas += altura;
        }

        mediaAlturas = totalAlturas / jogadoresCadastrados;

        System.out.println("Quantidade de jogadores cadastrados: " + jogadoresCadastrados);
        System.out.println("Altura maior jogador: " + alturaMaiorJogador);
        System.out.println("Jogador mais velho: " + jogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + jogadorMaisPesado);
        System.out.printf("Média alturas: %.2f\n", mediaAlturas);

        scanner.close();
    }
}
