package ch.zhaw.gameconsoleapp.guessnumber.service;

/**
 * NumberCalculator Interface
 * Interface of the number calculation service.
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 1.0
 */
public interface NumberCalculator {

	int nextRandomInt();

	int getMaxNumber();

	int getMinNumber();
}
