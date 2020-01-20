package ch.zhaw.gameconsoleapp.gameoflife.gui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * main GUI class of Conway's Game of Life -> die implementation of the GUI is visible in module "main -> main-gui" where
 * it can be started
 *
 * @author created by Slavisa Obradovic, on 2020-01-01
 * @version 1.0
 */
@Component
public class GameOfLifeGui {

	// == constants ==

	private static final Logger log = LoggerFactory.getLogger(GameOfLifeGui.class);	// Initialization of Slf4j logger

	// == constructors ==

	@Autowired
	public GameOfLifeGui() {
		log.info("-- Conway's Game of Life --");
	}
}