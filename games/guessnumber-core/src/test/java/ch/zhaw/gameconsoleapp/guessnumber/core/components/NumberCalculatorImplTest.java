package ch.zhaw.gameconsoleapp.guessnumber.core.components;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * NumberCalculatorImplTest
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 1.0
 */
@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)		// JUnit 5: required for @InjectMocks and @Mock
//@SpringBootTest(classes = NumberCalculator.class)
public class NumberCalculatorImplTest {


	// == fields ==
	@InjectMocks
	private NumberCalculatorImpl numberCalculatorImpl;
//	private NumberCalculatorImpl numberCalculatorImpl = new NumberCalculatorImpl(100, 0);


	// == setup & teardown ==
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}


	// == JUnit tests ==
	@Test
	void nextRandomInt() {

		int minInt = numberCalculatorImpl.getMinNumber();
		int maxInt = numberCalculatorImpl.getMaxNumber();

		for(int i=0; i<10000; i++) {
			int randomInt = numberCalculatorImpl.nextRandomInt();
			System.out.println("nextRandomInt() is: " + randomInt);

			assertTrue((minInt <= randomInt) && (randomInt <= maxInt),
					"nextRandomInt() is out of range: " + randomInt);
			assertTrue(!(minInt < randomInt) || !(randomInt > maxInt));
		}
	}

	@Test
	void getMaxNumber() {
		System.out.println("getMaxNumber() is: " + numberCalculatorImpl.getMaxNumber());
		assertEquals(100, numberCalculatorImpl.getMaxNumber(), 0);
	}

	@Test
	void getMinNumber() {
		System.out.println("getMinNumber() is: " + numberCalculatorImpl.getMinNumber());
		assertEquals(0, numberCalculatorImpl.getMinNumber(), 0);
	}
}
