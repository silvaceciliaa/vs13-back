import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[][] cotacao = {
                {3.50, 3.99, 3.25},
                {10.50, 11.99, 15.05},
                {1.55, 2.15, 2.15},
                {23.03, 25.55, 20.99},
                {8.30, 8.98, 8.24},
                {17.43, 18.98, 18.04},
                {6.40, 5.97, 6.12},
                {12.99, 13.99, 12.90},
                {9.36, 10.56, 10.07},
                {32.99, 31.21, 30.99}
        };

        double menorSoma = 0;
        int mercadoMaisBarato = 0;

        for (int i = 0; i < cotacao.length; i++) {
            menorSoma += cotacao[i][0];
        }

        for (int j = 1; j < cotacao[0].length; j++) {
            double somaColuna = 0;

            for (int i = 0; i < cotacao.length; i++) {
                somaColuna += cotacao[i][j];
            }

            if (somaColuna < menorSoma) {
                menorSoma = somaColuna;
                mercadoMaisBarato = j;
            }
        }

        System.out.println("Mercado mais barato: " + (mercadoMaisBarato + 1));
    }
}
