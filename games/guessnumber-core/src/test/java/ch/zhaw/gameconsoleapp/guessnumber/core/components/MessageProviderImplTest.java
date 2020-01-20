package ch.zhaw.gameconsoleapp.guessnumber.core.components;

import ch.zhaw.gameconsoleapp.guessnumber.core.service.CoreGameLogicServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)		// JUnit 5: required for @InjectMocks and @Mock
//@SpringBootTest(classes = NumberCalculator.class)

/**
 * MessageProviderImplTest
 *
 * @author created by Danian Kiarostami, on 2020-01-04
 * @version 1.0
 */

public class MessageProviderImplTest {


    // == fields ==
    @InjectMocks
    private MessageProviderImpl messageProvider;


    // == setup & teardown ==
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }


    // == JUnit tests ==
    @Test
    void getPostGuessMessage(){
        CoreGameLogicServiceImpl gameService = new CoreGameLogicServiceImpl(new NumberCalculatorImpl(), 0);

        int numberToGuess = gameService.getRandomNumberToGuess();
        gameService.setGuessedNumber(numberToGuess);

        messageProvider = new MessageProviderImpl(gameService);
        assertEquals(messageProvider.getPostGuessMessage(), messageProvider.getWinMessage() + gameService.getRandomNumberToGuess());


        gameService.setGuessedNumber(numberToGuess-1);
        assertEquals(messageProvider.getPostGuessMessage(), messageProvider.getLoseMessage() + gameService.getRandomNumberToGuess());
    }

    @Test
    void getPreGuessMessage() {

    }

    @Test
    void getLoseMessage() {

    }
}
