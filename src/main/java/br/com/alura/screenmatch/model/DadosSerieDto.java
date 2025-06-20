package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerieDto(@JsonAlias("Title") String titulo,
                            @JsonAlias("totalSeasons") Integer totalTemporadas,
                            @JsonAlias("imdbRating") String avaliacao) implements Serializable {


}
