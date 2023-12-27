import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int duracaoHoras, duracaoMinutos, minutosDia = 1440, minutosTotal;

        System.out.print("Hora em que o jogo iniciou: ");
        int horarioInicioHoras = scanner.nextInt();

        System.out.print("Minuto em que o jogo iniciou: ");
        int horarioInicioMinutos = scanner.nextInt();

        System.out.print("Hora em que o jogo terminou: ");
        int horarioFimHoras = scanner.nextInt();

        System.out.print("Minuto em que o jogo terminou: ");
        int horarioFimMinutos = scanner.nextInt();

        int minutosInicioTotal = horarioInicioHoras * 60 + horarioInicioMinutos;
        int minutosFimTotal = horarioFimHoras * 60 + horarioFimMinutos;

        if (minutosInicioTotal <= minutosFimTotal) {
            minutosTotal = minutosFimTotal - minutosInicioTotal;
        } else {
            minutosTotal = minutosDia - minutosInicioTotal + minutosFimTotal;
        }

        duracaoHoras = minutosTotal / 60;
        duracaoMinutos = minutosTotal % 60;


        System.out.println("O JOGO DUROU " + duracaoHoras + "HORA(S) E " + duracaoMinutos + " MINUTO(S)");

        scanner.close();
    }
}
