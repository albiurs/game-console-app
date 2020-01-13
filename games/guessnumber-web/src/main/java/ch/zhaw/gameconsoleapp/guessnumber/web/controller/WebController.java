package ch.zhaw.gameconsoleapp.guessnumber.web.controller;

import ch.zhaw.gameconsoleapp.guessnumber.web.service.WebGameLogicService;
import ch.zhaw.gameconsoleapp.guessnumber.web.util.AttributeNames;
import ch.zhaw.gameconsoleapp.guessnumber.web.util.ViewNameDefinitions;
import ch.zhaw.gameconsoleapp.guessnumber.web.util.ViewNameUrlMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WebController
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
@Controller
public class WebController {


	// == constants ==
	private static final Logger log = LoggerFactory.getLogger(WebController.class); 	// Initialization of Slf4j logger


	// == fields ==
	private final WebGameLogicService webGameLogicService;


	// == constructors ==
	@Autowired
	public WebController(WebGameLogicService webGameLogicService) {
		this.webGameLogicService = webGameLogicService;
	}


	// == request methods ==
	/**
	 * play()
	 * Request method for displaying the play page and then for displaying the form after the user has typed in
	 * the guess.
	 *
	 * atGetMapping(): Gets the mapping of ViewNameUrlMappings.PLAY.
	 * Therefore, this method will be called for the /play mapping.
	 *
	 * @param model Spring UI Model instance
	 * @return ViewNameDefinitions.GAME_OVER or ViewNameDefinitions.PLAY, depending on webGameLogicService.isGameOver()
	 */
	@GetMapping(ViewNameUrlMappings.PLAY)
	public String play(Model model) {
		// If the attribute is MAIN_MESSAGE, webGameLogicService.getPreGuessMessage() will be called to pull the msg.
		model.addAttribute(AttributeNames.MAIN_MESSAGE, webGameLogicService.getPreGuessMessage());
		// If the attribute is RESULT_MESSAGE, webGameLogicService.getPostGuessMessage() will be called to pull the msg.
		model.addAttribute(AttributeNames.RESULT_MESSAGE, webGameLogicService.getPostGuessMessage());
		// print the according model to the console log
		log.info("Model submitted as parameter in WebController.play() = {}", model);

		// if game is over -> return "game-over"
		if(webGameLogicService.isGameOver()) {
			log.info("webGameLogicService.isGameOver() = {}", webGameLogicService.isGameOver());
			return ViewNameDefinitions.GAME_OVER;
		}

		// if game is NOT over -> return "play"
		return ViewNameDefinitions.PLAY;
	}

	@PostMapping(ViewNameUrlMappings.PLAY)
	public String processMessage(@RequestParam int guessValue) {
		log.info("guess = {}", guessValue);
		webGameLogicService.guessTheNumber(guessValue);
		return ViewNameUrlMappings.REDIRECT_PLAY;
	}

	@GetMapping(ViewNameUrlMappings.RESTART)
	public String restart() {
		webGameLogicService.resetGame();
		return ViewNameUrlMappings.REDIRECT_PLAY;
	}
}
