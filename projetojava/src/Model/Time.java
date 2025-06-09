package model;

import java.util.ArrayList;
import java.util.List;

public class Time extends EntidadeBase {
    private List<String> jogadores;
    private int vitorias;
    private int derrotas;

    public Time(int id, String nome) {
        super(id, nome);
        jogadores = new ArrayList<>();
        vitorias = 0;
        derrotas = 0;
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

    @Override
    public void exibirResumo() {
        System.out.println("Time: " + getNome() + " | Vitórias: " + vitorias + " | Derrotas: " + derrotas);
    }
}
//exemplo para deixar mais fácil de entender o puxe:
//Time t = new Time(1, "Furacão das galaxias");
//t.adicionarJogador("Fernandinho the best");
//t.adicionarJogador("Vitor Roque the greatest");

//List<String> lista = t.getJogadores();

//System.out.println(lista);