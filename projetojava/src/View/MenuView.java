package View;

import java.util.Scanner;

public class MenuView {

    public static void exibirMenuPrincipal() {

        boolean menu = true;
        Scanner scan = new Scanner(System.in);
        int op;

        do {
            System.out.println("Bem vindo ao Gerenciador de Campeonatos");
            System.out.println("Menu Principal");
            System.out.println("1 - Times");
            System.out.println("2 - Jogos");
            System.out.println("3 - Campeonato");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("------------Times-----------");
                    break;
                case 2:
                    JogoView.menuJogos();
                    break;
                case 3:
                    CampeonatoView.menuCampeonatos();
                    break;
                case 4:
                    menu = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (menu);
    }
}
