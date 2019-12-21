package ch.zhaw.gameconsoleapp;

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
public class GameOfLifeConsoleDummy {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(GameOfLifeConsoleDummy.class);	// Initialization of Slf4j logger

	// == constructors ==
	@Autowired
	public GameOfLifeConsoleDummy() {
		log.info("-- Constructor GameOfLifeConsoleDummy() called --");
	}
}
