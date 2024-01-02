import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numeros = { 5, 8, 3, 10, 8, 15, 6, 8, 7, 9 };
        int numerosRepetidos = 0, numerosMenores = 0, numerosMaiores = 0;

        System.out.print("Digite um número: ");
        int numeroDigitado = scanner.nextInt();


        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroDigitado){
                numerosRepetidos++;
            }
            if (numeros[i] > numeroDigitado){
                numerosMaiores++;
            }
            if (numeros[i] < numeroDigitado){
                numerosMenores++;
            }
        }

        System.out.println("Quantas vezes " + numeroDigitado + " existe no vetor: " + numerosRepetidos);
        System.out.println("Quantos números são menores que " + numeroDigitado + " : " + numerosMenores);
        System.out.println("Quantos números são maiores que " + numeroDigitado + " : " + numerosMaiores);

        scanner.close();
    }
}
