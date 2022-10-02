package it.aren.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.aren.Direction;
import it.aren.HitBox;
import it.aren.Vector;
import it.aren.common.Constant;
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
     * Creates a new {@link List} for the {@link GameMap}.
     */
    public World() {
        this.maps = new ArrayList<>();
    }

    /**
     * Return the {@link Player}.
     * @return player
     */
    public final Player getPlayer() {
        return this.player;
    }
    /**
     * Set the {@link Player}.
     * @param player to set
     */
    public final void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * Add all the {@link GameMap} to the {@link List}.
     * @param maps the {@link GameMap} to add
     */
    public final void addMaps(final List<GameMap> maps) {
        this.maps.addAll(maps);
    }
    /**
     * Return the {@link GameMap} to view on the screen.
     * @return currentMap
     */
    public final GameMap getCurrentMap() {
        return this.currentMap;
    }
    /**
     * Set the map to view on the screen.
     * @param index of the current map
     */
    public final void setCurrentMap(final int index) {
        this.currentMap = this.maps.get(index);
    }
    /**
     * Set the {@link Dialog}.
     * @param dialog
     */
    public final void setDialog(final Dialog dialog) {
        this.dialog = dialog;
    }
    /**
     * Return the {@link Dialog}.
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

    /**
     * Method to check the player's collision.
     * @return a {@link Option} of {@link Block}
     */
    public final Optional<Block> playerCollide() {
        final Direction playerDir = this.player.getLastDirection();
        final Vector playerPos = this.player.getPosition();
        final HitBox playerHitBox = this.player.getHitBox().clone();
        List<Block> control = new ArrayList<>();
        switch (playerDir) {
        case UP: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getY() < player.getPosition().getY())
            .collect(Collectors.toList());
            playerHitBox.position().setY(playerPos.getY() - Constant.DEFAULT_VEL);
            break;
        case DOWN: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getY() > player.getPosition().getY())
            .collect(Collectors.toList());
            playerHitBox.position().setY(playerPos.getY() + Constant.DEFAULT_VEL);
            break;
        case LEFT:
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getX() < player.getPosition().getX())
            .collect(Collectors.toList());
            playerHitBox.position().setX(playerPos.getX() - Constant.DEFAULT_VEL);
            break;
        case RIGHT: 
            control = this.currentMap.getBlocks().stream()
            .filter(b -> b.getPosition().getX() > player.getPosition().getX())
            .collect(Collectors.toList());
            playerHitBox.position().setX(playerPos.getX() + Constant.DEFAULT_VEL);
            break;
        default: 
            break;
        }
        for (final Block b : control) {
            if (playerHitBox.isColliding(b.getHitBox())) {
                return Optional.of(b);
            }
        }
        return Optional.empty();
    }
}
