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

/**
 * 
 *
 */
public class Player extends Entity {

    private Point2D lastDirection;
    private List<GameObject> backPack;
    private boolean idle;

    public Player(final Point2D position, final GraphicComponent graphic, final InputComponent input) {
        super(position, true, graphic, input);
        this.lastDirection = new Point2D();
        this.backPack = new ArrayList<>();
        this.idle = false;
    }
    
    @Override
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
    }

    @Override
    public void updateInput(final InputController i) {
        this.input.update(this, i);
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
    

    

}
