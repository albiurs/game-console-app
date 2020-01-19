package ch.zhaw.gameconsoleapp.gameoflife.core.service;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * this class contains methods necessary for proceeding automatically simulation
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
@Component
public class GameServiceAutoSimulationMode {

    // == constants ==

    /**
     * "Timeline" is used to define the animation (auto simulation of the game panel)
     */
    private Timeline timeline;

    // == fields ==

    /**
     * classes, which are relevant for the class "AutoSimulationMode" are implemented below
     */
    private GameServiceMainOperations gameServiceMainOperations;
    private GameServiceStepwiseSimulationMode gameServiceStepwiseSimulationMode;

    // == constructor ==
    @Autowired
    public GameServiceAutoSimulationMode(GameServiceMainOperations gameServiceMainOperations,
                                         GameServiceStepwiseSimulationMode gameServiceStepwiseSimulationMode) {
        this.gameServiceMainOperations = gameServiceMainOperations;
        this.gameServiceStepwiseSimulationMode = gameServiceStepwiseSimulationMode;
        /**
         * a "Keyframe" takes a duration of a frame and a function to execute on its interval (the time interval is
         * choose by chance)
         */
        this.timeline = new Timeline(new KeyFrame(Duration.millis(400), this::simulateNextStep));
        /**
         * run the simulation indefinitely
         * for the user, the simulation would basically virtually stop, after the alive pixels get in a state where the
         * depicted "figures" (e.g. a square of 4 pixels) are frozen or no alive pixel is present on the game panel
         * (nevertheless, in the background, the simulation lasts until the game panel is cancelled or the step button
         * is pressed)
         */
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    // == private methods ==

    /**
     * the method "simulateNextStep" is associated with the "Timeline" and "KeyFrame" class, respectively, and draws
     * within the predefined time interval (here 400 ms) the next state of the pixels visible on the game panel (next
     * state means, it applies the rules introduced in the class "RulesImpl" on the current game panel und switches to
     * the next within the time interval)
     * the method "simulateNextStep" is associated with the "nextState" method introduced in the class
     * "GameServiceStepwiseSimulationMode" and the "drawing" method introduced int the class "GameServiceMainOperations"
     */
    private void simulateNextStep(ActionEvent actionEvent) {
        this.gameServiceStepwiseSimulationMode.newState();
        this.gameServiceMainOperations.drawing();
    }

    // == public methods ==

    /**
     * starting of the timeline (because of "this.timeline.setCycleCount(Timeline.INDEFINITE)", the timeline will last
     * for indefinitely - until it is stopped by the user)
     */
    public void startSimulation() {
        this.timeline.play();
    }

    /**
     * stopping of the timeline (because of "this.timeline.setCycleCount(Timeline.INDEFINITE)", the timeline will last
     * for indefinitely - until it is stopped by the user)
     */
    public void stopSimulation() {
        this.timeline.stop();
    }
}