/**
 * THIS TESTING CLASS TESTS THE GAME RULES
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
// * testing of the rules
// * 1. any live cell with fewer than two live neighbours dies, as if by underpopulation
// * 2. any live cell with two or three live neighbours lives on to the next generation
// * 3. any live cell with more than three live neighbours dies, as if by overpopulation
// * 4. any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
// *
// * @author created by Slavisa Obradovic, on 2020-01-01
// * @version 1.0
// */
//@ExtendWith(SpringExtension.class)
//class RulesImplTest {
//
//    // == fields ==
//    @Mock
//    private GamePanel gamePanel;
//    private Rules rules;
//
//    // == setup & teardown ==
//    @BeforeEach
//    void setUp() {
//        /**
//         * creating of a new objects of type "GamePanelImpl" and "RulesImpl", respectively
//         * the rules are tested on a 3 x 3 matrix
//         */
//        gamePanel = new GamePanelImpl();
//        rules = new RulesImpl();
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    /**
//     * this method tests the first case:
//     * "any live cell with fewer than two live neighbours dies, as if by underpopulation"
//     * while no live neighbour is present
//     */
//    @Test
//    void alive_noNeighbours() {
//        gamePanel.setState(1, 1, PixelState.ALIVE_STATE);
//        PixelState alive_noNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, alive_noNeighbours);
//    }
//
//    /**
//     * this method tests the first case:
//     * "any live cell with fewer than two live neighbours dies, as if by underpopulation"
//     * while one live neighbour is present
//     */
//    @Test
//    void alive_oneNeighbours() {
//        gamePanel.setState(1, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 0, PixelState.ALIVE_STATE);
//        PixelState alive_oneNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, alive_oneNeighbours);
//    }
//
//    /**
//     * this method tests the second case:
//     * "any live cell with two or three live neighbours lives on to the next generation"
//     * while two live neighbours are present
//     */
//    @Test
//    void alive_twoNeighbours() {
//        gamePanel.setState(1, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(1, 2, PixelState.ALIVE_STATE);
//        PixelState alive_twoNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.ALIVE_STATE, alive_twoNeighbours);
//    }
//
//    /**
//     * this method tests the second case:
//     * "any live cell with two or three live neighbours lives on to the next generation"
//     * while three live neighbours are present
//     */
//    @Test
//    void alive_threeNeighbours() {
//        gamePanel.setState(1, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(2, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        PixelState alive_threeNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.ALIVE_STATE, alive_threeNeighbours);
//    }
//
//    /**
//     * this method tests the third case:
//     * "any live cell with more than three live neighbours dies, as if by overpopulation"
//     * while four live neighbours are present
//     */
//    @Test
//    void alive_fourNeighbours() {
//        gamePanel.setState(1, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(2, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(1, 0, PixelState.ALIVE_STATE);
//        PixelState alive_fourNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, alive_fourNeighbours);
//    }
//
//    /**
//     * this method tests the fourth case:
//     * "any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
//     * while no live neighbour is present and the cell is in a dead state as well
//     */
//    @Test
//    void dead_noNeighbours() {
//        gamePanel.setState(1, 1, PixelState.DEAD_STATE);
//        PixelState dead_noNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, dead_noNeighbours);
//    }
//
//    /**
//     * this method tests the fourth case:
//     * "any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
//     * while one live neighbour is present and the cell is in a dead state
//     */
//    @Test
//    void dead_oneNeighbours() {
//        gamePanel.setState(1, 1, PixelState.DEAD_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        PixelState dead_oneNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, dead_oneNeighbours);
//    }
//
//    /**
//     * this method tests the fourth case:
//     * "any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
//     * while two live neighbours are present and the cell is in a dead state
//     */
//    @Test
//    void dead_twoNeighbours() {
//        gamePanel.setState(1, 1, PixelState.DEAD_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(1, 2, PixelState.ALIVE_STATE);
//        PixelState dead_twoNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, dead_twoNeighbours);
//    }
//
//    /**
//     * this method tests the fourth case:
//     * "any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
//     * while three live neighbours are present and the cell is in a dead state
//     */
//    @Test
//    void dead_threeNeighbours() {
//        gamePanel.setState(1, 1, PixelState.DEAD_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(1, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 1, PixelState.ALIVE_STATE);
//        PixelState dead_threeNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.ALIVE_STATE, dead_threeNeighbours);
//    }
//
//    /**
//     * this method tests the fourth case:
//     * "any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction"
//     * while four live neighbours are present and the cell is in a dead state
//     */
//    @Test
//    void dead_fourNeighbours() {
//        gamePanel.setState(1, 1, PixelState.DEAD_STATE);
//        gamePanel.setState(2, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(1, 2, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 1, PixelState.ALIVE_STATE);
//        gamePanel.setState(0, 2, PixelState.ALIVE_STATE);
//        PixelState dead_fourNeighbours = rules.nextState(1, 1, gamePanel);
//        assertEquals(PixelState.DEAD_STATE, dead_fourNeighbours);
//    }
//}