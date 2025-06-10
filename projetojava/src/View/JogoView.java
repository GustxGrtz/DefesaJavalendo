package View;

import Controller.JogoController;
import Model.Jogo;
import java.util.List;

public class JogoView {
    private JogoController jogoController;

    public JogoView(JogoController controller) {
        this.jogoController = controller;
    }

    public void exibirTodosOsJogos() {
        List<Jogo> jogos = jogoController.listarJogos();
        for (Jogo jogo : jogos) {
            jogo.exibirResumo();
        }
    }
}