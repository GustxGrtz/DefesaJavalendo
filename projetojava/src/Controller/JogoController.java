package Controller;

import Model.Jogo;
import java.util.ArrayList;
import java.util.List;

public class JogoController {
    private List<Jogo> jogos = new ArrayList<>();
    private final String caminhoArquivo = "dados/jogos.txt";

    public JogoController() {
        carregar();
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
        salvar();
    }

    public void registrarResultado(Jogo jogo, int golsCasa, int golsFora) {
        jogo.registrarResultado(golsCasa, golsFora);
        salvar();
    }

    public List<Jogo> listarJogos() {
        return jogos;
    }

    private void salvar() {
        Serializador.salvarLista(caminhoArquivo, jogos);
    }

    private void carregar() {
        jogos = Serializador.carregarLista(caminhoArquivo);
    }


    public boolean removerJogo(int index) {
        if (index >= 0 && index < jogos.size()) {
            jogos.remove(index);
            salvar();
            return true;
        }
        return false;
    }
}
