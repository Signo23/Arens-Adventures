package it.aren.model.game;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Direction;
import it.aren.common.Vector2D;
import it.aren.graphic.Component;
import it.aren.common.Vector;
import it.aren.input.InputComponent;
import it.aren.input.InputController;
import it.aren.model.BaseEntity;
import it.aren.physics.PhysicsComponent;

/**
 * Model for the player.
 * Extends {@link BaseEntity}
 *
 */
public class Player extends BaseEntity {

    private Direction lastDirection;
    private List<GameObject> backPack;
    private boolean idle;
    private PhysicsComponent phy;
    private InputComponent input;

    /**
     * Create a player.
     * @param position the {@link Vector2D} where the player is
     * @param graphic the {@link GraphicComponent} for draw the player
     * @param input the {@link InputComponent} for listen the input for player
     * @param phy the {@link PhysicsComponent} update position of player
     */
    public Player(final Vector position, final Component graphic, final InputComponent input,
                  final PhysicsComponent phy) {
        super(position, true, graphic);
        this.lastDirection =  Direction.DOWN;
        this.backPack = new ArrayList<>();
        this.idle = false;
        this.phy = phy;
        this.input = input;
    }

    /**
     * Update the player's {@link InputComponent}.
     * @param i the {@link InputController} to use for update input state
     */
    public void updateInput(final InputController i) {
        this.input.update(this, i);
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

    /**
     * Set Player's input component.
     * @return player's {@link InputComponent}
     */
    public final InputComponent getInput() {
        return input;
    }

    /**
     * Get Player's InputComponent.
     * @param input the {@link InputComponent} to set as player's input component
     */
    public final void setInput(final InputComponent input) {
        this.input = input;
    }
}
