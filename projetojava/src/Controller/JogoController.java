package Controller;

import Model.Jogo;
import java.util.ArrayList;
import java.util.List;

public class JogoController {
    private List<Jogo> jogos = new ArrayList<>();

    public void adicionarJogo(Jogo jogo) {
        if (jogo == null) throw new IllegalArgumentException("Jogo inválido.");
        jogos.add(jogo);
    }

    public void registrarResultado(Jogo jogo, int golsCasa, int golsFora) {
        if (jogo == null) throw new IllegalArgumentException("Jogo inválido.");
        if (golsCasa < 0 || golsFora < 0) throw new IllegalArgumentException("Gols não podem ser negativos.");
        jogo.registrarResultado(golsCasa, golsFora);
    }

    public void removerJogo(int index) {
        if (index < 0 || index >= jogos.size()) throw new IndexOutOfBoundsException("Índice inválido.");
        jogos.remove(index);
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }
}  