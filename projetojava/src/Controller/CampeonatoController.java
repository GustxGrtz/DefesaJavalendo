package Controller;

import Model.Campeonato;
import Model.Jogo;
import Model.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CampeonatoController {
    private Campeonato campeonato;

    public CampeonatoController(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

public void gerarChaveamento() {
    List<Time> times = campeonato.getTimes();

    // Garante número par de times, se ímpar remove o último ou pode adicionar um "bye"
    if (times.size() % 2 != 0) {
        System.out.println("Número ímpar de times. Um time ficará de fora nesta rodada.");
        times = new ArrayList<>(times); // Evita modificar a lista original
        times.remove(times.size() - 1); // ou implemente lógica de "bye"
    }

    Collections.shuffle(times); // Embaralha os times para sortear os confrontos

    for (int i = 0; i < times.size(); i += 2) {
        Time timeCasa = times.get(i);
        Time timeFora = times.get(i + 1);

        // Cria o jogo com o novo construtor (já corrigido)
        Jogo jogo = new Jogo(timeCasa, timeFora, java.time.LocalDate.now());

        // Adiciona o jogo ao campeonato
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
