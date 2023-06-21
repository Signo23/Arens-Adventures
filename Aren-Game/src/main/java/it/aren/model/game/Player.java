package it.aren.model.game;

import java.util.ArrayList;
import java.util.List;

import it.aren.Direction;
import it.aren.Vector;
import it.aren.geom.Vector2D;
import it.aren.model.*;

/**
 * Model for the player.
 * Extends {@link GameEntity}
 *
 */
public class Player extends GameEntity {

    private Vector lastDirection;
    private List<GameObject> backPack;
    /**
     * Create a player.
     * @param position the {@link Vector2D} where the player is
     * @param phy the {@link PhysicsComponent} update position of player
     */
    public Player(final Vector position) {
        super(position, true);
        this.lastDirection = Direction.DOWN.getVector();
        this.setVelocity(Direction.NO_DIRECTION.getVector());
        this.backPack = new ArrayList<>();
    }

    /**
     * Update the player's {@link PhysicsComponent}.
     */
    public void updateState() {
        this.component(GameComponent.PHYSIC).update(this, null, null);
    }

    /**
     * Get Player's last direction.
     *
     * @return the {@link Direction} that represent the last direction
     */
    public Vector getLastDirection() {
        return this.lastDirection;
    }

    /**
     * Set Player's last direction.
     * @param lastDirection the {@link Direction} to set  player's last direction
     */
    public void setLastDirection(final Vector lastDirection) {
        this.lastDirection = lastDirection;
    }

    /**
     * Get Player's backpack.
     * @return a {@link List} of {@link GameObject} that represent the player's backpack
     */
    public List<GameObject> getBackPack() {
        return this.backPack;
    }

    /**
     * Set Player's backpack.
     * @param backPack a {@link List} of {@link GameObject} to set as player's backpack
     */
    public void setBackPack(final List<GameObject> backPack) {
        this.backPack = backPack;
    }
}
