package ch.zhaw.gameconsoleapp.gameoflife.core.components;

/**
 * this interface belongs to the class "RulesImpl"
 * the methods are described in the class "RulesImpl"
 *
 *  @author created by Slavisa Obradovic, on 2020-01-01
 *  @version 1.0
 */
public interface Rules {
    PixelState nextState(int x, int y, GamePanel gamePanel);
}