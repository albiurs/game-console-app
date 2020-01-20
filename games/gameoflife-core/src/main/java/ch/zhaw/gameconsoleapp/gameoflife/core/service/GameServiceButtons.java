package ch.zhaw.gameconsoleapp.gameoflife.core.service;

import ch.zhaw.gameconsoleapp.gameoflife.core.components.PixelState;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * this class introduces the buttons relevant for playing Conway's Game of Life
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
@Component
public class GameServiceButtons extends ToolBar {

    // == fields ==

    /**
     * classes, which are relevant for the class "Buttons" are implemented below
     */
    private GameServiceMainOperations gameServiceMainOperations;
    private GameServiceAutoSimulationMode gameServiceAutoSimulationMode;

    // == constructor ==
    @Autowired
    public GameServiceButtons(GameServiceMainOperations gameServiceMainOperations) {
        this.gameServiceMainOperations = gameServiceMainOperations;
        /**
         * introducing of the draw button
         */
        Button draw = new Button("DRAW");
        draw.setOnAction(this::drawButton);
        /**
         * introducing of the delete button
         */
        Button delete = new Button("DELETE");
        delete.setOnAction(this::deleteButton);
        /**
         * introducing of the next button
         */
        Button next = new Button("NEXT");
        next.setOnAction(this::nextButton);
        /**
         * introducing of the start button
         */
        Button start = new Button("START");
        start.setOnAction(this::startButton);
        /**
         * introducing of the stop button
         */
        Button stop = new Button("STOP");
        stop.setOnAction(this::stopButton);
        /**
         * adding the buttons together
         */
        this.getItems().addAll(draw, delete, next, start, stop);
    }

    // == private methods ==

    /**
     * by clicking on the DRAW button, the user would be able to draw alive pixels on the game panel (even by pressing
     * or dragging the mouse)
     */
    private void drawButton(ActionEvent actionEvent) {
        this.gameServiceMainOperations.transitGamePanel(gameServiceMainOperations.CLICK_MODE);
        this.gameServiceAutoSimulationMode = null;
        this.gameServiceMainOperations.setDrawing(PixelState.ALIVE_STATE);
        this.gameServiceMainOperations.drawing();
    }

    /**
     * by clicking on the DELETE button, the user would be able to delete alive pixels on the game panel (even by
     * pressing or dragging the mouse)
     */
    private void deleteButton(ActionEvent actionEvent) {
        this.gameServiceMainOperations.transitGamePanel(gameServiceMainOperations.CLICK_MODE);
        this.gameServiceAutoSimulationMode = null;
        this.gameServiceMainOperations.setDrawing(PixelState.DEAD_STATE);
        this.gameServiceMainOperations.drawing();
    }

    /**
     * by clicking on the NEXT button, the game panel switches into the simulation mode and the user can by pressing
     * on this button proceed manually to the next simulation state, respectively, the next simulation state would be
     * drawn
     */
    private void nextButton(ActionEvent actionEvent) {
        /**
         * comments in terms of the "switchingToSimulationMode()" method see also below in this class
         */
        switchingToSimulationMode();
        this.gameServiceMainOperations.getStepwiseSimulationMode().newState();
        this.gameServiceMainOperations.drawing();
    }

    /**
     * by clicking on the START button, the game panel switches into the automatically simulation mode
     */
    private void startButton(ActionEvent actionEvent) {
        /**
         * comments in terms of the "switchingToSimulationMode()" method see also below in this class
         */
        switchingToSimulationMode();
        this.gameServiceAutoSimulationMode.startSimulation();
    }

    /**
     * by clicking on the STOP button, the game panel switches into the automatically simulation mode
     */
    private void stopButton(ActionEvent actionEvent) {
        this.gameServiceAutoSimulationMode.stopSimulation();
    }

    /**
     * if click mode is still active, then lunch now the next simulation mode --> only necessary for START & NEXT button
     */
    private void switchingToSimulationMode() {
        if (this.gameServiceMainOperations.clickMode() == GameServiceMainOperations.CLICK_MODE) {
            this.gameServiceMainOperations.transitGamePanel(GameServiceMainOperations.SIMULATION_MODE);
            this.gameServiceAutoSimulationMode = new GameServiceAutoSimulationMode(this.gameServiceMainOperations,
                    this.gameServiceMainOperations.getStepwiseSimulationMode());
        }
    }
}