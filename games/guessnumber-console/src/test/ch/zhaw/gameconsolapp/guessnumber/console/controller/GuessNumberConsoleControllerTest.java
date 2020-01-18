package ch.zhaw.gameconsolapp.guessnumber.console.controller;


import ch.zhaw.gameconsoleapp.guessnumber.core.components.NumberCalculatorImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)		// JUnit 5: required for @InjectMocks and @Mock
//@SpringBootTest(classes = NumberCalculator.class)

public class GuessNumberConsoleControllerTest {

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

    @Test
    void startGame() {
    }
}
