package ch.zhaw.gameconsoleapp.guessnumber.web.service;

/**
 * WebGameLogicService
 * Web WebGameLogicService interface.
 * Communication interface in between the core module and the web controller.
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
public interface WebGameLogicService {

	boolean isGameOver();

	String getPreGuessMessage();

	String getPostGuessMessage();

	void guessTheNumber(int guess);

	void resetGame();
}
