package ch.zhaw.gameconsoleapp.guessnumber.components;

import ch.zhaw.gameconsoleapp.guessnumber.core.components.MessageProviderImpl;
import ch.zhaw.gameconsoleapp.guessnumber.core.components.NumberCalculatorImpl;
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
        assertEquals(messageProvider.getPostGuessMessage(), messageProvider.WinMessage + gameService.getRandomNumberToGuess());


        gameService.setGuessedNumber(numberToGuess-1);
        assertEquals(messageProvider.getPostGuessMessage(), messageProvider.LoseMessage + gameService.getRandomNumberToGuess());
    }
}
