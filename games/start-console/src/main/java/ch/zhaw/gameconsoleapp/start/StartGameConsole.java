package ch.zhaw.gameconsoleapp.start;

import ch.zhaw.gameconsoleapp.guessnumber.console.GuessNumberConsoleStart;
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
	public final GuessNumberConsoleStart guessNumberConsoleStart;


	// == constructors ==
	@Autowired
	public StartGameConsole(GuessNumberConsoleStart guessNumberConsoleStart) {
		log.info("-- Constructor StartGameConsole() called --");
		this.guessNumberConsoleStart = guessNumberConsoleStart;
	}


	// == public methods ==
	@EventListener(ContextRefreshedEvent.class)
	public void start() {
		log.info("-- start() method called - container ready to go --");

		Scanner scanner = new Scanner(System.in);

		while(true) {

			System.out.println("Which game do you want play?\n" +
					"1 Game Of Life\n" +
					"2 Guess Numbers\n" +
					"3 Tic Tac Toe\n" +
					"q Quit");
			String choice = scanner.nextLine().trim();
//			scanner.nextLine();

			switch (choice) {
				case "1":
					System.out.println("Game Of Life was chosen");
					break;
				case "2":
					System.out.println("Guess Numbers was chosen");
					guessNumberConsoleStart.startGame();
					break;
				case "3":
					System.out.println("Tic Tac Toe was chosen");
					break;
				case "q":
					System.out.println("Quit...");
					break;
				default:
					System.out.println("Wrong input, try again...");
			}

			if (choice.contentEquals("q")) {
				break; // break out of while loop
			}
		}
	}
}
