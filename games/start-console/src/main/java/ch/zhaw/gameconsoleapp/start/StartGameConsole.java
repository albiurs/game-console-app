package ch.zhaw.gameconsoleapp.start;

import ch.zhaw.gameconsoleapp.guessnumber.console.GuessNumberConsoleStart;
import ch.zhaw.gameconsoleapp.randomjokecrawler.RandomJokeCrawler;
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
 * @version 1.0
 */
@Component
public class StartGameConsole {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(StartGameConsole.class);    // Initialization of Slf4j logger


	// == fields ==
	private final TicTacToeGame ticTacToeGame;
	private final GuessNumberConsoleStart guessNumberConsoleStart;
	private final RandomJokeCrawler randomJokeCrawler;


	// == constructors ==
	@Autowired
	public StartGameConsole(GuessNumberConsoleStart guessNumberConsoleStart,
							TicTacToeGame ticTacToeGame,
							RandomJokeCrawler randomJokeCrawler) {
		log.info("-- Constructor StartGameConsole() called --");
		this.ticTacToeGame = ticTacToeGame;
		this.guessNumberConsoleStart = guessNumberConsoleStart;
		this.randomJokeCrawler = randomJokeCrawler;
	}


	// == public methods ==
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
					guessNumberConsoleStart.startGame();
					break;
				case "3":
					log.info("Random Joke was chosen");
					randomJokeCrawler.startRandomJokeCrawler();
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
