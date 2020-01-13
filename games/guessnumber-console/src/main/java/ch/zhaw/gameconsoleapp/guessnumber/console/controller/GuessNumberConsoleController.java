package ch.zhaw.gameconsoleapp.guessnumber.console.controller;

import ch.zhaw.gameconsoleapp.guessnumber.core.components.CoreGameLogic;
import ch.zhaw.gameconsoleapp.guessnumber.core.components.MessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * GuessNumberConsoleController
 * Start class for the Guess Number Game.
 *
 * @author created by Urs Albisser, on 2019-12-30
 * @version 1.0.1
 */
@Controller
public class GuessNumberConsoleController {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GuessNumberConsoleController.class);


	// == fields ==
	private final CoreGameLogic coreGameLogic;
	private final MessageProvider messageProvider;


	// == constructors ==
	/**
	 * GuessNumberConsoleController()
	 * Autowired Constructor
	 * @param coreGameLogic CoreGameLogic instance to be initialized
	 * @param messageProvider MessageProvider instance to be initialized
	 */
	@Autowired
	public GuessNumberConsoleController(CoreGameLogic coreGameLogic, MessageProvider messageProvider) {
		this.coreGameLogic = coreGameLogic;
		this.messageProvider = messageProvider;
	}


	// == public classes ==
	/**
	 * startGame()
	 * Starts the Guess Number Console Game and maintains the game instance according to the user's choice ("y").
	 */
	public void startGame() {

		log.info("GuessNumberConsoleController.startGame() called. Game starts up...");

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println(messageProvider.getPreGuessMessage());
			System.out.println(messageProvider.getPostGuessMessage());

			try {
				int guess = scanner.nextInt();
				scanner.nextLine();
				coreGameLogic.setGuessedNumber(guess);
				coreGameLogic.checkGuess();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input, only numbers allowed!");
				scanner.next();
			}


			if (coreGameLogic.isGameWon() || coreGameLogic.isGameLost()) {
				System.out.println(messageProvider.getPostGuessMessage());
				System.out.println("Play again (y/n)?");

				String playAgainChoice = scanner.nextLine().trim();
				if (!playAgainChoice.equalsIgnoreCase("y")) {
					break; // break out of while loop, if choice is anything but "y"
				}

				coreGameLogic.resetGame();
			}
		}
	}
}
