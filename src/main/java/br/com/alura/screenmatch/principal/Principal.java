package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodioDto;
import br.com.alura.screenmatch.model.DadosSerieDto;
import br.com.alura.screenmatch.model.DadosTemporadaDto;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner entrada = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConverteDados converteDados = new ConverteDados();

    public void exibeMenu() {

        System.out.print("Digite o nome da série para buscar: ");
        var nomeDaSerie = entrada.nextLine();

        if (nomeDaSerie.isBlank()){
            return ;
        }
        var json = consumoAPI.obterDados(ENDERECO + nomeDaSerie.toLowerCase().replace(" ","+") + API_KEY);
        var dadosSerie = converteDados.obterDados(json, DadosSerieDto.class);
        System.out.println(dadosSerie);

//        json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//		var dadosEpisodio = converteDados.obterDados(json, DadosEpisodioDto.class);
//		System.out.println(dadosEpisodio);

		List<DadosTemporadaDto> temporadas = new ArrayList<>();

		for (int i = 1; i <= dadosSerie.totalTemporadas() ; i++) {
			json = consumoAPI.obterDados(ENDERECO + nomeDaSerie.toLowerCase().replace(" ","+") + "&season=" + i + API_KEY);
			var dadosTemporada = converteDados.obterDados(json, DadosTemporadaDto.class);
			temporadas.add(dadosTemporada);
		}
        temporadas.forEach(t -> t.episodios().forEach(
                        e -> System.out.println(e.titulo())));
        entrada.close();

        List<DadosEpisodioDto> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()).toList();



    }
}
