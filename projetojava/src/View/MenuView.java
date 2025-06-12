package View;

import java.util.Scanner;

public class MenuView {

    public static void exibirMenuPrincipal(){

    Scanner scan = new Scanner(System.in);

    boolean menu = true;

    int op;

        do{

            System.out.println("Menu Principal");
            System.out.println("1 - Times");
            System.out.println("2 - Jogos");
            System.out.println("3 - Campeonato");
            System.out.println("4 - Sair");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    System.out.println("a");
                    break;
                case 4:
                    menu = false;
                default:
                    throw new AssertionError();
            }

        }while (menu == true);


    }
}
