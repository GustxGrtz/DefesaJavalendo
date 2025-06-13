package Controller;

import Model.Campeonato;
import Model.Jogo;
import Model.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CampeonatoController {
    private List<Campeonato> campeonatos = new ArrayList<>();
    private Campeonato campeonato;

    private final JogoController jogoController;

    public CampeonatoController(JogoController jogoController) {
        this.jogoController = jogoController;
    }

    public void gerarChaveamento() {
        if (campeonato == null || campeonato.getTimes().isEmpty()) {
            throw new IllegalStateException("Nenhum campeonato ou times disponíveis.");
        }

        List<Time> times = new ArrayList<>(campeonato.getTimes());

        if (times.size() % 2 != 0) {
            System.out.println("Número ímpar de times. Um time ficará de fora nesta rodada.");
            times.remove(times.size() - 1);
        }

        Collections.shuffle(times);

        for (int i = 0; i < times.size(); i += 2) {
            Jogo jogo = new Jogo(times.get(i), times.get(i + 1), LocalDate.now());
            campeonato.adicionarJogo(jogo);
            jogoController.adicionarJogo(jogo); // adiciona também ao controller compartilhado
        }
    }

    public void mostrarJogos() {
        if (campeonato == null || campeonato.getJogos().isEmpty()) {
            throw new IllegalStateException("Nenhum campeonato ou jogos disponíveis.");
        }
        campeonato.getJogos().forEach(Jogo::exibirResumo);
    }

    public void avancarFase() {
        if (campeonato == null || campeonato.getJogos().isEmpty()) {
            throw new IllegalStateException("Nenhum campeonato ou jogos para avançar.");
        }

        Campeonato novaFase = new Campeonato(campeonato.getNome() + " - Fase Seguinte");
        for (Jogo jogo : campeonato.getJogos()) {
            Time vencedor = jogo.getVencedor();
            if (vencedor != null) novaFase.adicionarTime(vencedor);
        }
        this.campeonato = novaFase;
        gerarChaveamento();
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public void criarCampeonato(Campeonato campeonato) {
        if (campeonato == null) throw new IllegalArgumentException("Campeonato inválido.");
        campeonatos.add(campeonato);
    }

    public List<Campeonato> listarCampeonatos() {
        return campeonatos;
    }
}