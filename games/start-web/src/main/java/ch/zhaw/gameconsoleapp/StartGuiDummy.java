package ch.zhaw.gameconsoleapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * GameOfLifeCoreDummy
 *
 * @author created by Urs Albisser, on 2019-12-20
 * @version 0.0.1
 */
@Component
public class StartGuiDummy {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(StartGuiDummy.class);	// Initialization of Slf4j logger

	// == constructors ==
	@Autowired
	public StartGuiDummy() {
		log.info("-- Constructor GameOfLifeCoreDummy() called --");
	}
}
