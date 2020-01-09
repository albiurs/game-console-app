package ch.zhaw.gameconsoleapp.randomjokecrawler;

import com.afrunt.randomjoke.Jokes;

/**
 * StartCrawler
 *
 * @author created by Urs Albisser, on 2020-01-09
 * @version 0.1
 */
public class StartCrawler {

	public static void main(String[] args) {

		Jokes jokes = new Jokes()
				.withDefaultSuppliers();

		jokes.randomJoke().ifPresent(joke -> System.out.println(joke.getText()));
	}
}
