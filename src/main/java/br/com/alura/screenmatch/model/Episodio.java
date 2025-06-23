package br.com.alura.screenmatch.model;

import java.time.LocalDate;
import java.util.Objects;

public class Episodio {

    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Episodio(Integer numero, DadosEpisodioDto dadosEpisodioDto) {
        this.temporada = numero;
        this.titulo = dadosEpisodioDto.titulo();
        this.numeroEpisodio = dadosEpisodioDto.numero();
        this.avaliacao = Double.valueOf(dadosEpisodioDto.avaliacao());
        this.dataLancamento = LocalDate.parse(dadosEpisodioDto.dataLancamento());
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Episodio episodio = (Episodio) o;
        return Objects.equals(temporada, episodio.temporada)
                && Objects.equals(titulo, episodio.titulo)
                && Objects.equals(numeroEpisodio, episodio.numeroEpisodio)
                && Objects.equals(avaliacao, episodio.avaliacao)
                && Objects.equals(dataLancamento, episodio.dataLancamento);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(temporada);
        result = 31 * result + Objects.hashCode(titulo);
        result = 31 * result + Objects.hashCode(numeroEpisodio);
        result = 31 * result + Objects.hashCode(avaliacao);
        result = 31 * result + Objects.hashCode(dataLancamento);
        return result;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
