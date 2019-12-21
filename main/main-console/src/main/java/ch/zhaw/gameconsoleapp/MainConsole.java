package ch.zhaw.gameconsoleapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main
 * Main Class, starting the Spring Boot Application.
 *
 * atSpringBootApplication: Enables automatic bean-scanning of it's current package and all sub-packages (ch.zhaw/** (in all Modules)).
 *
 * @author created by Urs Albisser, on 2019-12-04
 * @version 0.0.1
 */
@SpringBootApplication
public class MainConsole {

	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(MainConsole.class);	// Initialization of Slf4j logger


	/**
	 * main()
	 * Initiation of console application
	 *
	 * @param args Arguments to be passed for application start.
	 */
	public static void main(String[] args) {

		// Enable console logging
		log.info("== Game Console App ==");
		log.info("Core Main.main() method called");
		log.info("Start of application initiated");

		// SpringApplication.run(): Method to start the whole Spring Framework.
		log.info("SpringApplication.run() initiated");
		SpringApplication.run(MainConsole.class, args);
		log.info("SpringApplication.run() terminated");

	}

}
