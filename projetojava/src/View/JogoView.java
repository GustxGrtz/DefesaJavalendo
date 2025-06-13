package View;

import Controller.JogoController;
import Model.Jogo;
import Model.Time;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JogoView {

    private static JogoController jogoController;
    private static Scanner scan = new Scanner(System.in);

    public static void setController(JogoController controller) {
        jogoController = controller;
    }

    public static void menuJogos() {
        boolean menu = true;
        int op;

        do {
            try {
                System.out.println("------------Jogos-----------");
                System.out.println("1 - Criar jogo");
                System.out.println("2 - Editar resultado");
                System.out.println("3 - Remover jogo");
                System.out.println("4 - Listar jogos");
                System.out.println("5 - Sair");
                System.out.print("Escolha uma opção: ");
                op = scan.nextInt();
                scan.nextLine();

                switch (op) {
                    case 1 -> adicionarJogo();
                    case 2 -> editarJogo();
                    case 3 -> removerJogo();
                    case 4 -> exibirTodosOsJogos();
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

    private static void adicionarJogo() {
        try {
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
            System.out.println("Erro ao adicionar jogo: " + e.getMessage());
        }
    }

    private static void editarJogo() {
        try {
            List<Jogo> jogos = jogoController.listarJogos();
            if (jogos.isEmpty()) {
                System.out.println("Nenhum jogo encontrado.");
                return;
            }

            exibirTodosOsJogosNumerados();

            System.out.print("Digite o número do jogo a ser editado: ");
            int index = scan.nextInt();
            scan.nextLine();

            if (index < 1 || index > jogos.size()) {
                System.out.println("Índice inválido.");
                return;
            }

            Jogo jogo = jogos.get(index - 1);

            System.out.print("Gols do " + jogo.getTimeCasa().getNome() + ": ");
            int golsCasa = scan.nextInt();
            System.out.print("Gols do " + jogo.getTimeFora().getNome() + ": ");
            int golsFora = scan.nextInt();

            jogoController.registrarResultado(jogo, golsCasa, golsFora);
            System.out.println("Resultado atualizado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido.");
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao editar jogo: " + e.getMessage());
            scan.nextLine();
        }
    }

    private static void removerJogo() {
        try {
            List<Jogo> jogos = jogoController.listarJogos();
            if (jogos.isEmpty()) {
                System.out.println("Nenhum jogo para remover.");
                return;
            }

            exibirTodosOsJogosNumerados();

            System.out.print("Digite o número do jogo a remover: ");
            int index = scan.nextInt();
            scan.nextLine();

            jogoController.removerJogo(index - 1);
            System.out.println("Jogo removido com sucesso.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, digite um número válido.");
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao remover jogo: " + e.getMessage());
            scan.nextLine();
        }
    }

    public static void exibirTodosOsJogos() {
        List<Jogo> jogos = jogoController.listarJogos();
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
            return;
        }

        for (Jogo jogo : jogos) {
            jogo.exibirResumo();
        }
    }

    private static void exibirTodosOsJogosNumerados() {
        List<Jogo> jogos = jogoController.listarJogos();
        int i = 1;
        for (Jogo jogo : jogos) {
            System.out.print(i + " - ");
            jogo.exibirResumo();
            i++;
        }
    }
}