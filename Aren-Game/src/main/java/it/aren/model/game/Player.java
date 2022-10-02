package it.aren.model.game;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Direction;
import it.aren.common.Vector2D;
import it.aren.input.InputController;
import it.aren.model.Component;
import it.aren.model.GameEntity;
import it.aren.model.Vector;
import it.aren.physics.PhysicsComponent;

/**
 * Model for the player.
 * Extends {@link GameEntity}
 *
 */
public class Player extends GameEntity {

    private Direction lastDirection;
    private List<GameObject> backPack;
    private boolean idle;
    private PhysicsComponent phy;
    /**
     * Create a player.
     * @param position the {@link Vector2D} where the player is
     * @param graphic the {@link GraphicComponent} for draw the player
     * @param input the {@link InputComponent} for listen the input for player
     * @param phy the {@link PhysicsComponent} update position of player
     */
    public Player(final Vector position, final Component graphic,
                  final PhysicsComponent phy) {
        super(position, true, graphic);
        this.lastDirection =  Direction.DOWN;
        this.backPack = new ArrayList<>();
        this.idle = false;
        this.phy = phy;
    }

    /**
     * Update the player's {@link PhysicsComponent}.
     */
    public void updateState() {
        this.phy.update(this);
    }

    /**
     * Get Player's last direction.
     * @return the {@link Direction} that represent the last direction
     */
    public Direction getLastDirection() {
        return this.lastDirection;
    }

    /**
     * Set Player's last direction.
     * @param lastDirection the {@link Direction} to set  player's last direction
     */
    public void setLastDirection(final Direction lastDirection) {
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

    /**
     * Check if Player is idle.
     * @return true if player is idle, false otherwise
     */
    public boolean isIdle() {
        return this.idle;
    }

    /**
     * Set if the Player is idle.
     * @param idle a boolean for set if player is idle
     */
    public void setIdle(final boolean idle) {
        this.idle = idle;
    }

    /**
     * Get Player's physic component.
     * @return the Player's {@link PhysicComponent}
     */
    public PhysicsComponent getPhysic() {
        return this.phy;
    }

    /**
     * Set Player's PhysicComponent.
     * @param physic the {@link PhysicComponent} to set as player's physic component
     */
    public void setPhysic(final PhysicsComponent physic) {
        this.phy = physic;
    }
}
