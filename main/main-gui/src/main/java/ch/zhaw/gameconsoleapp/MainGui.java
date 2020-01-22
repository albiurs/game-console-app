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
//@SpringBootApplication(scanBasePackages={"ch.zhaw.gameconsoleapp.gameoflife.core.service"})
@SpringBootApplication
public class MainGui extends Application {


	// == fields ==
//	private ConfigurableApplicationContext springContext;

	private GameServiceMainOperations gameServiceMainOperations;
//	private GameServiceAutoSimulationMode gameServiceAutoSimulationMode;
//	private GameServiceStepwiseSimulationMode gameServiceStepwiseSimulationMode;
//	private GamePanel gamePanel;
//	private RulesImpl rules;

//	private Parent rootNode;
//	private final String MAIN_FXML = "/fxml/MainWindow.fxml";


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

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws Exception {

		// creating of a new object of type "GameServiceMainOperations"
//		GameServiceMainOperations gameServiceMainOperations = new GameServiceMainOperations();

		// creating of a new object of type "Scene"
		// the size of the game panel is choose by chance
//		Scene scene = new Scene(gameServiceMainOperations, 500, 535);
		gameServiceMainOperations = new GameServiceMainOperations();
		Scene scene = new Scene(gameServiceMainOperations);

		// implementing the title and scene on the stage and show it
		stage.setTitle("Game Of Life");
		stage.setScene(scene);
		// stage.setScene(new Scene(rootNode, 400, 400));
		stage.show();

		// draw the pixels of the game panel from the beginning (without the line coded below, a GUI would pup up but no
		// game panel, until the user clicks on the GUI)
		gameServiceMainOperations.drawing();

    }

    /**
	 * Spring Context init
	 * Initiation of Spring Boot Boot Context, by loading and initializing all the required Beans,
	 * before booting the JavaFX application.
	 */
//	public void init() throws Exception {
//		springContext = SpringApplication.run(MainGui.class);
//
//		gameServiceMainOperations = new GameServiceMainOperations();
//		springContext.getBean(gameServiceMainOperations.getClass());
//
//		gameServiceAutoSimulationMode = new GameServiceAutoSimulationMode(gameServiceMainOperations, gameServiceStepwiseSimulationMode);
//		springContext.getBean(gameServiceAutoSimulationMode.getClass());
//
//		gameServiceStepwiseSimulationMode = new GameServiceStepwiseSimulationMode(gamePanel, rules);
//		springContext.getBean(gameServiceStepwiseSimulationMode.getClass());
//
//		gamePanel = new GamePanelImpl();
//		springContext.getBean(gamePanel.getClass());
//
//		rules = new RulesImpl();
//		springContext.getBean(rules.getClass());

//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_FXML));
//		fxmlLoader.setControllerFactory(springContext::getBean);
//		rootNode = fxmlLoader.load();
//	}

//    public void stop() throws Exception {
//        springContext.close();
//    }
}
