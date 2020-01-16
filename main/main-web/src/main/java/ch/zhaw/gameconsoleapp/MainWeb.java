package ch.zhaw.gameconsoleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MainWeb
 * Main Web Class, starting the Spring Boot Web Application.
 *
 * atSpringBootApplication: Enables automatic bean-scanning of it's current package
 * and all sub-packages (ch.zhaw.gameconsoleapp** (in all Modules)).
 *
 * @author created by Urs Albisser, on 2019-12-04
 * @version 1.0
 */
@SpringBootApplication
public class MainWeb {

	/**
	 * main()
	 * Initiation of Spring Boot Web application
	 *
	 * @param args Arguments to be passed for application start.
	 */
	public static void main(String[] args) {
		SpringApplication.run(MainWeb.class, args);
	}

}
