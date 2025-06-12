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
            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("------------Times-----------");
                    break;
                case 2:
                    JogoView.menuJogos();
                    break;
                case 3:
                    System.out.println("--------Campeonatos---------");
                    break;
                case 4:
                    menu = false;
                default:
                    throw new AssertionError();
            }

        } while (menu == true);

    }
}
