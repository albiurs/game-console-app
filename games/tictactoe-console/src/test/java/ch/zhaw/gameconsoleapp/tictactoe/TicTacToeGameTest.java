package ch.zhaw.gameconsoleapp.tictactoe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TicTacToeGameTest
 *
 * @author created by Danian Kiarostami, on 2020-01-18
 * @version 0.1
 */
@ExtendWith(SpringExtension.class)
class TicTacToeGameTest {


	// == fields ==
	@InjectMocks
	private TicTacToeGame ticTacToeGame;


	// == setup & teardown ==
	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}


	// == JUnit tests ==



	@Test
	void placePiece() {

		char[][] table = new char[5][5];
		TicTacToeGame.placePiece(table,  9, "Player");
		assertEquals(table[4][4], 'X');

		table = new char[5][5];
		TicTacToeGame.placePiece(table,  6, "Computer");
		assertEquals(table[2][4], 'O');

	}

	@Test
	void checkWinner() {
		ArrayList<Integer> playerPosition = new ArrayList<Integer>();
		playerPosition.add(1);
		playerPosition.add(2);
		playerPosition.add(3);

		String message = TicTacToeGame.checkWinner(playerPosition, false);
		assertEquals("Congrats, you've Won", message);


		playerPosition.clear();

		ArrayList<Integer> computerPosition = new ArrayList<Integer>();
		computerPosition.add(1);
		computerPosition.add(2);
		computerPosition.add(3);

		message = TicTacToeGame.checkWinner(computerPosition, true);
		assertEquals("Sorry, you've Lost", message);

		
		computerPosition.clear();


		playerPosition.add(2);
		computerPosition.add(1);
		playerPosition.add(4);
		computerPosition.add(3);
		playerPosition.add(9);
		computerPosition.add(5);
		playerPosition.add(6);
		computerPosition.add(8);
		playerPosition.add(7);


		message = TicTacToeGame.checkWinner(playerPosition, false);
		assertEquals("Tie", message);
	}
}