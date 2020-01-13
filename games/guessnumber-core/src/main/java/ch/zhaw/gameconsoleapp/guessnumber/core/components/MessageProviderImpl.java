package ch.zhaw.gameconsoleapp.guessnumber.core.components;

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


	// == fields ==
	private final CoreGameLogic coreGameLogic;


	// == constructors ==
	/**
	 * MessageProviderImpl() constructor
	 * Init of the CoreGameLogic instance.
	 * @param coreGameLogic CoreGameLogic instance.
	 */
	@Autowired
	public MessageProviderImpl(CoreGameLogic coreGameLogic) {
		this.coreGameLogic = coreGameLogic;
	}


	// == init methods
	/**
	 * init()
	 * Spring Lifecycle callback method for initiation.
	 */
	@PostConstruct
	public void init() {
		log.info("coreGameLogic = {}", coreGameLogic);
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
				coreGameLogic.getSmallestNumber() +
				" and " +
				coreGameLogic.getBiggestNumber() +
				". Can you guess it?";
	}

	/**
	 * getPostGuessMessage()
	 * Get the message after a player's guess. The message contains the current game status and what happens next.
	 * @return Message after a player's guess.
	 */
	@Override
	public String getPostGuessMessage() {

		if (coreGameLogic.isGameWon()) {
			return "You guessed it! The number was: " + coreGameLogic.getRandomNumberToGuess();
		} else if (coreGameLogic.isGameLost()) {
			return "You lost! The number was: " + coreGameLogic.getRandomNumberToGuess();
		} else if (!coreGameLogic.isGuessInValidNumberRange()) {
			return "Invalid number range!";
		} else if (coreGameLogic.getRemainingGuesses() == coreGameLogic.getDefaultGuessCount()) {
			return "What is your first guess?";
		} else {
			String direction = "Lower! ";

			if (coreGameLogic.getGuessedNumber() < coreGameLogic.getRandomNumberToGuess()) {
				direction = "Higher! ";
			}
			return direction + "You have " + coreGameLogic.getRemainingGuesses() + " guesses left.";
		}
	}
}
