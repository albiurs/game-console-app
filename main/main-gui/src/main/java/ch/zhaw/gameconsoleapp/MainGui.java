package ch.zhaw.gameconsoleapp;

import ch.zhaw.gameconsoleapp.gameoflife.core.service.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MainGui
 * MainGui Class, starting the JavaFX application with Spring Boot Application.
 * <p>
 * atSpringBootApplication: Enables automatic bean-scanning of it's current package
 * and all sub-packages (ch.zhaw/** (in all Modules)).
 *
 * @author created by Urs Albisser, Slavisa Obradovic on 2019-12-04
 * @version 1.0
 */
@SpringBootApplication
public class MainGui extends Application {


	// == fields ==
	private GameServiceMainOperations gameServiceMainOperations;


	// == public methods ==
    /**
     * main()
     * Initiation of Gui Application
     *
     * @param args Arguments to be passed for application start.
     */
    public static void main(String[] args) {
		SpringApplication.run(MainGui.class, args);
        Application.launch(args);
    }

	/**
	 * start()
	 * Start the JavaFX application
	 *
	 * @param stage Stage
	 * @throws Exception Exception
	 */
	@SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {

		// creating of a new object of type "GameServiceMainOperations"
		gameServiceMainOperations = new GameServiceMainOperations();

		// creating of a new object of type "Scene"
		Scene scene = new Scene(gameServiceMainOperations);

		// implementing the title and scene on the stage and show it
		stage.setTitle("Game Of Life");
		stage.setScene(scene);
		stage.show();

		// draw the pixels of the game panel from the beginning (without the line coded below, a GUI would pup up but no
		// game panel, until the user clicks on the GUI)
		gameServiceMainOperations.drawing();

    }
}
