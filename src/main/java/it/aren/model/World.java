package it.aren.model;

import java.util.ArrayList;
import java.util.List;

public class World {

    private Player player;
    private final List<GameMap> maps;
    private GameMap currentMap;

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
    /**
     * 
     * @param player to set
     */
    public final void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * 
     * @param map the map to add
     */
    public final void addMap(final GameMap map) {
        maps.add(map);
    }
    /**
     * 
     * @return the current map
     */
    public final GameMap getCurrentMap() {
        return currentMap;
    }
    /**
     * 
     * @param index of the current map
     */
    public final void setCurrentMap(final int index) {
        currentMap = maps.get(index);
    }
    public void updateState() {
        //TO DO when physic is implemented
    }


}
