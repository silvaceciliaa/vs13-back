import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a palavra: ");
        String palavra = scanner.nextLine();

        switch (palavra){
            case "Cachorro":
                System.out.println("Dog");
                break;
            case "Dog":
                System.out.println("Cachorro");
                break;
            case "Tempo":
                System.out.println("Time");
                break;
            case "Time":
                System.out.println("Tempo");
                break;
            case "Amor":
                System.out.println("Love");
                break;
            case "Love":
                System.out.println("Amor");
                break;
            case "Cidade":
                System.out.println("City");
                break;
            case "City":
                System.out.println("Cidade");
                break;
            case "Feliz":
                System.out.println("Happy");
                break;
            case "Happy":
                System.out.println("Feliz");
                break;
            case "Triste":
                System.out.println("Sad");
                break;
            case "Sad":
                System.out.println("Triste");
                break;
            case "Deveria":
                System.out.println("Should");
                break;
            case "Should":
                System.out.println("Deveria");
                break;
            case "Poderia":
                System.out.println("Could");
                break;
            case "Could":
                System.out.println("Poderia");
                break;
            default:
                System.out.println("Essa palavra não é válida!");
                break;
        }
    }
}
