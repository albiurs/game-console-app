package ch.zhaw.gameconsoleapp.tictactoe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * TicTacToeGame
 *
 * @author created by Danian Kiarostami, on 2020-01-09
 * @version
 */
@Component
public class TicTacToeGame {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(TicTacToeGame.class);	// Initialization of Slf4j logger

    // == fields ==
    private static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    private static ArrayList<Integer> computerPosition = new ArrayList<Integer>();

    // == public methods ==
    public static void startTtt() {

        log.info("-- startTtt() called, game starts up --");

        //das Spielbrett wird mit char initialisiert und mit den Sybolen befüllt, damit es nach einem Spielbrett bei der ausgabe  aussieht
        char[][] table ={{'1', '|','2','|','3'},
                {'-', '+','-','+','-'},
                {'4', '|','5','|','6'},
                {'-', '+','-','+','-'},
                {'7', '|','8','|','9'}};

        createGameBoard(table);


        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Wähle von 1-9 aus wo dein X hingeht");
            int playerPos = scan.nextInt();
            //check damit das Feld nicht doppelt besetzt werden kann
            while  (playerPosition.contains(playerPos) || computerPosition.contains(playerPosition)){
                System.out.println("Position besetzt, bitte wähle eine andere");
                playerPos = scan.nextInt();
            }
            placePiece(table,playerPos,"Spieler");
            String result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }

            //zufallsgenerator um ein Spielstein zu legen (Computer)
            Random rand = new Random();
            int computerPos = rand.nextInt(9)+1;
            //check damit das Feld nicht doppelt besetzt werden kann
            while  (playerPosition.contains(computerPos) || computerPosition.contains(computerPos)) {
                computerPos = rand.nextInt(9)+1;
            }

            placePiece(table,computerPos,"Computer");

            createGameBoard(table);

            result = checkWinner();
            if(result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }

    //Ausgabe des Spielbretts im Terminal
    public static void createGameBoard(char[][] table){
        for(char[] row : table){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //Spielbrettbelegung
    public static void placePiece(char[][] table, int pos, String User) {

        char symbol = ' ';

        if(User.equals("Spieler")){
            symbol = 'X';
            playerPosition.add(pos);
        }else if(User.equals("Computer")){
            symbol ='0';
            computerPosition.add(pos);
        }

        switch(pos){
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

    //gewinnkonditionencheck
    public static String checkWinner(){
        //check ob eine gewinnkondition gegeben ist,
        // indem es schaut ob es diesselben symbole in den pos hat
        List topRow = Arrays.asList(1,2,3);
        List middleRow = Arrays.asList(4,5,6);
        List bottomRow = Arrays.asList(7,8,9);
        List leftCol = Arrays.asList(1,4,7);
        List middleCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List uplLeftRightBottom = Arrays.asList(1,5,9);
        List upRightLeftBottom = Arrays.asList(3,5,7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(middleRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(middleCol);
        winningConditions.add(rightCol);
        winningConditions.add(uplLeftRightBottom);
        winningConditions.add(upRightLeftBottom);

        for(List l : winningConditions){
            if(playerPosition.containsAll(l)) {
                return "Du hast gewonnen";
            }else if(computerPosition.containsAll(l)){
                return " Schade, du hast verloren";
            }else if(playerPosition.size() + computerPosition.size() == 9){
                return " Unentschieden";
            }
        }
        return"";
    }
}
