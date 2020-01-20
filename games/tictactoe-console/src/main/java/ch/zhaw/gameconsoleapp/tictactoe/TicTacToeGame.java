package ch.zhaw.gameconsoleapp.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * TicTacToeGame
 *a simple game of tic tac toe given out in the console
 * @author created by Danian Kiarostami, on 2020-01-09
 * @version 1.0
 */
@Component
public class TicTacToeGame {


        // == constants ==
        // Initialization of Slf4j logger.
        private static final Logger log = LoggerFactory.getLogger(TicTacToeGame.class);    // Initialization of Slf4j logger


        // == fields ==
        //Arraylist of integers of player and computerpositions
        private static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
        private static ArrayList<Integer> computerPosition = new ArrayList<Integer>();


        // == public methods ==
        /**
         *startTtt()
         * Starts the Tic Tac Toe Console Game and finishes after the user or computer has won
         */
        public static void startTtt () {

        log.info("-- startTtt() called, game starts up --");



        // --- Start while loop to repeat game again ---
        while(true) {
            //the table is initialized with char and filled with the following symbols,
            //so it looks like a board in the output

            char[][] table = {{'1', '|', '2', '|', '3'},
                    {'-', '+', '-', '+', '-'},
                    {'4', '|', '5', '|', '6'},
                    {'-', '+', '-', '+', '-'},
                    {'7', '|', '8', '|', '9'}};

            createGameBoard(table);

            while (true) {

                Scanner scan = new Scanner(System.in);
                System.out.println("Choose from 1-9 where you want to put your X");

                int playerPos = scan.nextInt();

                //the while loop checks if the position is already taken by either the player or the computer
                //so you cannot override the symbole of your counterpart will be repeated for the computer at line 62

                while (playerPosition.contains(playerPos) || computerPosition.contains(playerPosition)) {
                    System.out.println("Position taken, take another");
                    playerPos = scan.nextInt();
                }
                placePiece(table, playerPos, "Player");

                String result = checkWinner(playerPosition, false);
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }

                //randomizes where the computer will put a O on the board
                Random rand = new Random();
                int computerPos = rand.nextInt(9) + 1;
                while (playerPosition.contains(computerPos) || computerPosition.contains(computerPos)) {
                    computerPos = rand.nextInt(9) + 1;
                }

                placePiece(table, computerPos, "Computer");

                createGameBoard(table);

                result = checkWinner(computerPosition, true);
                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }
            }

            // clear ArrayLists with player and computer positions
            playerPosition.clear();;
            computerPosition.clear();

            // Play again?
            Scanner scanAgain = new Scanner(System.in);

            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("Do you want to play again? (y/n)?");

            String playAnotherGame = scanAgain.nextLine().trim();

            if (!playAnotherGame.equalsIgnoreCase("y")) {
                break; // break out of while loop, if choice is anything but "y"
            }

        }
        // --- End of while loop to repeat game again ---


    }

        /**
         * Method is used for console output of array table
         * @param table gives an output of the array table
         */
        private static void createGameBoard ( char[][] table){
        for (char[] row : table) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

        //this code is for alternating between the player and the computer

        /**
         * The method changes between players for the input into the ttt array
         * @param table the array of the gameboard
         * @param pos  is where in the array the symbole of the player or computer should be stored
         * @param User used for figuring out if it's the computer or the player
         */
        public static void placePiece ( char[][] table, int pos, String User){

        char symbol = ' ';

        if (User.equals("Player")) {
            symbol = 'X';
            playerPosition.add(pos);
        } else if (User.equals("Computer")) {
            symbol = 'O';
            computerPosition.add(pos);
        }


        // the switch case is for determing  where
        //in the array the symbole of the player or computer should be stored

        switch (pos) {
            case 1:
                table[0][0] = symbol;
                break;
            case 2:
                table[0][2] = symbol;
                break;
            case 3:
                table[0][4] = symbol;
                break;
            case 4:
                table[2][0] = symbol;
                break;
            case 5:
                table[2][2] = symbol;
                break;
            case 6:
                table[2][4] = symbol;
                break;
            case 7:
                table[4][0] = symbol;
                break;
            case 8:
                table[4][2] = symbol;
                break;
            case 9:
                table[4][4] = symbol;
                break;
            default:
                break;
        }
    }


    /**
     * The method checks for the winning conditions, this means the positions which are defined,
     * are all occupied by either player or computer generates the winning message
     * @param positions occupied positions
     * @param isComputer is computer or not (=player)
     * @return returns the winning message
     */
    public static String checkWinner(ArrayList < Integer > positions, boolean isComputer){

        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List middleCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List uplLeftRightBottom = Arrays.asList(1, 5, 9);
        List upRightLeftBottom = Arrays.asList(3, 5, 7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(middleCol);
        winningConditions.add(rightCol);
        winningConditions.add(uplLeftRightBottom);
        winningConditions.add(upRightLeftBottom);

        for (List l : winningConditions) {
            if (positions.containsAll(l)) {
                if (isComputer) {
                    return "Sorry, you've Lost";
                } else {
                    return "Congrats, you've Won";
                }
            }
        }
        if ((positions.size() >= 5)) {
            return "Tie";
        }

        return "";


    }

}
