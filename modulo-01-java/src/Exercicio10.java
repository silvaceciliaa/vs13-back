import  java.util.Scanner;
public class Exercicio10 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

    String conceito = "", mensagem = "";

        System.out.print("Digite o número de identificação do aluno: ");
        int idAluno = scanner.nextInt();

        System.out.print("Digite a nota 1: ");
        double notaUm = scanner.nextInt();

        System.out.print("Digite a nota 2: ");
        double notaDois = scanner.nextInt();

        System.out.print("Digite a nota 3: ");
        double notaTres = scanner.nextInt();

        System.out.print("Digite média dos exercícios: ");
        double mediaExercicio = scanner.nextDouble();

        double mediaAproveitamento = (notaUm + (notaDois * 2) + (notaTres * 3) + mediaExercicio) / 7;

        if (mediaAproveitamento >= 9.0) {
            conceito = "A";
        } else if (mediaAproveitamento >= 7.5 && mediaAproveitamento < 9.0) {
            conceito = "B";
        } else if (mediaAproveitamento >= 6.0 && mediaAproveitamento < 7.5) {
            conceito = "C";
        } else if (mediaAproveitamento >= 4.0 && mediaAproveitamento < 6.0) {
            conceito = "D";
        } else if (mediaAproveitamento < 4.0) {
            conceito = "E";
        }

        if (conceito == "A" ||  conceito == "B" || conceito == "C") {
            mensagem = "Aprovado";
        }
        else {
            mensagem = "Reprovado";
        }

        System.out.println("Aluno: "+ idAluno + "\nNotas: \nNota1 - " + notaUm + "\nNota 2 - " + notaDois + "\nNota 3 - " + notaTres + "\nMédia de Aproveitamento: " + mediaAproveitamento + "\nConceito: " + conceito + "\nMensagem: " + mensagem);

        scanner.close();
    }
}
