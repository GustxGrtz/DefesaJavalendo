// === VIEW - CampeonatoView.java com tratamento ===
package View;

import Controller.CampeonatoController;
import Controller.JogoController;
import Model.Jogo;
import Model.Time;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CampeonatoView {

    private static CampeonatoController controller = new CampeonatoController();
    private static JogoController jogoController = new JogoController();
    private static Scanner scan = new Scanner(System.in);

    public static void menuCampeonatos() {
        boolean menu = true;
        int op;

        do {
            try {
                System.out.println("------------Campeonatos-----------");
                System.out.println("1 - Criar campeonato");
                System.out.println("2 - Iniciar chaveamento");
                System.out.println("3 - Mostrar jogos");
                System.out.println("4 - Avançar para próxima fase");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opção: ");
                op = scan.nextInt();
                scan.nextLine();

                switch (op) {
                    case 1 -> criarCampeonato();
                    case 2 -> gerarChaveamento();
                    case 3 -> mostrarJogos();
                    case 4 -> avancarFase();
                    case 5 -> menu = false;
                    default -> System.out.println("Opção inválida. Tente novamente.");
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

    private static void criarCampeonato() {
        try {
            System.out.print("Nome do Campeonato: ");
            String nomeCampeonato = scan.nextLine();
            System.out.print("Nome do time da casa: ");
            String nomeCasa = scan.nextLine();
            System.out.print("Nome do time de fora: ");
            String nomeFora = scan.nextLine();

            Time timeCasa = new Time(0, nomeCasa, nomeCasa);
            Time timeFora = new Time(0, nomeFora, nomeFora);

            Jogo jogo = new Jogo(timeCasa, timeFora, LocalDate.now());
            jogoController.adicionarJogo(jogo);

            System.out.println("Jogo adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar campeonato: " + e.getMessage());
        }
    }

    private static void gerarChaveamento() {
        try {
            controller.gerarChaveamento();
            System.out.println("Chaveamento gerado com sucesso!");
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void mostrarJogos() {
        try {
            controller.mostrarJogos();
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void avancarFase() {
        try {
            controller.avancarFase();
            System.out.println("Fase avançada com sucesso!");
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
