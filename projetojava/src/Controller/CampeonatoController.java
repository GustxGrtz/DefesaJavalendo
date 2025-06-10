package Controller;

import Model.Campeonato;
import Model.Jogo;
import Model.Time;
import java.util.Collections;
import java.util.List;

public class CampeonatoController {
    private Campeonato campeonato;

    public CampeonatoController(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public void gerarChaveamento() {
        List<Time> times = campeonato.getTimes();
        Collections.shuffle(times);
        for (int i = 0; i < times.size() - 1; i += 2) {
            Jogo jogo = new Jogo(times.get(i), times.get(i + 1), java.time.LocalDate.now());
            campeonato.adicionarJogo(jogo);
        }
    }

    public void mostrarJogos() {
        campeonato.getJogos().forEach(Jogo::exibirResumo);
    }

    public void avancarFase() {
        List<Jogo> jogos = campeonato.getJogos();
        Campeonato novaFase = new Campeonato(campeonato.getNome() + " - Fase Seguinte");
        for (Jogo jogo : jogos) {
            Time vencedor = jogo.getVencedor();
            if (vencedor != null) novaFase.adicionarTime(vencedor);
        }
        this.campeonato = novaFase;
        gerarChaveamento();
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }
}
