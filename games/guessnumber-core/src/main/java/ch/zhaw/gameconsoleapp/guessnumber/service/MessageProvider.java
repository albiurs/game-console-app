package ch.zhaw.gameconsoleapp.guessnumber.service;

/**
 * MessageProvider
 * Interface providing the main messages of the game.
 *
 * @author created by Urs Albisser, on 2020-01-07
 * @version 1.0
 */
public interface MessageProvider {

	String getPreGuessMessage();

	String getPostGuessMessage();
}
