package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.DadosEpisodioDto;
import br.com.alura.screenmatch.model.DadosSerieDto;
import br.com.alura.screenmatch.model.DadosTemporadaDto;
import br.com.alura.screenmatch.model.Episodio;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import javax.swing.plaf.basic.BasicArrowButton;
import java.util.ArrayList;
import java.util.Comparator;
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

//        System.out.println("\ntop 5 episódios");
//        episodios.stream()
//                .filter(e -> !e.avaliacao().equals("N/A"))
//                .sorted(Comparator.comparing(DadosEpisodioDto::avaliacao).reversed())
//                .limit(5)
//                .forEach(System.out::println);

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .filter(d -> !d.avaliacao().equals("N/A"))
                        .map(d -> new Episodio(t.numero(), d))).toList();

        episodios.forEach(System.out::println);

    }
}
