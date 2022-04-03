package it.aren.core;

import it.aren.common.Point2D;
import it.aren.input.PlayerInputComponent;
import it.aren.model.GameMap;
import it.aren.model.Player;
import it.aren.graphic.PlayerGraphicComponent;

public final class GameFactory {

    private GameFactory() {

    }
    public static Player createPlayer() {
        return new Player(new Point2D(0, 1), new PlayerGraphicComponent(), new PlayerInputComponent());
    }
    public static GameMap loadMaps() {
        return new GameMap();
    }
}
