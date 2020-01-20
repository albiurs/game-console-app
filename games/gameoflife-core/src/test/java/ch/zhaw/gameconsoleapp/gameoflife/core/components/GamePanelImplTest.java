//package ch.zhaw.gameconsoleapp.gameoflife.core.components;
//
//import ch.zhaw.gameconsoleapp.gameoflife.core.components.GamePanel;
//import ch.zhaw.gameconsoleapp.gameoflife.core.components.GamePanelImpl;
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
//    public GamePanel gamePanel;
//
//    // == setup & teardown ==
//    @BeforeEach
//    void setUp() {
//        /**
//         * creating of a new object of type "GamePanelMain"
//         * test with different sizes of the board (width, height), not only square sizes (e.g. 10 x 10), but also where
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
//     * testing of the method "copyState" in the class "GamePanelMain"
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
//}