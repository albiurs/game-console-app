package ch.zhaw.gameconsoleapp.guessnumber.web.config;

import ch.zhaw.gameconsoleapp.guessnumber.web.util.ViewNameDefinitions;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 * Configuration file of the Spring Boot Web module.
 * Registers the view controller.
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * addViewControllers()
	 * Implement MVC Web Configurer
	 * Register the view controller to the main web path "/" and assign ViewName "HOME" to it.
	 * @param registry ViewControllerRegistry instance
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		// register view controller --> HOME view controller
		registry.addViewController("/").setViewName(ViewNameDefinitions.HOME);
	}
}
