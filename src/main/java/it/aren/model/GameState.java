package it.aren.model;

import it.aren.core.GameFactory;

public class GameState {

    private final World world;

    public GameState() {
        world = new World();
        world.setPlayer(GameFactory.createPlayer());
        world.addMap(GameFactory.loadMaps());
        world.setCurrentMap(0);
    }
    public final World getWorld() {
        return world;
    }
    public final void update() {
        world.updateState();
    }
}
