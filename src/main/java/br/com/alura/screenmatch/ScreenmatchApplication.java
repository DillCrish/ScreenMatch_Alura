package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var principal = new Principal();

		principal.exibeMenu();

//		json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
//		var dadosEpisodio = converteDados.obterDados(json, DadosEpisodioDto.class);
//		System.out.println(dadosEpisodio);
//
//		List<DadosTemporadaDto> temporadas = new ArrayList<>();
//
//		for (int i = 1; i <= dadosSerie.totalTemporadas() ; i++) {
//			json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season="+i+"&apikey=6585022c");
//			var dadosTemporada = converteDados.obterDados(json, DadosTemporadaDto.class);
//			temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println);
	}
}
