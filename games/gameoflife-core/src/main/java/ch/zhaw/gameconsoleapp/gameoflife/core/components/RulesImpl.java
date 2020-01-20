package ch.zhaw.gameconsoleapp.gameoflife.core.components;

import org.springframework.stereotype.Component;

/**
 * this class contains methods which describe the rules of "Conway's Game of Life"
 * the rules are following:
 * 1. any live cell with fewer than two live neighbours dies, as if by underpopulation
 * 2. any live cell with two or three live neighbours lives on to the next generation
 * 3. any live cell with more than three live neighbours dies, as if by overpopulation
 * 4. any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
 * the rules have been successfully test with JUnit (see "RulesTest")
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
@Component
public class RulesImpl implements Rules {

    // == public methods ==

    /**
     * the method "nextState" implements especially the other 2 methods contained in this class, namely
     * "neighboursSituation" and "countAlivePixel" (it would be recommendable to understand firstly these before
     * proceeding further with this method)
     * however, target of the method "nextState" is to count the alive pixels
     * once the number is determined, the rules listed above can be applied to the "static" pixel (this is the pixel
     * at the position (2, 2) --> see also comments of the method "neighboursSituation" depicted below)
     */
    @Override
    public PixelState nextState(int x, int y, GamePanel gamePanel) {
        /**
         * assigning the method "neighboursSituation" to the integer "aliveNeighbours"
         */
        int aliveNeighbours = neighboursSituation(x, y, gamePanel);
        /**
         * assumption would be a comparison with an alive pixel
         */
        if (gamePanel.getState(x, y) == PixelState.ALIVE_STATE) {
            /**
             * any live cell with fewer than two live neighbours dies, as if by underpopulation
             */
            if (aliveNeighbours < 2) {
                return PixelState.DEAD_STATE;
                /**
                 * any live cell with two or three live neighbours lives on to the next generation
                 */
            } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                return PixelState.ALIVE_STATE;
            } else {
                /**
                 * any live cell with more than three live neighbours dies, as if by overpopulation
                 */
                return PixelState.DEAD_STATE;
            }
        } else {
            /**
             * any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
             */
            if (aliveNeighbours == 3) {
                return PixelState.ALIVE_STATE;
            }
        }
        /**
         * if non of the above rules are true, the dead state has to be returned
         */
        return PixelState.DEAD_STATE;
    }

    /**
     * method "neighboursSituation" screens the neighbour situation (is the neighbour pixel alive or dead?) and counts
     * the alive pixels
     * by applying the rules mentioned above the starting point would be a 3 x 3 matrix, in which the "static" pixel
     * is positioned in the middle of this matrix, namely position (2, 2), and the neighbours would be the surrounded
     * 8 pixels
     * therefore, the method below contains only the surrounded coordinates of the 8 pixels and counts the total number
     * of the alive pixels, and finally returns these (further logic is applied in the method "nextState")
     */
    public int neighboursSituation(int x, int y, GamePanel gamePanel) {
        /**
         * starting point is 0
         */
        int observeNeighboursSituation = 0;
        /**
         * if cell position is at (2, 2), then we are starting to screen at upper left corner which is position (1, 1),
         * respectively, (x-1, y-1)
         * afterwards, we screen line by line, in which (2, 2) is skipped because this is the "static" pixel
         */
        observeNeighboursSituation += countAlivePixel(x - 1, y - 1, gamePanel);     // position (1, 1)
        observeNeighboursSituation += countAlivePixel(x, y - 1, gamePanel);            // position (1, 2)
        observeNeighboursSituation += countAlivePixel(x + 1, y - 1, gamePanel);     // position (1, 3)
        observeNeighboursSituation += countAlivePixel(x - 1, y, gamePanel);            // position (2, 1)
        observeNeighboursSituation += countAlivePixel(x + 1, y, gamePanel);            // position (2, 3)
        observeNeighboursSituation += countAlivePixel(x - 1, y + 1, gamePanel);     // position (3, 1)
        observeNeighboursSituation += countAlivePixel(x, y + 1, gamePanel);            // position (3, 2)
        observeNeighboursSituation += countAlivePixel(x + 1, y + 1, gamePanel);     // position (3, 3)
        /**
         * and finally return the number with alive pixels
         */
        return observeNeighboursSituation;
    }

    /**
     * the method "countAlivePixel" compares the state of the pixel at position x, y
     * if the pixel is alive it returns 1 else it returns 0
     */
    public int countAlivePixel(int x, int y, GamePanel gamePanel) {
        if (gamePanel.getState(x, y) == PixelState.ALIVE_STATE) {
            return 1;
        } else {
            return 0;
        }
    }
}