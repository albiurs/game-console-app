package ch.zhaw.gameconsoleapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * MainGui
 * MainGui Class, starting the JavaFX application with Spring Boot Application.
 *
 * atSpringBootApplication: Enables automatic bean-scanning of it's current package
 * and all sub-packages (ch.zhaw/** (in all Modules)).
 *
 * @author created by Urs Albisser, on 2019-12-04
 * @version 0.0.1
 */
@SpringBootApplication
public class MainGui extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent rootNode;
	private final String MAIN_FXML = "/fxml/MainWindow.fxml";

	/**
	 * main()
	 * Initiation of Gui Application
	 *
	 * @param args Arguments to be passed for application start.
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(rootNode, 400, 400));
		stage.setMinWidth(400);
		stage.setMinHeight(400);
		stage.show();
	}

	/**
	 * FXML loader
	 */
	public void init() throws Exception {
		springContext = SpringApplication.run(MainGui.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_FXML));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	public void stop() throws Exception {
		springContext.close();
	}


}
