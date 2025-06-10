package Model;

public abstract class EntidadeBase {
    private int id;
    private String nome;

    public EntidadeBase(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public abstract void exibirResumo();

    @Override
    public String toString() {
        return "EntidadeBase [id=" + id + ", nome=" + nome + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}