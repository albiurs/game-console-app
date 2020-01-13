package ch.zhaw.gameconsoleapp.guessnumber.core.components;

/**
 * CoreGameLogic
 * Core Game Lgic interface
 *
 * @author created by Urs Albisser, on 2020-01-07
 * @version 1.0
 */
public interface CoreGameLogic {

	int getRandomNumberToGuess();

	int getGuessedNumber();

	void setGuessedNumber(int guess);

	int getSmallestNumber();

	int getBiggestNumber();

	int getRemainingGuesses();

	int getDefaultGuessCount();

	void resetGame();

	void checkGuess();

	boolean isGuessInValidNumberRange();

	boolean isGameWon();

	boolean isGameLost();
}
