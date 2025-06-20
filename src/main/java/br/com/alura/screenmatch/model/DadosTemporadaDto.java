package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporadaDto(@JsonAlias("Season") Integer numero,
                                @JsonAlias("Episodes") List<DadosEpisodioDto> episodios) implements Serializable {
}
