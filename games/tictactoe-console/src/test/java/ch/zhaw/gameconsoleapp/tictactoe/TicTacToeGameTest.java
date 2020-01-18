package ch.zhaw.gameconsoleapp.tictactoe;

import ch.zhaw.gameconsoleapp.tictactoe.TicTacToeGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;




class TicTacToeGameTest{

    @Test

    public void startTtt_(){
        TicTacToeGame test = new TicTacToeGame();


    }

    public void createGameBoard_WrongTable_throwexception(){



    }

    public void checkWinner_PlayerWinSituation_Winmessage(){

        ArrayList<Integer> playerPosition = new ArrayList<Integer>();
        playerPosition.add(1);
        playerPosition.add(2);
        playerPosition.add(3);

        string message = TicTacToeGame.checkWinner(playerPosition, false);

        assertEquals("Congrats, you've Won",Message);
    }

    public void checkWinner_PlayerLoseSituation_Winmessage(){

        ArrayList<Integer> computerPosition = new ArrayList<Integer>();
        playerPosition.add(1);
        playerPosition.add(2);
        playerPosition.add(3);

        string message = TicTacToeGame.checkWinner(computerPosition, true);

        assertEquals("Congrats, you've Lost",Message);
    }

    public void checkWinner_PlayerDrawSituation_Winmessage(){

        ArrayList<Integer> playerPositionPosition = new ArrayList<Integer>();
        playerPosition.add(1);
        playerPosition.add(2);
        playerPosition.add(6);
        playerPosition.add(7);
        playerPosition.add(8);

        string message = TicTacToeGame.checkWinner(playerPosition, false);

        assertEquals("Tie",Message);
    }


}