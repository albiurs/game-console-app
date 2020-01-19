package ch.zhaw.gameconsoleapp.gameoflife.core.service;

import ch.zhaw.gameconsoleapp.gameoflife.core.components.GamePanel;
import ch.zhaw.gameconsoleapp.gameoflife.core.components.GamePanelImpl;
import ch.zhaw.gameconsoleapp.gameoflife.core.components.PixelState;
import ch.zhaw.gameconsoleapp.gameoflife.core.components.RulesImpl;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class contains methods which describe the main activities
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
@Service
public class GameServiceMainOperations extends VBox {

    // == constants ==

    /**
     * the target is to have the possibility to click on the game panel and to draw on it
     * another target is to simulate the drawing and apply the defined rules (see also class "RulesImpl")
     * for the simulation, the user should be able to proceed further even stepwise or automatically
     * once the simulation mode is ongoing, the user should not have the option to draw on the game panel
     * the constants "CLICK_MODE" (click on the game panel) and "SIMULATION_MODE" (proceed further even stepwise or
     * automatically) are introduced below
     */
    public static final int CLICK_MODE = 0;
    public static final int SIMULATION_MODE = 1;
    /**
     * assigning from a constant to a variable
     */
    private int clickMode = CLICK_MODE;
    /**
     * the canvas component represents a blank rectangular area of the screen onto which the application can draw and
     * from which the application can trap input events from the user
     */
    private Canvas canvas;
    /**
     * applying the affine transform for performing a linear mapping from 2D coordinates to other 2D coordinates while
     * preserving the "straightness" and "parallelism" of lines
     */
    private Affine affine;

    // == fields ==

    /**
     * defining the drawing state (by default --> alive pixels)
     */
    private PixelState drawingState = PixelState.ALIVE_STATE;
    /**
     * further classes, which are relevant for the class "GameServiceAutoSimulationMode" are implemented below
     */
    private GameServiceStepwiseSimulationMode gameServiceStepwiseSimulationMode;
    private GamePanel originalGamePanel;
    private GameServiceButtons buttons;

    // == constructors ==
    @Autowired
    public GameServiceMainOperations() {
        /**
         * initializing and creating of a new object of type "Canvas" where the user can draw (the dimensions are
         * choose by chance)
         */
        this.canvas = new Canvas(500, 500);
        /**
         * the "setOnMousePressed" callback is executed once the mouse button is pressed and released
         */
        this.canvas.setOnMousePressed(this::drawMouse);
        /**
         * the "setOnMouseDragged" callback is executed once the mouse button is pressed and not released
         */
        this.canvas.setOnMouseDragged(this::drawMouse);
        /**
         * initializing and creating of a new object of type "GameServiceButtons"
         */
        this.buttons = new GameServiceButtons(this);
        /**
         * adding the canvas and buttons to the VBox
         */
        this.getChildren().addAll(this.canvas, this.buttons);
        /**
         * initializing and creating of a new object of type "Affine" and scaling the game panel by factor 20 (the
         * factor is choose by chance)
         */
        this.affine = new Affine();
        this.affine.appendScale(500 / 20f, 500 / 20f);
        /**
         * initializing and creating of a new object of type "GamePanelImpl" with the corresponding width and height
         * (the numbers are choose by chance)
         */
        this.originalGamePanel = new GamePanelImpl(20, 20);
    }

    // == private methods ==

    /**
     * because the affine object is applied for transforming the coordinates, this method has the target to inverse
     * transforming the coordinates (rescaling)
     */
    private Point2D inverseCoordinates(MouseEvent event) {
        /**
         * firstly, get the mouse coordinates (the mouse coordinates correspond to the position where the mouse is
         * located on the game panel)
         * the type has to be "double" because the mouse does not jump over the game panel from pixel corner to pixel
         * corner but continuously over the entire game panel area
         */
        double mouseXCoord = event.getX();
        double mouseYCoord = event.getY();
        /**
         * and secondly, inverse scaling the mouse coordinates and throw a new "RuntimeException"
         */
        try {
            Point2D inverseCoord = this.affine.inverseTransform(mouseXCoord, mouseYCoord);
            return inverseCoord;
        } catch (NonInvertibleTransformException e) {
            throw new RuntimeException("The coordinates cannot be inverted!");
        }
    }

    /**
     * the method "drawMouse" applies the inversion of the coordinates coded in the method "inverseCoordinates"
     * because the "setState" accepts as a type integers, the coordinates have to be casted
     * if the user clicks (drags) with the mouse (or keeps it pressed and drags over the game panel), then the pixel
     * has to be alive (because default is "PixelState drawingState = PixelState.ALIVE_STATE")
     * furthermore, if a simulation is ongoing, the user should not have the possibility to draw over the game panel
     */
    private void drawMouse(MouseEvent event) {
        /**
         * if a simulation is ongoing, the user should not have the possibility to draw over the game panel --> return
         * "nothing"
         */
        if (this.clickMode == SIMULATION_MODE) {
            return;
        }
        Point2D inverseCoord = inverseCoordinates(event);
        /**
         * casting of the mouse coordinates X
         */
        int mouseXCoord = (int) inverseCoord.getX();
        /**
         * casting of the mouse coordinates Y
         */
        int mouseYCoord = (int) inverseCoord.getY();
        /**
         * if the user clicks (drags) with the mouse, then the pixel has to be alive (because the "drawingState" has
         * been defied as default alive pixel)
         */
        this.originalGamePanel.setState(mouseXCoord, mouseYCoord, drawingState);
        /**
         * finally, draw the alive particular pixel which is clicked by the user on game panel
         */
        drawing();
    }

    /**
     * the method "drawExtension" is only an extension of the method "drawing" (it means, to keep the method "drawing"
     * clean and provide an overview, it has been splitted)
     * the method "drawExtension" basically goes through the whole game panel (for loops) and colours the field which
     * are alive
     */
    private void drawingExtension(GamePanel gamePanel) {
        /**
         * screening over the entire game panel and alive pixels are coloured in dark blue (the colour is choose by
         * chance)
         */
        for (int x = 0; x < gamePanel.panelWidth(); x++) {
            for (int y = 0; y < gamePanel.panelHeight(); y++) {
                /**
                 * here is the comparison implemented, if state of the pixel is indeed alive, then colour it
                 */
                if (gamePanel.getState(x, y) == PixelState.ALIVE_STATE) {
                    /**
                     * GraphicsContext is used to issue stuff to the canvas
                     */
                    GraphicsContext graphic = this.canvas.getGraphicsContext2D();
                    graphic.setFill(Color.DARKBLUE);
                    graphic.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    // == public methods ==

    /**
     * the method "drawing" is responsible for the graphics prepared for the user
     * as already commented in the method "drawExtension", the method "drawing" is basically the main drawing method
     * and the method "drawExtension" extends only a fragment for keeping the method  "drawing" clean as possible
     */
    public void drawing() {
        /**
         * GraphicsContext is used to issue stuff to the canvas
         */
        GraphicsContext graphic = this.canvas.getGraphicsContext2D();
        /**
         * while the method "inverseCoordinates" inverses the coordinates (rescaling) and the method "drawMouse"
         * applies this inversion, the line below executes basically the assignment "this.affine = new Affine();"
         * listed in the constructor
         */
        graphic.setTransform(this.affine);
        /**
         * the canvas is covered by the white colour (the colour is choose by chance)
         */
        graphic.setFill(Color.WHITE);
        /**
         * the game panel is covered by the white colour
         */
        graphic.fillRect(0, 0, 400, 400);
        /**
         * the if else statement below makes a comparison: if the click mode (CLICK_MODE) is active, the colouring can
         *  be proceeded on the instantiated game panel (this.originalGamePanel) manually (by the user), if this is not
         *  the case, then the simulation colouring mode will be proceeded (by applying the corresponding rules)
         */
        if (this.clickMode == CLICK_MODE) {
            drawingExtension(this.originalGamePanel);
        } else {
            /**
             * note that the statement below means, if the click mode is not active, respectively, if the simulation
             * mode is ongoing, then it is primarily assigned to the stepwise simulation mode
             * nevertheless, in the class "GameServiceAutoSimulationMode" it is shown, that the auto simulation mode is
             * based on the stepwise simulation mode integrated with a time constant
             */
            drawingExtension(this.gameServiceStepwiseSimulationMode.getGamePanel());
        }
        /**
         * visualizing the grid of the game panel with according line width in black (the colour is choose by chance)
         */
        graphic.setStroke(Color.BLACK);
        graphic.setLineWidth(0.05f);
        for (int x = 0; x <= this.originalGamePanel.panelWidth(); x++) {
            graphic.strokeLine(x, 0, x, 20);
        }
        for (int y = 0; y <= this.originalGamePanel.panelHeight(); y++) {
            graphic.strokeLine(0, y, 20, y);
        }
    }

    /**
     * getter method relevant for the class "GameServiceButton"
     * returns the manual simulation mode (see also class "GameServiceButton" --> method "nextButton" and
     * "switchingToSimulationMode")
     */
    public GameServiceStepwiseSimulationMode getStepwiseSimulationMode() {
        return this.gameServiceStepwiseSimulationMode;
    }

    /**
     * setter method relevant for the class "GameServiceButton"
     * draws an alive or dead pixel (see also class "GameServiceButton" --> method "drawButton" and "deleteButton")
     */
    public void setDrawing(PixelState setDrawing) {
        this.drawingState = setDrawing;
    }

    /**
     * setter method relevant for the class "GameServiceButton" (see also class "GameServiceButton" --> method
     * "startButton", "stopButton" and "switchingToSimulationMode")
     * the method "transitGamePanel" stays with the "originalGamePanel" if the user is still in the click mode, otherwise
     * if the user switches to the simulation mode, then the "originalGamePanel" will be transited to the simulation
     * mode
     */
    public void transitGamePanel(int switchingBetweenTheSimulationModes) {
        if (switchingBetweenTheSimulationModes == this.clickMode) {
            return;
        }
        if (switchingBetweenTheSimulationModes == SIMULATION_MODE) {
            this.gameServiceStepwiseSimulationMode = new GameServiceStepwiseSimulationMode(this.originalGamePanel,
                    new RulesImpl());
        }
        this.clickMode = switchingBetweenTheSimulationModes;
    }

    /**
     * getter method relevant for the class "GameServiceButton"
     * returns the click mode (see also class "GameServiceButton" --> method "switchingToSimulationMode")
     */
    public int clickMode() {
        return clickMode;
    }
}