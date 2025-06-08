package View;

import java.util.Scanner;

public class MenuView {
    
    Scanner scan = new Scanner(System.in);

    public int exibirMenuPrincipal(){
        System.out.println("Menu Principal");
        System.out.println("1 - Times");
        System.out.println("2 - Jogos");
        System.out.println("3 - Campeonato");
        System.out.println("4 - Sair");
        return scan.nextInt();
    }
}
