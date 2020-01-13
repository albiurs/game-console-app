package ch.zhaw.gameconsoleapp.start;

import ch.zhaw.gameconsoleapp.guessnumber.console.controller.GuessNumberConsoleController;
import ch.zhaw.gameconsoleapp.randomjokecrawler.console.controller.RandomJokeController;
import ch.zhaw.gameconsoleapp.tictactoe.TicTacToeGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * StartGameConsole
 *
 * @author created by Urs Albisser, on 2019-12-23
 * @version 1.0.1
 */
@Component
public class StartGameConsole {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(StartGameConsole.class);    // Initialization of Slf4j logger


	// == fields ==
	private final TicTacToeGame ticTacToeGame;
	private final GuessNumberConsoleController guessNumberConsoleController;
	private final RandomJokeController randomJokeController;


	// == constructors ==
	/**
	 * StartGameConsole()
	 * Constructor, initializing the fields
	 *
	 * @param guessNumberConsoleController GuessNumberConsoleController instance
	 * @param ticTacToeGame TicTacToeGame instance
	 * @param randomJokeController RandomJokeController instance
	 */
	@Autowired
	public StartGameConsole(GuessNumberConsoleController guessNumberConsoleController,
							TicTacToeGame ticTacToeGame,
							RandomJokeController randomJokeController) {
		log.info("-- Constructor StartGameConsole() called --");
		this.ticTacToeGame = ticTacToeGame;
		this.guessNumberConsoleController = guessNumberConsoleController;
		this.randomJokeController = randomJokeController;
	}


	// == public methods ==

	/**
	 * start()
	 * Start method, booting up the main menu for picking a game to play.
	 *
	 * atEventListener Listens the event of the Spring Context to be refreshed and therefore waiting until the
	 * whole Spring Boot application has completely booted, before executing the start() method.
	 * Choosing "Quit", will completely shut down the whole console app.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void start() {
		log.info("-- start() method called - container ready to go --");

		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("Which game do you want play?\n" +
					"1 Tic-Tac-Toe\n" +
					"2 Guess Number Game\n" +
					"3 Random Joke :-)\n" +
					"q Quit");
			String choice = scanner.nextLine().trim();
//			scanner.nextLine();

			switch (choice) {
				case "1":
					log.info("Tic Tac Toe was chosen");
					ticTacToeGame.startTtt();
					break;
				case "2":
					log.info("Guess Numbers was chosen");
					guessNumberConsoleController.startGame();
					break;
				case "3":
					log.info("Random Joke was chosen");
					randomJokeController.startRandomJokeCrawler();
					break;
				case "q":
					log.info("Quit was chosen");
					System.out.println("Quit...");
					break;
				default:
					log.info("Invalid user input. Default case gets executed.");
					System.out.println("Wrong input, try again...");
			}

			if (choice.contentEquals("q")) {
				break; // break out of while loop
			}
		}
	}
}
