package model;

public abstract class EntidadeBase {
    private int id;
    private String nome;

    public EntidadeBase(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void exibirResumo();
}