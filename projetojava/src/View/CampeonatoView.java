package View;

import Controller.CampeonatoController;
import Controller.JogoController;
import Model.Jogo;
import Model.Time;
import java.time.LocalDate;
import java.util.Scanner;

public class CampeonatoView {

    private static CampeonatoController controller = new CampeonatoController();
    private static JogoController jogoController = new JogoController();

    private static Scanner scan = new Scanner(System.in);

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
                    criarCampeonato();
                    break;
                case 2:
                    gerarChaveamento();
                    break;
                case 3:
                    mostrarJogos();
                    break;
                case 4:
                    avancarFase();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (menu);
    }

    private static void criarCampeonato() {
        System.out.print("Nome do Campeonato ");
        String nomeCasa = scan.nextLine();
        System.out.print("Nome do time de fora: ");
        String nomeFora = scan.nextLine();

        Time timeCasa = new Time(0, nomeCasa, nomeCasa);
        Time timeFora = new Time(0, nomeFora, nomeFora);

        Jogo jogo = new Jogo(timeCasa, timeFora, LocalDate.now());
        jogoController.adicionarJogo(jogo);

        System.out.println("Jogo adicionado com sucesso!");
    }

    private static void gerarChaveamento() {
        try {
            controller.gerarChaveamento();
            System.out.println("Chaveamento gerado com sucesso!");
        } catch (NullPointerException e) {
            System.out.println("Erro: Crie o campeonato antes de gerar o chaveamento.");
        }
    }

    private static void mostrarJogos() {
        try {
            controller.mostrarJogos();
        } catch (NullPointerException e) {
            System.out.println("Erro: Nenhum campeonato encontrado. Crie um primeiro.");
        }
    }

    private static void avancarFase() {
        try {
            controller.avancarFase();
            System.out.println("Fase avançada com sucesso!");
        } catch (NullPointerException e) {
            System.out.println("Erro: Crie um campeonato com jogos antes de avançar a fase.");
        }
    }
}
