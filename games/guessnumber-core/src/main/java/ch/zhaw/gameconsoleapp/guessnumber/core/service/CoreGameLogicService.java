package ch.zhaw.gameconsoleapp.guessnumber.core.service;

/**
 * CoreGameLogicService
 * Core Game Lgic interface
 *
 * @author created by Urs Albisser, on 2020-01-07
 * @version 1.0
 */
public interface CoreGameLogicService {

	int getRandomNumberToGuess();

	int getGuessedNumber();

	void setGuessedNumber(int guess);

	int getSmallestNumber();

	int getBiggestNumber();

	int getRemainingGuesses();

	int getDefaultGuessCount();

	void resetGame();

	void checkGuess();

	void guessTheNumber(int setGuessedNumber);

	boolean isGuessInValidNumberRange();

	boolean isGameWon();

	boolean isGameLost();

	boolean isGameOver();
}
