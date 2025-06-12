package Model;
import java.time.LocalDate;

public class Jogo extends EntidadeBase {

    private Time timeCasa;
    private Time timeFora;
    private int golsCasa;
    private int golsFora;
    private LocalDate data;

    // Construtor manual
    public Jogo(int id, String nome) {
        super(id, nome);
    }

    // Construtor automático para chaveamento
    public Jogo(Time timeCasa, Time timeFora, LocalDate data) {
        super(0, timeCasa.getNome() + " vs " + timeFora.getNome());
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
        this.data = data;
    }

    public void registrarResultado(int golsCasa, int golsFora) {
        this.golsCasa = golsCasa;
        this.golsFora = golsFora;
    }

    public Time getVencedor() {
        if (golsCasa > golsFora)
            return timeCasa;
        else if (golsFora > golsCasa)
            return timeFora;
        else
            return null; // empate
    }

    @Override
    public void exibirResumo() {
        System.out.println(
                data + " - " + timeCasa.getNome() + " " + golsCasa + " x " + golsFora + " " + timeFora.getNome());
    }

    // Getters e Setters

    public Time getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(Time timeCasa) {
        this.timeCasa = timeCasa;
    }

    public Time getTimeFora() {
        return timeFora;
    }

    public void setTimeFora(Time timeFora) {
        this.timeFora = timeFora;
    }

    public int getGolsCasa() {
        return golsCasa;
    }

    public void setGolsCasa(int golsCasa) {
        this.golsCasa = golsCasa;
    }

    public int getGolsFora() {
        return golsFora;
    }

    public void setGolsFora(int golsFora) {
        this.golsFora = golsFora;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
