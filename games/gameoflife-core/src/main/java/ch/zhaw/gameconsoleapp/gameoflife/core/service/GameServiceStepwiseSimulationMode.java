package ch.zhaw.gameconsoleapp.gameoflife.core.service;

import ch.zhaw.gameconsoleapp.gameoflife.core.components.PixelState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * this class contains methods necessary for proceeding manually simulation
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
@Component
public class GameServiceStepwiseSimulationMode {

    // == fields ==

    /**
     * classes, which are relevant for the class "GameServiceStepwiseSimulationMode" are implemented below
     */
    private GamePanel gamePanel;
    private Rules rules;

    // == constructor ==
    @Autowired
    public GameServiceStepwiseSimulationMode(GamePanel gamePanel, Rules rules) {
        /**
         * initialization of the instance variables
         */
        this.gamePanel = gamePanel;
        this.rules = rules;
    }

    // == public methods ==

    /**
     * the method "newState" lunches the next (updated) state
     * firstly, it copies the current constellation visible on the game panel
     * then, it loops (screens) over the entire board
     * and finally, it declares the new state as the current state
     * note: in the class "AutoSimulationMode" it is shown, that the auto simulation mode is based on the stepwise
     * simulation mode integrated with a time constant (effectively, it takes the method "newState" and applies it
     * automatically with the given time interval)
     */
    public void newState() {
        /**
         * method "copyState" copies the current constellation visible on the game panel and assigns it to the
         * variable "thisState"
         */
        GamePanel thisState = gamePanel.copyState();
        /**
         * looping (screening) over the entire game panel
         */
        for (int y = 0; y < gamePanel.panelWidth(); y++) {
            for (int x = 0; x < gamePanel.panelHeight(); x++) {
                /**
                 * applying to the screened game panel the method "nextState"
                 * however, target of the method "nextState" is to count the alive pixels and applies the rules
                 * declared in the class "RulesMain"
                 */
                PixelState newState = rules.nextState(x, y, gamePanel);
                /**
                 * the variable "thisState" stets the new state as the valid (updated) state
                 */
                thisState.setState(x, y, newState);
            }
        }
        /**
         * and finally, declaring of the new state as the current state
         */
        this.gamePanel = thisState;
    }

    /**
     * getter returns updated game panel (this method is relevant for the class "MainActivities" --> method
     * "drawing")
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }
}