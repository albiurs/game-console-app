package ch.zhaw.gameconsoleapp.randomjokecrawler.console.controller;

import ch.zhaw.gameconsoleapp.randomjokecrawler.core.RandomJokeCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

/**
 * RandomJokeController
 * Controller class of the Random Joke Crawler app.
 * The class allows to start a RandomJokeCrawler instance and call its getRandomJoke() method to grasp a random joke.
 *
 * @author created by Urs Albisser, on 2020-01-11
 * @version 1.0
 */
@Controller
public class RandomJokeController {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(RandomJokeController.class);


	// == fields ==
	private final RandomJokeCrawler randomJokeCrawler;


	// == constructors ==

	/**
	 * RandomJokeController()
	 * Constructor initializing the private fields
	 *
	 * @param randomJokeCrawler RandomJokeCrawler instance
	 */
	public RandomJokeController(RandomJokeCrawler randomJokeCrawler) {

		log.info("Constructor RandomJokeController() called");
		this.randomJokeCrawler = randomJokeCrawler;
	}


	// == public methods ==

	/**
	 * startRandomJokeCrawler()
	 * Starts a RandomJokeCrawler instance and call its getRandomJoke() method to grasp a random joke.
	 * Ask user to get another joke. Any input but y will return to the main menu.
	 */
	public void startRandomJokeCrawler() {

		log.info("RandomJokeController.startRandomJokeCrawler called ");
		System.out.println("------------------------");
		System.out.println();

		Scanner scanner = new Scanner(System.in);

		while (true) {

			randomJokeCrawler.getRandomJoke(); // get a random joke
			System.out.println();

			System.out.println("Do you want to get another joke? (y/n)?");

			String getAnotherJokeChoice = scanner.nextLine().trim();
			if (!getAnotherJokeChoice.equalsIgnoreCase("y")) {
				break; // break out of while loop, if choice is anything but "y"
			}

		}
	}
}
