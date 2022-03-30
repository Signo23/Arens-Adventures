package it.aren.model;

import it.aren.common.Point2D;
import it.aren.core.GameFactory;

public class GameState {

    private World world;

    public GameState() {
        GameFactory factory = GameFactory.getInstance();
        world = new World();
        world.setPlayer(factory.createPlayer(new Point2D(0, 1)));
        //world.getMap().setBlocks();
    }
    public final World getWorld() {
        return world;
    }
    public final void update() {
        world.updateState();
    }
}
