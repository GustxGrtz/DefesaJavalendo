package Model;

import java.io.Serializable;

public class Estatistica implements Serializable {
    private static final long serialVersionUID = 1L;

    private int jogos = 0;
    private int vitorias = 0;
    private int empates = 0;
    private int derrotas = 0;
    private int golsMarcados = 0;
    private int golsSofridos = 0;

    public void registrarJogo(int golsFeitos, int golsTomados) {
        jogos++;
        golsMarcados += golsFeitos;
        golsSofridos += golsTomados;

        if (golsFeitos > golsTomados) {
            vitorias++;
        } else if (golsFeitos == golsTomados) {
            empates++;
        } else {
            derrotas++;
        }
    }

    public void exibirEstatisticas(String nomeTime) {
        System.out.println("\n--- Estatísticas do Time: " + nomeTime + " ---");
        System.out.println("Jogos: " + jogos);
        System.out.println("Vitórias: " + vitorias);
        System.out.println("Empates: " + empates);
        System.out.println("Derrotas: " + derrotas);
        System.out.println("Gols Marcados: " + golsMarcados);
        System.out.println("Gols Sofridos: " + golsSofridos);
    }

    // Getters (se necessário)
    public int getJogos() { return jogos; }
    public int getVitorias() { return vitorias; }
    public int getEmpates() { return empates; }
    public int getDerrotas() { return derrotas; }
    public int getGolsMarcados() { return golsMarcados; }
    public int getGolsSofridos() { return golsSofridos; }
}
