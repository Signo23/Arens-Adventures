package it.aren.model;

public class World {

    private Player player;
    private GameMap map;

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
    /**
     * 
     * @return the map to view
     */
    public final GameMap getMap() {
        return map;
    }

    public final void setMap(final GameMap map) {
        this.map = map;
    }

    public void updateState() {
        //TO DO when physic is implemented
    }
}
