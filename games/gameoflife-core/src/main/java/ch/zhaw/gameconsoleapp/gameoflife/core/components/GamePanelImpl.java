package ch.zhaw.gameconsoleapp.gameoflife.core.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * this class contains methods which describe the stats visible on the game panel
 * the methods "copyState", "getState" and "setState" have been successfully test with JUnit (see "GamePanelTest")
 *
 * @author created by Slavisa Obradovic, on 2020-01-01
 * @version 1.0
 */
@Component
public class GamePanelImpl implements GamePanel {

    // == constants ==

    /**
     * width of the game panel
     */
    public int width;
    /**
     * height of the game panel
     */
    public int height;

    // == fields ==

    /**
     * 2D-Array of the game panel
     */
    public PixelState[][] gamePanel;

    // == constructors ==

    @Autowired
    public GamePanelImpl(int width, int height) {
        /**
         * initialization of the instance variables
         */
        this.width = width;
        this.height = height;
        /**
         * initialization and creating of a new object of type "PixelState"
         */
        this.gamePanel = new PixelState[width][height];
        /**
         * looping (screening) over the entire game panel and set all pixels to a dead state as a start position
         */
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                setState(x, y, PixelState.DEAD_STATE);
            }
        }
    }

    // == public methods ==

    /**
     * method "copyState" copies the current constellation visible on the game panel
     */
    @Override
    public GamePanelImpl copyState() {
        /**
         * create a new "GamePanelImpl" object with the name "copy"
         */
        GamePanelImpl copy = new GamePanelImpl(this.width, this.height);
        /**
         * looping (screening) over the entire game panel and assign (set) to the "copy" object the state which has
         * been detected (get)
         */
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                copy.setState(x, y, this.getState(x, y));
            }
        }
        /**
         * return the new state by returning the "copy" object back
         */
        return copy;
    }

    /**
     * method "getState" pads pixels outside of the game panel with zeros
     * padding (like in image processing) is necessary because once the corner pixel has to define its neighbours, it
     * has to know if the pixel out out game panel is dead or alive (logically the pixels outside of the game panel
     * have to be declared as dead)
     * moreover, without padding the code is running to following error: ArrayIndexOutOfBoundsException"
     * finally, the method "getState" checks the position of the coordinates, makes sure they are not out of game panel
     * and requests the coordinates back
     */
    @Override
    public PixelState getState(int x, int y) {
        /**
         * if x coordinates are outside of the game panel, the pixel state is declared as dead
         */
        if (x < 0 || x >= this.width) {
            return PixelState.DEAD_STATE;
        }
        /**
         * if y coordinates are outside of the game panel, the pixel state is declared as dead
         */
        if (y < 0 || y >= this.height) {
            return PixelState.DEAD_STATE;
        }
        /**
         * otherwise the coordinates within the game panel has to be returned (does`t matter if alive or dead)
         */
        return this.gamePanel[x][y];
    }

    /**
     * method "setState" follows the same logic like the previous method ("getState") with the major difference, that
     * it does not request the coordinates back but sets on this particular position the status of the pixel (even alive
     * or dead)
     */
    @Override
    public void setState(int x, int y, PixelState pixelState) {
        /**
         * if x coordinates are outside of the game panel, return "nothing"
         */
        if (x < 0 || x >= this.width) {
            return;
        }
        /**
         * if y coordinates are outside of the game panel, return "nothing"
         */
        if (y < 0 || y >= this.height) {
            return;
        }
        /**
         * otherwise expose the pixel state at that particular position
         */
        this.gamePanel[x][y] = pixelState;
    }

    /**
     * method "panelWidth" returns the current game panel width (important for the implementation in the class
     * "GameServiceMainOperations")
     */
    @Override
    public int panelWidth() {
        return this.width;
    }

    /**
     * method "panelHeight" returns the current game panel width (important for the implementation in the class
     * "GameServiceMainOperations")
     */
    @Override
    public int panelHeight() {
        return this.height;
    }
}