// === VIEW - CampeonatoView.java com controller compartilhado ===
package View;

import Controller.CampeonatoController;
import Model.Campeonato;
import Model.Time;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CampeonatoView {

    private static CampeonatoController controller;
    private static Scanner scan = new Scanner(System.in);

    public static void setController(CampeonatoController campeonatoController) {
        controller = campeonatoController;
    }

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

            Campeonato campeonato = new Campeonato(nomeCampeonato);
            controller.setCampeonato(campeonato);
            controller.criarCampeonato(campeonato);

            boolean adicionandoTimes = true;
            while (adicionandoTimes) {
                System.out.print("Nome do time (ou 'fim' para encerrar): ");
                String nomeTime = scan.nextLine();

                if (nomeTime.equalsIgnoreCase("fim")) {
                    adicionandoTimes = false;
                } else {
                    Time time = new Time(0, nomeTime, nomeTime);
                    campeonato.adicionarTime(time);
                }
            }

            System.out.println("Campeonato '" + nomeCampeonato + "' criado com " + campeonato.getTimes().size() + " time(s)!");
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
