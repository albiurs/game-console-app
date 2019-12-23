package ch.zhaw.gameconsoleapp.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * StartGameConsole
 *
 * @author created by Urs Albisser, on 2019-12-23
 * @version 0.0.1
 */
@Component
public class StartGameConsole {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(StartGameConsole.class);    // Initialization of Slf4j logger


	// == fields ==


	// == constructors ==
	@Autowired
	public StartGameConsole() {
		log.info("-- Constructor StartGameConsole() called --");
	}


	// == public methods ==
	@EventListener(ContextRefreshedEvent.class)
	public void start() {
		log.info("start() --> Container ready for use.");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Which game do you want play?");
		System.out.println("1 Game Of Life");
		System.out.println("2 Guess Numbers");
		System.out.println("3 Tic Tac Toe");
		System.out.println("0 Exit Game Console");
		int choice = scanner.nextInt();
		scanner.nextLine();

		System.out.println("choice = " + choice);
	}
}
