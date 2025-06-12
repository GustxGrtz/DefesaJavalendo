package Controller;

import Model.Jogo;
import java.util.ArrayList;
import java.util.List;

public class JogoController {
    private List<Jogo> jogos = new ArrayList<>();

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public void registrarResultado(Jogo jogo, int golsCasa, int golsFora) {
        jogo.registrarResultado(golsCasa, golsFora);
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }
}