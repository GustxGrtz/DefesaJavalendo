package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Time extends EntidadeBase implements Serializable{
    private List<String> jogadores;
    private int vitorias;
    private int derrotas;
    private String nomeTime;

    public Time(int id, String nomeTime, String nome) {
        super(id, nome);
        this.jogadores = new ArrayList<>();
        this.vitorias = 0;
        this.derrotas = 0;
        this.nomeTime = nomeTime;
    }

    public void adicionarJogador(String jogador) {
        jogadores.add(jogador);
    }

    public List<String> getJogadores() {
        return jogadores;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void registrarVitoria() {
        vitorias++;
    }

    public void registrarDerrota() {
        derrotas++;
    }

    public String getNomeTime() {
    return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    @Override
    public void exibirResumo() {
        System.out.println("Nome do time: " + getNomeTime() + "Time: " + getNome() + " | Vitórias: " + vitorias + " | Derrotas: " + derrotas);
    }

    @Override
    public String toString() {
    return "Time{" +
            "nomeTime='" + nomeTime + '\'' +
            ", nome='" + getNome() + '\'' +
            ", vitorias=" + vitorias +
            ", derrotas=" + derrotas +
            ", jogadores=" + jogadores +
            '}';
}

}
//exemplo para deixar mais fácil de entender o puxe:
//Time t = new Time(1, "Furacão das galaxias");
//t.adicionarJogador("Fernandinho the best");
//t.adicionarJogador("Vitor Roque the greatest");

//List<String> lista = t.getJogadores();

//System.out.println(lista);

