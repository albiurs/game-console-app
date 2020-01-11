package ch.zhaw.gameconsoleapp.randomjokecrawler.core;

import com.afrunt.randomjoke.Jokes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RandomJokeCrawler
 * Core logic of the Random Joke Crawler app. This class uses the random-joke-crawler dependency to grasp a random
 * joke from online joke resources.
 *
 * @author created by Urs Albisser, on 2020-01-09
 * @version 1.0
 */
@Component
public class RandomJokeCrawler {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(RandomJokeCrawler.class);


	// == fields ==
	private final Jokes jokes;


	// == constructors ==

	/**
	 * RandomJokeCrawler()
	 * Constructor initializing a new instance of the dependencies Jokes class.
	 */
	@Autowired
	public RandomJokeCrawler() {
		this.jokes = new Jokes().withDefaultSuppliers();
	}


	// == public methods ==
	/**
	 * getRandomJoke()
	 * Grasp a new random joke from one of the dependencies's online joke resources.
	 */
	public void getRandomJoke() {

		jokes.randomJoke().ifPresent(joke -> System.out.println(joke.getText()));
	}
}
