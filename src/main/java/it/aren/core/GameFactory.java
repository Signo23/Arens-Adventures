package it.aren.core;

import it.aren.common.Point2D;
import it.aren.model.Block;
import it.aren.model.Player;

public class GameFactory {

    private static GameFactory instance;

    public static GameFactory getInstance() {
        if (instance == null) {
            instance = new GameFactory();
        }
        return instance;
    }
    public final Player createPlayer(final Point2D position) {
        return new Player(position);
    }
    public final Block createBlock(final Point2D position, final boolean drawable) {
        return new Block(position, drawable);
    }
}
