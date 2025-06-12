package View;

import Controller.JogoController;
import Model.Jogo;
import Model.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class JogoView {

    private static JogoController jogoController = new JogoController();
    private static Scanner scan = new Scanner(System.in);

    public static void menuJogos() {
        boolean menu = true;
        int op;

        do {
            System.out.println("------------Jogos-----------");
            System.out.println("1 - Criar jogo");
            System.out.println("2 - Editar resultado");
            System.out.println("3 - Remover jogo");
            System.out.println("4 - Listar jogos");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            op = scan.nextInt();
            scan.nextLine(); // limpar buffer

            switch (op) {
                case 1:
                    adicionarJogo();
                    break;
                case 2:
                    editarJogo();
                    break;
                case 3:
                    removerJogo();
                    break;
                case 4:
                    exibirTodosOsJogos();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (menu);
    }

    private static void adicionarJogo() {
        System.out.print("Nome do time da casa: ");
        String nomeCasa = scan.nextLine();
        System.out.print("Nome do time de fora: ");
        String nomeFora = scan.nextLine();

        Time timeCasa = new Time(0, nomeCasa, nomeCasa);
        Time timeFora = new Time(0, nomeFora, nomeFora);

        Jogo jogo = new Jogo(timeCasa, timeFora, LocalDate.now());
        jogoController.adicionarJogo(jogo);

        System.out.println("Jogo adicionado com sucesso!");
    }

    private static void editarJogo() {
        List<Jogo> jogos = jogoController.listarJogos();
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo encontrado.");
            return;
        }

        exibirTodosOsJogosNumerados();

        System.out.print("Digite o número do jogo a ser editado: ");
        int index = scan.nextInt();
        scan.nextLine(); // limpar buffer

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
    }

    private static void removerJogo() {
        List<Jogo> jogos = jogoController.listarJogos();
        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo para remover.");
            return;
        }

        exibirTodosOsJogosNumerados();

        System.out.print("Digite o número do jogo a remover: ");
        int index = scan.nextInt();
        scan.nextLine(); // limpar buffer

        if (index < 1 || index > jogos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        jogos.remove(index - 1);
        System.out.println("Jogo removido com sucesso.");
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
