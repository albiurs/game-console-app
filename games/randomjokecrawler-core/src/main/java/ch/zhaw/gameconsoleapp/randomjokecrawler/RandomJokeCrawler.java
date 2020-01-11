package ch.zhaw.gameconsoleapp.randomjokecrawler;

import com.afrunt.randomjoke.Jokes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RandomJokeCrawler
 *
 * @author created by Urs Albisser, on 2020-01-09
 * @version 0.1
 */
@Component
public class RandomJokeCrawler {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(RandomJokeCrawler.class);


	// == fields ==
	private final Jokes jokes;


	// == constructors ==
	@Autowired
	public RandomJokeCrawler() {
		this.jokes = new Jokes().withDefaultSuppliers();
	}


	// == public methods ==
	public void startRandomJokeCrawler() {

//		Jokes jokes = new Jokes()
//				.withDefaultSuppliers();

		jokes.randomJoke().ifPresent(joke -> System.out.println(joke.getText()));
	}
}
