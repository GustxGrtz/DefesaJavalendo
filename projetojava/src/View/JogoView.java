package View;

import Controller.JogoController;
import Model.Jogo;
import java.util.List;
import java.util.Scanner;

public class JogoView {

    private static JogoController jogoController;

    public static void menuJogos() {

        boolean menu = true;
        Scanner scan = new Scanner(System.in);
        int op;

        do {

            System.out.println("------------Jogos-----------");
            System.out.println("Digite uma opção!");
            System.out.println("1 - Criar");
            System.out.println("2 - Editar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("5 - Sair");
            op = scan.nextInt();

            switch (op) {
                case 1:
                    JogoView.adicionarJogo();
                    break;
                case 2:
                    JogoView.editarJogo();
                    break;
                case 3:
                    JogoView.removerJogo();
                case 4:
                    JogoView.exibirTodosOsJogos();
                    break;
                case 5:
                    menu = false;
                default:
                    throw new AssertionError();
            }

        } while (menu == true);

    }

    private static void removerJogo() {
        throw new UnsupportedOperationException("Unimplemented method 'removerJogo'");
    }

    private static void editarJogo() {
        throw new UnsupportedOperationException("Unimplemented method 'editarJogo'");
    }

    private static void adicionarJogo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public JogoView(JogoController controller) {
        this.jogoController = controller;
    }

    public static void exibirTodosOsJogos() {
        List<Jogo> jogos = jogoController.listarJogos();
        for (Jogo jogo : jogos) {
            jogo.exibirResumo();
        }
    }
}