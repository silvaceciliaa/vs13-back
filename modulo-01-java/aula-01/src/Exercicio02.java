import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcaoMenuIf;

        System.out.println("Selecione um dos estados: \n1 - Pernambuco \n2 - Rio de Janeiro \n3 - Santa Catarina ");
        int opcaoMenu = scanner.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("Selecione uma das cidades de Pernambuco:\n1 - Recife\n2 - Paulista");
                opcaoMenuIf = scanner.nextInt();

                if (opcaoMenuIf == 1) {
                    System.out.println("__Recife__ \nPopulação: 1.488.920 pessoas \nPrincipal festa: Carnaval do Recife \nIDH: 0,772");
                }
                else if (opcaoMenuIf == 2) {
                    System.out.println("__Paulista__ \nPopulação: 334,376 pessoas \nPrincipal festa: Festa da Padroeira \nIDH: 0,732");
                }
                else{
                    System.out.print("Opção inválida");
                }
                break;
            case 2:
                System.out.println("Selecione uma das cidades do Rio de Janeiro:\n1 - Rio de Janeiro \n2 - Niterói");
                opcaoMenuIf = scanner.nextInt();

                if (opcaoMenuIf == 1) {
                    System.out.println("__Rio de Janeiro__ \nPopulação: 6.211.423 pessoas \nPrincipal festa: Carnaval \nIDH: 0,842");
                }
                else if (opcaoMenuIf == 2) {
                    System.out.println("__Niterói__ \nPopulação: 481 749 pessoas \nPrincipal festa:  Festa do Dia de Reis \nIDH: 0,886");
                }
                else{
                    System.out.print("Opção inválida");
                }
                break;
            case 3:
                System.out.println("Selecione uma das cidades de Santa Catarina:\n1 - Blumenau \n2 - Pomerode");
                opcaoMenuIf = scanner.nextInt();

                if (opcaoMenuIf == 1) {
                    System.out.println("__Blumenau__ \nPopulação: 361,855 pessoas \nPrincipal festa: Oktoberfest \nIDH: 0,805");
                }
                else if (opcaoMenuIf == 2) {
                    System.out.println("__Pomerode__ \nPopulação: 34.289 pessoas \nPrincipal festa:  Osterfest \nIDH: 0,780");
                }
                else{
                    System.out.print("Opção inválida");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}
