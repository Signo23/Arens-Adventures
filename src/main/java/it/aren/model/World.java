package it.aren.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Player player;
    private final List<GameMap> maps;

    public World() {
        maps = new ArrayList<>();
    }

    /**
     * 
     * @return the player
     */
    public final Player getPlayer() {
        return player;
    }

    public final void setPlayer(final Player player) {
        this.player = player;
    }

    public void updateState() {
        //TO DO when physic is implemented
    }

    //selectMap

    public final void addMap(final GameMap map) {
        maps.add(map);
    }

}
