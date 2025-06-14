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

        TimeView timeView = new TimeView();
        timeView.mostrarEstatisticasTime(); // chame o método

        JogoController jogoController = new JogoController();
        CampeonatoController campeonatoController = new CampeonatoController(jogoController);

        JogoView.setController(jogoController);
        CampeonatoView.setController(campeonatoController);

        do {
            try {
                System.out.println("---------------------------------------");
                System.out.println("Bem vindo ao Gerenciador de Campeonatos");
                System.out.println("Menu Principal");
                System.out.println("1 - Times");
                System.out.println("2 - Jogos");
                System.out.println("3 - Campeonato");
                System.out.println("4 - Sair");
                System.out.println("5 - Ver Estatísticas de um Time");
                System.out.print("Escolha uma opção: ");
                op = scan.nextInt();
                scan.nextLine();

                switch (op) {
                    case 1:
                        timeView.exibirMenu();
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
                    case 5:
                        timeView.mostrarEstatisticasTime();
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
