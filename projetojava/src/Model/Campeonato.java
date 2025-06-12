package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Campeonato extends EntidadeBase implements Serializable {

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
<<<<<<< HEAD
}
=======
}
>>>>>>> 487112c210f6a9ad9201f63ae0f3ba31691ff895
