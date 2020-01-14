package ch.zhaw.gameconsoleapp.guessnumber.core.config;

import ch.zhaw.gameconsoleapp.guessnumber.core.annotationinterface.DefaultGuessCount;
import ch.zhaw.gameconsoleapp.guessnumber.core.annotationinterface.MaxNumber;
import ch.zhaw.gameconsoleapp.guessnumber.core.annotationinterface.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * GameConfig
 * Configuration class for the Guess Number Game's specific parameters.
 *
 * atConfiguration		Spring-managed configuration class
 * atComponentScan		basePackage to be scanned for Spring Components
 * atPropertySource		classpath to be scanned for game property files
 *
 * @author created by Urs Albisser, on 2020-01-04
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = "ch.zhaw.gameconsoleapp.guessnumber")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

	// == fields ==
	@Value("${game.maxNumber:20}")
	private int maxNumber;

	@Value("${game.guessCount:7}")
	private int DefaultMaxGuessCount;

	@Value("${game.minNumber:5}")
	private int minNumber;


	// == public bean methods ==
	/**
	 * maxNumber()
	 * @return	Maximum number in range.
	 */
	@Bean
	@MaxNumber
	public int maxNumber() {
		return maxNumber;
	}

	/**
	 * minNumber()
	 * @return	Minimum number in range.
	 */
	@Bean
	@MinNumber
	public int minNumber() {
		return minNumber;
	}

	/**
	 * DefaultMaxGuessCount()
	 * @return	Default maximum guess count allowed.
	 */
	@Bean
	@DefaultGuessCount
	public int DefaultMaxGuessCount() {
		return DefaultMaxGuessCount;
	}
}
