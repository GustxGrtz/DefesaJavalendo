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

}

