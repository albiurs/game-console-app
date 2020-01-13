package ch.zhaw.gameconsoleapp.guessnumber.web.service;

import ch.zhaw.gameconsoleapp.guessnumber.core.components.MessageProvider;
import ch.zhaw.gameconsoleapp.guessnumber.core.service.CoreGameLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * WebGameLogicService
 * Web WebGameLogicService implementation.
 * Implements the game service logic used by the web application.
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
@Service
public class WebGameLogicServiceImpl implements WebGameLogicService {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(WebGameLogicServiceImpl.class); 	// Initialization of Slf4j logger


	// == fields ==
	private final CoreGameLogicService coreGameLogicService;
	private final MessageProvider messageProvider;


	// == constructors ==
	/**
	 * WebGameLogicServiceImpl()
	 * Constructor, implementing the fields.
	 * @param coreGameLogicService CoreGameLogicService instance
	 * @param messageProvider MessageProvider instance
	 */
	@Autowired
	public WebGameLogicServiceImpl(CoreGameLogicService coreGameLogicService, MessageProvider messageProvider) {
		this.coreGameLogicService = coreGameLogicService;
		this.messageProvider = messageProvider;
	}


	// == init ==
	// for test purpose to check if the class is working
	/**
	 * init()
	 * Spring Boot init() method.
	 * Generate console log outputs to check functionality of logic.
	 *
	 * atPostConstruct: called right after running the constructor.
	 */
	@PostConstruct
	public void init() {
		log.info("Random number to guess = {}", coreGameLogicService.getRandomNumberToGuess());
		log.info("Message before guess = {}", messageProvider.getPreGuessMessage());
	}


	// == public methods ==

	/**
	 * isGameOver()
	 * Check if the game is over.
	 * @return game is over true/false
	 */
	@Override
	public boolean isGameOver() {
		return coreGameLogicService.isGameOver();
	}

	/**
	 * getPreGuessMessage()
	 * @return message before the guess
	 */
	@Override
	public String getPreGuessMessage() {
		return messageProvider.getPreGuessMessage();
	}

	/**
	 * getPostGuessMessage()
	 * @return message after the guess
	 */
	@Override
	public String getPostGuessMessage() {
		return messageProvider.getPostGuessMessage();
	}

	/**
	 * guessTheNumber()
	 * Let's the player guess a new number by setting a guess, followed by automatically check the guess
	 * against the randomNumberToGuess.
	 * @param guess number guessed by the player
	 */
	@Override
	public void guessTheNumber(int guess) {
		coreGameLogicService.guessTheNumber(guess);
	}

	/**
	 * reset()
	 * Reset fields in coreGameLogicService instance back to init values.
	 */
	@Override
	public void resetGame() {
		coreGameLogicService.resetGame();
	}
}
