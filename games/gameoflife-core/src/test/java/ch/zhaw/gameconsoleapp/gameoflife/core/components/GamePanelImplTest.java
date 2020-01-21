/**
 * THIS TESTING CLASS TESTS THE GAME PANEL CONSTELLATION
 * ALL METHODS WORK WELL AND VERIFY DIFFERENT SCENARIOS
 * FOR LOOKING INTO IT, PLEASE PUT THE BRACKETS OUTSIDE
 *
 * THE REASON, WHY IT IS CURRENTLY BRACKET, IS BECAUSE OF APPLYING "mvn clean install" RESULTS IN SOME INACCESSIBLE TO
 * METHOD ERRORS
 * --> EVAN IF ALL METHODS FOR TESTING ARE "public"
 * --> EVEN IF OWING PACKAGES HAS BEEN EXPORTED
 * --> SOME SIMILAR INSTRUCTIONS ARE PRESENTED HERE BUT DID NOT SOLVE THE APPEARED FAILURE:
 *      https://stackoverflow.com/questions/41265266/how-to-solve-inaccessibleobjectexception-unable-to-make-member-accessible-m/41265267
 * --> AND "Maven Surefire Plugin" IS ALSO CONSIDERED, WHICH IS VISIBLE IN CHAPTER 3:
 *      https://www.baeldung.com/junit-test-execution-time
 * --> IT IS ASSUMED, IT COMES FROM SOME CONFIGURATIONS IN BACKGROUND: JUnit5 vs. JDK11
 */

//package ch.zhaw.gameconsoleapp.gameoflife.core.components;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * the following class tests the game panel
// *
// * @author created by Slavisa Obradovic, on 2020-01-01
// * @version 1.0
// */
//@ExtendWith(SpringExtension.class)
//class GamePanelImplTest {
//
//    // == fields ==
//    @Mock
//    private GamePanel gamePanel;
//
//    // == setup & teardown ==
//    @BeforeEach
//    void setUp() {
//        /**
//         * creating of a new object of type "GamePanelImpl"
//         * test with different sizes of the board (width, height), not only square sizes (e.g. 20 x 20), but also where
//         * the width and height are not the same
//         */
//        this.gamePanel = new GamePanelImpl(1000, 2000);
//
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    // == JUnit tests ==
//    /**
//     * testing of the method "copyState" in the class "GamePanelImpl"
//     * task of the method "copyState" is following: copies the current constellation visible on the game panel
//     */
//
//    /**
//     * first test would be: make sure the copy of the board is at the same size as defined before
//     */
//    @Test
//    void copyState_preservingSize() {
//        GamePanel copyState_preservingSize = gamePanel.copyState();
//
//        assertEquals(1000, copyState_preservingSize.panelWidth());
//        assertEquals(2000, copyState_preservingSize.panelHeight());
//    }
//
//    /**
//     * second test would be: make sure that the copy contains the exact same state as the original
//     */
//    @Test
//    void copyState_preservingContent() {
//        gamePanel.setState(100, 100, PixelState.ALIVE_STATE);
//        gamePanel.setState(200, 200, PixelState.ALIVE_STATE);
//        gamePanel.setState(300, 300, PixelState.ALIVE_STATE);
//
//        GamePanel copyState_preservingContent = gamePanel.copyState();
//
//        for (int x = 0; x < copyState_preservingContent.panelWidth(); x++) {
//            for (int y = 0; y < copyState_preservingContent.panelHeight(); y++) {
//                assertEquals(gamePanel.getState(x, y), copyState_preservingContent.getState(x, y));
//            }
//        }
//    }
//
//    /**
//     * third test would be: changing the new instance does not change the old one
//     */
//    @Test
//    void copyState_InstancesStateCheck() {
//        GamePanel copyState_InstancesStateCheck = gamePanel.copyState();
//
//        copyState_InstancesStateCheck.setState(50, 40, PixelState.ALIVE_STATE);
//
//        assertEquals(PixelState.ALIVE_STATE, copyState_InstancesStateCheck.getState(50, 40));
//        assertEquals(PixelState.DEAD_STATE, gamePanel.getState(50, 40));
//    }
//
//    /**
//     * testing of the methods "getState" and "setState" in the class "GamePanelImpl"
//     * task of the method "getState" is following: checks the position of the coordinates, makes sure they are not out
//     * of game panel and requests the coordinates back
//     * task of the method "setState" is following: it follows the same logic like the previous method ("getState") with
//     * the major difference, that it does not request the coordinates back but sets on this particular position the
//     * status of the pixel (even alive or dead)
//     */
//
//    /**
//     * only test would be: testing if the "setState" and "getState" work properly and do not get any exceptions
//     */
//    @Test
//    void getState_setState_noFailure() {
//        gamePanel.setState(-1, 0, PixelState.ALIVE_STATE);
//        gamePanel.setState(10, 33, PixelState.ALIVE_STATE);
//        gamePanel.setState(100, -1, PixelState.ALIVE_STATE);
//        gamePanel.setState(300, 400, PixelState.ALIVE_STATE);
//
//        gamePanel.getState(-1, 0);
//        gamePanel.getState(10, 33);
//        gamePanel.getState(100, -1);
//        gamePanel.getState(300, 400);
//    }
//
//}