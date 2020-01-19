package ch.zhaw.gameconsoleapp.guessnumber.core.components;

import ch.zhaw.gameconsoleapp.guessnumber.core.service.CoreGameLogicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * MessageProviderImpl
 * Implementation of the main messages for the game.
 *
 * @author created by Urs Albisser, on 2020-01-07
 * @version 1.0
 */
@Component
public class MessageProviderImpl implements MessageProvider {
	

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(MessageProviderImpl.class);
	private static final String LoseMessage = "You lost! The number was: ";
	private static final String WinMessage = "You guessed it! The number was: ";

	// == fields ==
	private final CoreGameLogicService coreGameLogicService;


	// == constructors ==
	/**
	 * MessageProviderImpl() constructor
	 * Init of the CoreGameLogicService instance.
	 * @param coreGameLogicService CoreGameLogicService instance.
	 */
	@Autowired
	public MessageProviderImpl(CoreGameLogicService coreGameLogicService) {
		this.coreGameLogicService = coreGameLogicService;
	}


	// == init methods
	/**
	 * init()
	 * Spring Lifecycle callback method for initiation.
	 */
	@PostConstruct
	public void init() {
		log.info("coreGameLogicService = {}", coreGameLogicService);
	}


	// == destroy ==
	/**
	 * preDestroy()
	 * Spring Lifecycle callback method for destruction.
	 */
	@PreDestroy
	public void preDestroy() {
		log.info("in MessageGenerator preDestroy()");
	}


	// == public methods ==
	/**
	 * getPreGuessMessage()
	 * Get info message before a guess. The message contains the info about
	 * the possible number range (smallest and biggest allowed number in range).
	 * @return Info message with the smallest and biggest allowed number in range.
	 */
	@Override
	public String getPreGuessMessage() {
		return "Number is between " +
				coreGameLogicService.getSmallestNumber() +
				" and " +
				coreGameLogicService.getBiggestNumber() +
				". Can you guess it?";
	}

	/**
	 * getPostGuessMessage()
	 * Get the message after a player's guess. The message contains the current game status and what happens next.
	 * @return Message after a player's guess.
	 */
	@Override
	public String getPostGuessMessage() {

		if (coreGameLogicService.isGameWon()) {
			return WinMessage + coreGameLogicService.getRandomNumberToGuess();
		} else if (coreGameLogicService.isGameLost()) {
			return LoseMessage + coreGameLogicService.getRandomNumberToGuess();
		} else if (!coreGameLogicService.isGuessInValidNumberRange()) {
			return "Invalid number range!";
		} else if (coreGameLogicService.getRemainingGuesses() == coreGameLogicService.getDefaultGuessCount()) {
			return "What is your first guess?";
		} else {
			String direction = "Lower! ";

			if (coreGameLogicService.getGuessedNumber() < coreGameLogicService.getRandomNumberToGuess()) {
				direction = "Higher! ";
			}
			return direction + "You have " + coreGameLogicService.getRemainingGuesses() + " guesses left.";
		}
	}

	public String getLoseMessage() {
		return LoseMessage;
	}

	public String getWinMessage() {
		return WinMessage;
	}
}
