package ch.zhaw.gameconsoleapp.guessnumber.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * GuessNumberConsoleStart
 * Start class for the Guess Number Game.
 *
 * @author created by Urs Albisser, on 2019-12-30
 * @version 0.0.1
 */
@Component
public class GuessNumberConsoleStart {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GuessNumberConsoleDummy.class);	// Initialization of Slf4j logger


	// == constructors ==
	@Autowired
	public GuessNumberConsoleStart() {
		log.info("-- Constructor GuessNumberConsoleStart() called --");
	}

	public void printMessage() {
		System.out.println("GuessNumberConsoleStart.printMessage() called");
	}
}
