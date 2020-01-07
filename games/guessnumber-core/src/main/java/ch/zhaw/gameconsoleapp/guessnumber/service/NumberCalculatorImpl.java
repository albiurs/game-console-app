package ch.zhaw.gameconsoleapp.guessnumber.service;

import ch.zhaw.gameconsoleapp.guessnumber.annotationinterface.MaxNumber;
import ch.zhaw.gameconsoleapp.guessnumber.annotationinterface.MinNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * NumberCalculatorImpl
 * Implementation of the NumberCalculator Service, generating and/or returning random, max and min number.
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
@Service
public class NumberCalculatorImpl implements NumberCalculator {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(NumberCalculatorImpl.class);


	// == fields ==
	private final Random random = new Random();
	private final int maxNumber;
	private final int minNumber;


	// == constructors ==
	/**
	 * NumberCalculatorImpl()
	 * Initialization of fields maxNumber and minNumber with default values.
	 *
	 * atMaxNumber	Use of the annotation interface to grasp the MaxNumber bean from GameConfig.java.
	 * atMinNumber	Use of the annotation interface to grasp the MinNumber bean from GameConfig.java.
	 *
	 * @param maxNumber	Maximum number in range.
	 * @param minNumber	Minimum number in range.
	 */
	@Autowired
	public NumberCalculatorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {

		this.maxNumber = maxNumber;
		log.info("Constructor NumberCalculatorImpl() called. Initialized maxNumber = {}", maxNumber);
		this.minNumber = minNumber;
		log.info("Constructor NumberCalculatorImpl() called. Initialized minNumber = {}", minNumber);

	}


	/**
	 * NumberCalculatorImpl()
	 * Default Constructor required for JUnit tests
	 */
	public NumberCalculatorImpl() {

		this.maxNumber = 100;
		log.info("Constructor NumberCalculatorImpl() called. Initialized maxNumber = {}", maxNumber);
		this.minNumber = 0;
		log.info("Constructor NumberCalculatorImpl() called. Initialized minNumber = {}", minNumber);

	}


	// == public methods ==

	/**
	 * nextRandomInt()
	 * Calculation of a random int value.
	 * @return	Random int value.
	 */
	@Override
	public int nextRandomInt() {

		int nextRandomInt;

		// example:  min=5 max=20 -> max-min=15 -> range 0-15 + min -> 5-20
		nextRandomInt = random.nextInt(maxNumber - minNumber) + minNumber;
		log.info("NumberCalculatorImpl.next() called. nextInt = {}", nextRandomInt);

		return nextRandomInt;
	}

	/**
	 * getMaxNumber()
	 * @return	Maximum number in range.
	 */
	@Override
	public int getMaxNumber() {
		log.info("NumberCalculatorImpl.getMaxNumber() called. maxNumber = {}", maxNumber);
		return maxNumber;
	}

	/**
	 * getMinNumber()
	 * @return	Minimum number in range.
	 */
	@Override
	public int getMinNumber() {
		log.info("NumberCalculatorImpl.getMinNumber() called. minNumber = {}", minNumber);
		return minNumber;
	}
}
