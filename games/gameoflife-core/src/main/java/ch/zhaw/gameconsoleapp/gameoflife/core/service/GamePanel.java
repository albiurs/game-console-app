package ch.zhaw.gameconsoleapp.gameoflife.core.service;

import ch.zhaw.gameconsoleapp.gameoflife.core.components.PixelState;

/**
 * this interface belongs to the class "GamePanelImpl"
 * the methods are described in the class "GamePanelImpl"
 *
 * @author created by Slavisa Obradovic, on 2020-01-01
 * @version 1.0
 */
public interface GamePanel {
    GamePanel copyState();

    PixelState getState(int x, int y);

    void setState(int x, int y, PixelState pixelState);

    int panelWidth();

    int panelHeight();
}