package ch.zhaw.gameconsoleapp.guessnumber.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * NumberCalculatorTest
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
class NumberCalculatorTest {

	@Autowired
	NumberCalculator numberCalculator;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void nextRandomInt() {
	}

	@Test
	void getMaxNumber() {
//		assertEquals(5, numberCalculator.getMaxNumber(), 0);
	}

	@Test
	void getMinNumber() {
	}
}