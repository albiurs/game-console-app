package ch.zhaw.gameconsoleapp.gameoflife.core;

import ch.zhaw.gameconsoleapp.gameoflife.core.service.GameServiceMainOperations;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * == public methods ==
     */
    @Override
    public void start(Stage stage) {
        /**
         * creating of a new object of type "MainActivities"
         */
        GameServiceMainOperations gameServiceMainOperations = new GameServiceMainOperations();
        /**
         * creating of a new object of type "Scene"
         * the size of the game panel is choose by chance
         */
        Scene scene = new Scene(gameServiceMainOperations, 500, 535);
        /**
         * implementing the title and scene on the stage and show it
         */
        stage.setTitle("Game Of Life");
        stage.setScene(scene);
        stage.show();
        /**
         * draw the pixels of the game panel from the beginning (without the line coded below, a GUI would pup up but no
         * game panel, until the user clicks on the GUI)
         */
        gameServiceMainOperations.drawing();
    }
    /**
     * main method
     */
    public static void main(String[] args) {
        launch();
    }
}
