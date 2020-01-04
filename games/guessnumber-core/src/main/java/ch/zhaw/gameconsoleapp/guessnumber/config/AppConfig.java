package ch.zhaw.gameconsoleapp.guessnumber.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * AppConfig
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 0.0.1
 */
@Configuration                // Configures this class as a config class
@Import(GameConfig.class)	// Import GameConfig.class modularize configuration
@ComponentScan(basePackages = "ch.zhaw.gameconsoleapp.guessnumber")	// Instead of context:component-scan in beans.xml (deleted)
public class AppConfig {

	// == bean methods ===
	/**
	 * atBean annotation:
	 * ...indicates that a method produces a bean to be managed by the spring container.
	 * - Possibility with @Bean annotation to add additional configuration for a bean
	 * 		(instead of default @CpomponentScan without configruation).
	 * - By default: the name of the bean == name of the bean method
	 * - attribute "name" possible for explicit naming if needed.
	 * @return
	 */
//	@Bean							// default bean name = numberGenerator()
//	public NumberCalculator numberCalculator() {
//		return new NumberCalculatorImpl();
//	}

//	@Bean
//	public Game game() {
//		return new GameImpl();
//	}

//	@Bean
//	public MessageSupplier messageSupplier() {
//		return new MessageSupplierImpl();
//	}
}
