package View;

import Controller.CampeonatoController;
import Model.Campeonato;
import java.util.Scanner;

public class CampeonatoView {

    private static CampeonatoController controller = new CampeonatoController();

    public static void menuCampeonatos() {

        Scanner scan = new Scanner(System.in);
        boolean menu = true;
        int op;

        do {
            System.out.println("------------Campeonatos-----------");
            System.out.println("1 - Criar campeonato");
            System.out.println("2 - Iniciar chaveamento");
            System.out.println("3 - Mostrar jogos");
            System.out.println("4 - Avançar para próxima fase");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            op = scan.nextInt();
            scan.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    criarCampeonato(scan);
                    break;
                case 2:
                    controller.gerarChaveamento();
                    break;
                case 3:
                    controller.mostrarJogos();
                    break;
                case 4:
                    controller.avancarFase();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (menu);
    }

    private static void criarCampeonato(Scanner scan) {
        System.out.print("Digite o nome do campeonato: ");
        String nome = scan.nextLine();
        Campeonato campeonato = new Campeonato(nome);
        controller.setCampeonato(campeonato);
        System.out.println("Campeonato criado com sucesso!");
    }
}
