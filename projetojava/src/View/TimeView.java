package View;

import Controller.TimeController;
import Model.Time;
import java.util.List;
import java.util.Scanner;

public class TimeView {
    private TimeController controller = new TimeController();
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n=== MENU TIMES ===");
            System.out.println("1. Cadastrar time");
            System.out.println("2. Listar times");
            System.out.println("3. Adicionar jogador");
            System.out.println("4. Exibir estatísticas");
            System.out.println("5. Editar time");
            System.out.println("6. Remover time");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarTime();
                case 2 -> listarTimes();
                case 3 -> adicionarJogador();
                case 4 -> exibirEstatisticas();
                case 5 -> editarTime();
                case 6 -> removerTime();
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }

    private void cadastrarTime() {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();
        controller.criar(nome);
        System.out.println("Time cadastrado!");
    }

    private void listarTimes() {
        List<Time> times = controller.listar();
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }
       for (int i = 0; i < times.size(); i++) {
        Time t = times.get(i);
        System.out.println("ID: " + t.getId() + " | Nome: " + t.getNome());
}

}
    }

    private void adicionarJogador() {
        listarTimes();
        System.out.print("Digite o ID do time: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Time time = controller.buscarPorId(id);
        if (time == null) {
            System.out.println("Time não encontrado.");
            return;
        }
        System.out.print("Nome do jogador: ");
        String jogador = scanner.nextLine();
        time.adicionarJogador(jogador);
        System.out.println("Jogador adicionado!");
    }

    private void exibirEstatisticas() {
        List<Time> times = controller.listar();
        if (times.isEmpty()) {
            System.out.println("Nenhum time cadastrado.");
            return;
        }
        for (Time t : times) {
            t.exibirResumo();
        }
    }

    private void editarTime() {
        listarTimes();
        System.out.print("Digite o ID do time para editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome do time: ");
        String novoNome = scanner.nextLine();

        boolean editado = controller.editar(id, novoNome);
        if (editado) {
            System.out.println("Time atualizado com sucesso!");
        } else {
            System.out.println("Time não encontrado.");
        }
    }

    private void removerTime() {
        listarTimes();
        System.out.print("Digite o ID do time para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removido = controller.remover(id);
        if (removido) {
            System.out.println("Time removido!");
        } else {
            System.out.println("Time não encontrado.");
        }
    }
}
