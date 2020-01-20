package ch.zhaw.gameconsoleapp.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * main GUI class of all GUIs within this project
 * due to the fact, that currently only Conway's Game of Life is provided as a GUI, this file is serves as a place
 * holder for future GUIs, where these can be summarised in one main GUI
 *
 * @author created by Urs Albisser, on 2019-12-20
 * @version 1.0
 */
@Component
public class StartGui {

	// == constants ==

	private static final Logger log = LoggerFactory.getLogger(StartGui.class);	// Initialization of Slf4j logger

	// == constructors ==

	@Autowired
	public StartGui() {
		log.info("-- Project`s GUIs --");
	}
}