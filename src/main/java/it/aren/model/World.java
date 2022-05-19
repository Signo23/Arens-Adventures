/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.aren.common.Constant;
import it.aren.common.Point2D;
/**
 * The class that manage the game's world.
 */
public class World {

    private Player player;
    private final List<GameMap> maps;
    private GameMap currentMap;

    /**
     * Creates a new ArrayList for the maps.
     */
    public World() {
        this.maps = new ArrayList<>();
    }

    /**
     * Return the player.
     * @return player
     */
    public final Player getPlayer() {
        return this.player;
    }
    /**
     * Set the player.
     * @param player to set
     */
    public final void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * Add a new game map to the ArrayList.
     * @param map the map to add
     */
    public final void addMap(final GameMap map) {
        this.maps.add(map);
    }
    /**
     * Return the map to view on the screen.
     * @return currentMap
     */
    public final GameMap getCurrentMap() {
        return this.currentMap;
    }
    /**
     * Set the currentMap.
     * @param index of the current map
     */
    public final void setCurrentMap(final int index) {
        this.currentMap = maps.get(index);
    }
    /**
     * Update the world's state.
     */
    public void updateState() {
        if(! this.isPlayerColliding()) {
            this.player.updateState();
        }
    }
    
    private boolean isPlayerColliding() {
        final Point2D playerPos = this.player.getLastDirection();
        List<Block> control = new ArrayList<>();
        if(playerPos.equals(Constant.UP)) {
            control = this.currentMap.getBlocks().stream()
                    .filter(b -> b.getPosition().getY() <= player.getPosition().getY())
                    .collect(Collectors.toList());
        }
        if(playerPos.equals(Constant.DOWN)) {
            control = this.currentMap.getBlocks().stream()
                    .filter(b -> b.getPosition().getY() <= player.getPosition().getY())
                    .collect(Collectors.toList());
        }
        if(playerPos.equals(Constant.LEFT)) {
            control = this.currentMap.getBlocks().stream()
                    .filter(b -> b.getPosition().getX() <= player.getPosition().getX())
                    .collect(Collectors.toList());
        }
        if(playerPos.equals(Constant.RIGHT)) {
            control = this.currentMap.getBlocks().stream()
                    .filter(b -> b.getPosition().getX() <= player.getPosition().getX())
                    .collect(Collectors.toList());
        }
        for(final Block b : control) {
            if(this.player.getHitBox().intersects(b.getHitBox())) {
                return true;
            }
        }
        return false;
    }
}
