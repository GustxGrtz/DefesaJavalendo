package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Jogo extends EntidadeBase implements Serializable {

    public Jogo(int id, String nome) {
        super(id, nome);
    }

    private Time timeCasa;
    private Time timeFora;
    private int golsCasa;
    private int golsFora;
    private LocalDate data;

    public void registrarResultado(int golsCasa, int golsFora) {
        this.golsCasa = golsCasa;
        this.golsFora = golsFora;
    }

    public Time getVencedor() {
        if (golsCasa > golsFora) return timeCasa;
        else if (golsFora > golsCasa) return timeFora;
        else return null;
    }

    @Override
    public void exibirResumo() {
        System.out.println(timeCasa.getNome() + " " + golsCasa + " x " + golsFora + " " + timeFora.getNome());
    }

}