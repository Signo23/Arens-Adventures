/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Direction;
import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.input.InputComponent;
import it.aren.input.InputController;
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
     * @param position where the player have to set
     * @param graphic for draw the player
     * @param input for listen the input for player
     * @param phy for update position of player
     * @param ratio ratio for hitBox
     */
    public Player(final Point2D position, final GraphicComponent graphic, final InputComponent input, final PhysicsComponent phy) {
        super(position, true, graphic);
        this.lastDirection =  Direction.DOWN;
        this.backPack = new ArrayList<>();
        this.idle = false;
        this.phy = phy;
        this.input = input;
    }
    
    /**
     * {@inheritDoc}
     */
    public void updateInput(final InputController i) {
        this.input.update(this, i);
    }

    /**
     * Update the Entity's {@link PhysicsComponent}.
     */
    public void updateState() {
        this.phy.update(this);
    }

    /**
     * Get Player's last direction.
     * @return the lastDirection
     */
    public Direction getLastDirection() {
        return this.lastDirection;
    }


    /**
     * @deprecated use setLastDirection(Direction)
     * Set Player's last direction.
     * @param lastDirection the lastDirection to set
     */
    public void setLastDirection(final Point2D lastDirection) {
        this.lastDirection = Direction.valueOfPoint2D(lastDirection);
    }
    
    public void setLastDirection(final Direction lastDirection) {
        this.lastDirection = lastDirection;
    }

    /**
     * Get Player's backpack.
     * @return the backPack
     */
    public List<GameObject> getBackPack() {
        return this.backPack;
    }

    /**
     * Set Player's backpack.
     * @param backPack the backPack to set
     */
    public void setBackPack(final List<GameObject> backPack) {
        this.backPack = backPack;
    }

    /**
     * Check if Player is idle.
     * @return the idle
     */
    public boolean isIdle() {
        return this.idle;
    }

    /**
     * Set if the Player is idle.
     * @param idle the idle to set
     */
    public void setIdle(final boolean idle) {
        this.idle = idle;
    }

    /**
     * Get Player's PhysicComponent.
     * @return the Physic component
     */
    public PhysicsComponent getPhysic() {
        return this.phy;
    }

    /**
     * Set Player's PhysicComponent.
     * @param physic the physic to set
     */
    public void setPhysic(final PhysicsComponent physic) {
        this.phy = physic;
    }

    /**
     * Set Player's InputComponent.
     * @return the input
     */
    public final InputComponent getInput() {
        return input;
    }

    /**
     * Get Player's InputComponent.
     * @param input the input to set
     */
    public final void setInput(final InputComponent input) {
        this.input = input;
    }
}
