// === VIEW - MenuView.java com controllers compartilhados ===
package View;

import Controller.CampeonatoController;
import Controller.JogoController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    public static void exibirMenuPrincipal() {
        boolean menu = true;
        Scanner scan = new Scanner(System.in);
        int op = 0;

        // Criar controllers compartilhados
        JogoController jogoController = new JogoController();
        CampeonatoController campeonatoController = new CampeonatoController(jogoController);

        // Configurar controllers nas views
        JogoView.setController(jogoController);
        CampeonatoView.setController(campeonatoController);

        do {
            try {
                System.out.println("-------------------Menu--------------------");
                System.out.println("Bem vindo ao Gerenciador de Campeonatos");
                System.out.println("Menu Principal");
                System.out.println("1 - Times");
                System.out.println("2 - Jogos");
                System.out.println("3 - Campeonato");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");
                op = scan.nextInt();
                scan.nextLine();
                TimeView tv = new TimeView();

                switch (op) {
                    case 1:
                        tv.exibirMenu();
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

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scan.nextLine();
            }
        } while (menu);
    }
}
