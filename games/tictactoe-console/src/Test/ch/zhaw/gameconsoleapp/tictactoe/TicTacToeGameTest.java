package ch.zhaw.gameconsoleapp.tictactoe;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.PrintStream;

class TicTacToeGameTest {



    @Test
    void startTtt(InputStream in, PrintStream out) {
        TicTacToeGame test = new TicTacToeGame();

        /*Scanner keyboard = new Scanner(in);
        out.println("Give a number between 1 and 10");
        int input = keyboard.nextInt();

        while (input < 1 || input > 10) {
            out.println("Wrong number, try again.");
            input = keyboard.nextInt();
        }

        return input;
        */

    }

    @Test
  static   void createGameBoard() {
        TicTacToeGame test2 = new TicTacToeGame();

    }


    @Test
    void placePiece() {
        TicTacToeGame test3 = new TicTacToeGame();
    }

    @Test
    void checkWinner() throws Exception {
        TicTacToeGame test4 = new TicTacToeGame();


    }
}