package ufba.mypersonaltrainner;

public class Exercicio {
    private String nome;
    private int series;
    private int carga;

    public Exercicio(String nome, int series, int carga) {
        this.nome = nome;
        this.series = series;
        this.carga = carga;
    }

    public String getNome() {
        return nome;
    }

    public int getSeries() {
        return series;
    }

    public int getCarga() {
        return carga;
    }
}
