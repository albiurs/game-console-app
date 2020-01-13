package ch.zhaw.gameconsoleapp.guessnumber.web.util.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

/**
 * WebConfig
 * Spring resource template resolver:
 * This class is a template resolver that resolves templates using Spring resource resolution mechanism.
 * It's used to resolve templates from the templates directory.
 * It finds the template in the template directory, when the controller returns the view name.
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
@Component
public class DecoupledLogicSetup {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(DecoupledLogicSetup.class); 	// Initialization of Slf4j logger


	// == fields ==
	private final SpringResourceTemplateResolver templateResolver;


	// == constructors ==
	/**
	 * DecoupledLogicSetup()
	 * Constructor of the class.
	 * @param templateResolver SpringResourceTemplateResolver instance
	 */
	public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
		this.templateResolver = templateResolver;
	}


	// init ==
	/**
	 * init()
	 * Spring Boot init() method.
	 * Enable the use of the template resolver's decoupled template logic to be used in the program.
	 *
	 * atPostConstruct: called right after running the constructor.
	 */
	@PostConstruct
	public void	 init() {
		// enable the use of the template resolver's decoupled template logic to be used in the program
		// normally, ths would be enabled in the application.properties file,
		// but this is not supported in the current version yet.
		templateResolver.setUseDecoupledLogic(true);
		log.info("Decoupled template logic enabled");
	}
}
