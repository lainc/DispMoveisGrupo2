package ufba.mypersonaltrainner;

public class Exercicio {
    private String nome;
    private String series;
    private String carga;

    public Exercicio(String nome, String series, String carga) {
        this.nome = nome;
        this.series = series;
        this.carga = carga;
    }

    public String getNome() {
        return nome;
    }

    public String getSeries() {
        return series;
    }

    public String getCarga() {
        return carga;
    }
}
