package ch.zhaw.gameconsoleapp.guessnumber.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * GameOfLifeConsoleDummy
 *
 * @author created by Urs Albisser, on 2019-12-20
 * @version 0.0.1
 */
@Component
public class GuessNumberConsoleDummy {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GuessNumberConsoleDummy.class);	// Initialization of Slf4j logger

	// == constructors ==
	@Autowired
	public GuessNumberConsoleDummy() {
		log.info("-- Constructor GuessNumberConsoleDummy() called --");
	}

	public void printMessage() {
		System.out.println("GuessNumberConsoleDummy.printMessage() called");
	}
}