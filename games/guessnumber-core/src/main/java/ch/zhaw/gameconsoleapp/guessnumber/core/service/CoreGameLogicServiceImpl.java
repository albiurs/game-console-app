package ch.zhaw.gameconsoleapp.guessnumber.core.service;

import ch.zhaw.gameconsoleapp.guessnumber.core.annotationinterface.DefaultGuessCount;
import ch.zhaw.gameconsoleapp.guessnumber.core.components.NumberCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * CoreGameLogicServiceImpl
 * Implementation of the Core Game Logic interface. Implements the core game logic.
 *
 * @author created by Urs Albisser, on 2020-01-07
 * @version 1.0
 */
@Service
public class CoreGameLogicServiceImpl implements CoreGameLogicService {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(CoreGameLogicServiceImpl.class); 	// Initialization of Slf4j logger


	// == fields ==
	private final NumberCalculator numberCalculator;
	private final int defaultGuessCount;

	private int randomNumberToGuess;
	private int guessedNumber;      // number guessed by the player
	private int smallestNumber;   // smallest number in range
	private int biggestNumber;    // biggest number in range
	private int remainingGuesses;
	private boolean guessInValidNumberRange = true;    // guess is within a valid range true/false


	// == constructors ==
	/**
	 * GameImpl()
	 * Autowired Constructor. Initialization of final fields numberCalculator and defaultGuessCount
	 * atAutowired Injecting/Autowiring the dependency by the Spring Container. Instantiation without "new" keyword.
	 *
	 * @param numberCalculator new NumberCalculator instance
	 * @param defaultGuessCount number of allowed guesses defined by DefaultGuessCount in
	 *                             game.properties
	 */
	@Autowired
	public CoreGameLogicServiceImpl(NumberCalculator numberCalculator, @DefaultGuessCount int defaultGuessCount) {
		this.numberCalculator = numberCalculator;
		log.info("Constructor GameImpl() called. Initialized numberCalculator = {}", numberCalculator);
		this.defaultGuessCount = defaultGuessCount;
		log.info("Constructor GameImpl() called. Initialized defaultGuessCount = {}", defaultGuessCount);
	}


	// == init ==
	/**
	 * reset()
	 * Reset fields back to init values.
	 *
	 * atPostConstruct Spring Lifecycle callback method for initiation
	 */
	@PostConstruct
	@Override
	public void resetGame() {

		randomNumberToGuess = numberCalculator.nextRandomInt();
		log.debug("@PostConstruct --> GameImpl.reset() called. randomNumberToGuess = {}", randomNumberToGuess);

		guessedNumber = numberCalculator.getMinNumber();
		log.debug("@PostConstruct --> GameImpl.reset() called. guess = {}", guessedNumber);

		smallestNumber = numberCalculator.getMinNumber();
		log.debug("@PostConstruct --> GameImpl.reset() called. smallest = {}", smallestNumber);

		biggestNumber = numberCalculator.getMaxNumber();
		log.debug("@PostConstruct --> GameImpl.reset() called. biggest = {}", biggestNumber);

		remainingGuesses = defaultGuessCount;
		log.debug("@PostConstruct --> GameImpl.reset() called. remainingGuesses = {}", remainingGuesses);
	}


	// == destroy ==
	/**
	 * preDestroy()
	 *
	 * atPreDestroy Spring Lifecycle callback method for destruction
	 */
	@PreDestroy
	public void preDestroy() {
		log.info("GameImpl.preDestroy() called");
	}


	// == public methods ==
	/**
	 * check()
	 * Check guess.
	 * Adjust biggest threshold if guess is too high.
	 * Adjust smallest threshold if guess is too low.
	 * remainingGuesses -1.
	 */
	@Override
	public void checkGuess() {

		// checkValidNumberRange > set validNumberRange
		checkValidNumberRange();

		if(guessInValidNumberRange) {
			if(guessedNumber > randomNumberToGuess) {
				biggestNumber = guessedNumber - 1;    // adjust biggest threshold
				log.info("GameImpl.check() called. Guess is too high. Set biggest = {}", biggestNumber);
			}

			if(guessedNumber < randomNumberToGuess) {
				smallestNumber = guessedNumber + 1;   // adjust smallest threshold
				log.info("GameImpl.check() called. Guess is too low. Set smallest = {}", smallestNumber);
			}
		}

		remainingGuesses--;
	}

	/**
	 * guessTheNumber()
	 * Let's the player guess a new number by setting a guess, followed by automatically check the guess
	 * against the randomNumberToGuess.
	 * @param guess The number guessed by the player
	 */
	@Override
	public void guessTheNumber(int guess) {
		setGuessedNumber(guess);
		checkGuess();
	}

	/**
	 * isGuessInValidNumberRange()
	 * Guess is within the valid number range.
	 * @return Guess is in valid number range true/false.
	 */
	@Override
	public boolean isGuessInValidNumberRange() {
		return guessInValidNumberRange;
	}

	/**
	 * isGameWon()
	 * Is the game won?
	 * @return The game is won true/false.
	 */
	@Override
	public boolean isGameWon() {
		return guessedNumber == randomNumberToGuess;
	}

	/**
	 * isGameLost()
	 * Is the game lost?
	 * @return The game is lost true/false.
	 */
	@Override
	public boolean isGameLost() {
		return !isGameWon() && remainingGuesses <= 0;
	}

	/**
	 * isGameOver()
	 * Is the game over?
	 * @return The game is over true/fale.
	 */
	public boolean isGameOver() {
		return isGameWon() || isGameLost();
	}


	// setter & getter
	/**
	 * getRandomNumberToGuess()
	 * Get the randomly generated number to be guessed.
	 * @return randomly generated int number to be guessed.
	 */
	@Override
	public int getRandomNumberToGuess() {
		return randomNumberToGuess;
	}

	/**
	 * getGuessedNumber()
	 * Get the number guessed by the player.
	 * @return the int number guessed by the player
	 */
	@Override
	public int getGuessedNumber() {
		return guessedNumber;
	}

	/**
	 * setGuessedNumber()
	 * Set the number guessed by the player.
	 * @param guessedNumber The int number guessed by the player.
	 */
	@Override
	public void setGuessedNumber(int guessedNumber) {
		this.guessedNumber = guessedNumber;
	}

	/**
	 * getSmallestNumber()
	 * Get the smallest number in range.
	 * @return The smallest number in range.
	 */
	@Override
	public int getSmallestNumber() {
		return smallestNumber;
	}

	/**
	 * getBiggestNumber()
	 * Get the biggest possible number in range.
	 * @return The biggest possible number in range.
	 */
	@Override
	public int getBiggestNumber() {
		return biggestNumber;
	}

	/**
	 * getRemainingGuesses()
	 * Get the remaining guesses until the game is lost.
	 * @return The remaining guesses until the game is lost.
	 */
	@Override
	public int getRemainingGuesses() {
		return remainingGuesses;
	}

	/**
	 * getDefaultGuessCount()
	 * Get the default maximum guess count for the game, defined in game.properties.
	 * @return the default maximum guess count for the game, defined in game.properties.
	 */
	@Override
	public int getDefaultGuessCount() {
		return defaultGuessCount;
	}


	// == private methods ==
	/**
	 * checkValidNumberRange()
	 * Check if the guess is within the validNumberRange and set the variable guessInValidNumberRange.
	 */
	private void checkValidNumberRange() {
		guessInValidNumberRange = (guessedNumber >= smallestNumber) && (guessedNumber <= biggestNumber);
	}
}
