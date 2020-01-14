package ch.zhaw.gameconsoleapp.guessnumber.web.util;

/**
 * ViewNameUrlMappings
 * Map ViewNameDefinition constants to the website's url's.
 *
 * @author created by Urs Albisser, on 2020-01-13
 * @version 1.0
 */
public final class ViewNameUrlMappings {


	// == constants ==
	public static final String PLAY = "play";
	public static final String REDIRECT_PLAY = "redirect:/" + PLAY; // redirect back to "play"
	public static final String RESTART = "restart";
	public static final String HOME = "/";


	// == constructors ==
	/**
	 * ViewNameUrlMappings()
	 * Constructor: Only constants are used in this class, nothing has to be initialized.
	 * Therefore, the constructor does not implement any logic.
	 */
	private ViewNameUrlMappings(){}
}
