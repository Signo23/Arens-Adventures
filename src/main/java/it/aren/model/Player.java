/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;
import it.aren.physics.PhysicsComponent;
import it.aren.physics.PlayerPhysicsComponent;

/**
 * Model for the player.
 * Extends {@link Entity}
 *
 */
public class Player extends Entity {

    private Point2D lastDirection;
    private List<GameObject> backPack;
    private boolean idle;
    private PhysicsComponent phy;

    /**
     * Create a player.
     * @param position where the player have to set
     * @param graphic for draw the player
     * @param input for listen the input for player
     * @param phy for update position of player
     */
    public Player(final Point2D position, final GraphicComponent graphic, final InputComponent input, final PhysicsComponent phy) {
        super(position, true, graphic, input);
        this.lastDirection = new Point2D();
        this.backPack = new ArrayList<>();
        this.idle = false;
        this.phy = phy;
    }

    /**
     * 
     * @deprecated use {@link #new(Point2D, GraphicComponent, InputComponent, PhysicsComponent)} instead.
     */
    @Deprecated
    public Player(final Point2D position, final GraphicComponent graphic, final InputComponent input) {
        this(position, graphic, input, new PlayerPhysicsComponent());
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void updateInput(final InputController i) {
        this.input.update(this, i);
    }

    /**
     * Update the player position utilizing the physic.
     */
    public void updateState() {
        this.phy.update(this);
    }

    /**
     * @return the lastDirection
     */
    public Point2D getLastDirection() {
        return lastDirection;
    }

    /**
     * @param lastDirection the lastDirection to set
     */
    public void setLastDirection(final Point2D lastDirection) {
        this.lastDirection = lastDirection;
    }

    /**
     * @return the backPack
     */
    public List<GameObject> getBackPack() {
        return backPack;
    }

    /**
     * @param backPack the backPack to set
     */
    public void setBackPack(final List<GameObject> backPack) {
        this.backPack = backPack;
    }

    /**
     * @return the idle
     */
    public boolean isIdle() {
        return idle;
    }

    /**
     * @param idle the idle to set
     */
    public void setIdle(final boolean idle) {
        this.idle = idle;
    }

    /**
     * @return the Physic component
     */
    public PhysicsComponent getPhysic() {
        return phy;
    }

    /**
     * @param the physic to set
     */
    public void setPhysic(final PhysicsComponent physic) {
        this.phy = physic;
    }
}
