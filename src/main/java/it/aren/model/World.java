package it.aren.model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.aren.common.Constant;
import it.aren.common.Direction;
import it.aren.common.Point2D;
import it.aren.model.game.Block;
import it.aren.model.game.Dialog;
import it.aren.model.game.GameMap;
import it.aren.model.game.Player;
/**
 * The class that manage the game's world.
 */
public class World {

    private Player player;
    private final List<GameMap> maps;
    private GameMap currentMap;
    private Dialog dialog;

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
     * @param maps the map to add
     */
    public final void addMaps(final List<GameMap> maps) {
        this.maps.addAll(maps);
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
     * Set the dialog.
     * @param dialog
     */
    public final void setDialog(final Dialog dialog) {
        this.dialog = dialog;
    }
    /**
     * Return the dialog.
     * @return dialog
     */
    public final Dialog getDialog() {
        return this.dialog;
    }

    /**
     * Update the world's state.
     */
    public void updateState() {
        if (this.playerCollide().isEmpty()) {
            this.player.updateState();
        }
    }

    public final Optional<Block> playerCollide() {
        final Direction playerDir = this.player.getLastDirection();
        final Point2D playerPos = this.player.getPosition();
        final Rectangle playerHitBox = (Rectangle) this.player.getHitBox().clone();
        List<Block> control = new ArrayList<>();
        switch (playerDir) {
        case UP: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getY() < player.getPosition().getY())
            .collect(Collectors.toList());
            playerHitBox.setLocation((int) playerPos.getX(), (int) playerPos.getY() - Constant.DEFAULT_VEL);
            break;
        case DOWN: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getY() > player.getPosition().getY())
            .collect(Collectors.toList());
            playerHitBox.setLocation((int) playerPos.getX(), (int) playerPos.getY() + Constant.DEFAULT_VEL);
            break;
        case LEFT:
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getX() < player.getPosition().getX())
            .collect(Collectors.toList());
            playerHitBox.setLocation((int) playerPos.getX() - Constant.DEFAULT_VEL, (int) playerPos.getY());
            break;
        case RIGHT: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getX() > player.getPosition().getX())
            .collect(Collectors.toList());
            playerHitBox.setLocation((int) playerPos.getX() + Constant.DEFAULT_VEL, (int) playerPos.getY());
            break;
        default: 
            break;
        }
        for (final Block b : control) {
            if (playerHitBox.intersects(b.getHitBox())) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }
}
