import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] alunos = new int[5][4];

        int notaFinal = 0, mediaNotasFinais = 0, maiorNotaFinal = 0, matriculaMaiorNota = 0, totalNotasFinais = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe a matrícula, média das provas e média dos trabalhos do aluno " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                alunos[i][j] = scanner.nextInt();
            }

            notaFinal = (int) (alunos[i][1] * 0.6) + (int) (alunos[i][2] * 0.4);
            alunos[i][3] = notaFinal;

            if (notaFinal > maiorNotaFinal) {
                maiorNotaFinal = notaFinal;
                matriculaMaiorNota = alunos[i][0];
            }

            totalNotasFinais += notaFinal;
        }

        mediaNotasFinais = totalNotasFinais / 5;

        System.out.printf("Matrícula que obteve maior nota final: %d\n", matriculaMaiorNota);
        System.out.printf("Média das notas finais: %d\n", mediaNotasFinais);

        scanner.close();
    }
}
