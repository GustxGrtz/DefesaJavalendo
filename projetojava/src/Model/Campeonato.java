package Model;

import java.util.ArrayList;
import java.util.List;

public class Campeonato extends EntidadeBase {

    private static int id;



    public Campeonato(String nome) {
        super(id, nome);
    }

    private String nome;
    private List<Time> times = new ArrayList<>();
    private List<Jogo> jogos = new ArrayList<>();



    public void adicionarTime(Time time) {
        times.add(time);
    }

    public void adicionarJogo(Jogo jogo) {
        jogos.add(jogo);
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public List<Time> getTimes() {
        return times;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Campeonato: " + nome);
        jogos.forEach(Jogo::exibirResumo);
    }
}

