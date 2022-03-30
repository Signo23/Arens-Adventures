/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicController;
import it.aren.graphic.PlayerGraphicComponent;

/**
 * 
 *
 */
public class Player extends Entity {

    private Point2D lastDirection;
    private List<GameObject> backPack;

    public Player(final Point2D position, final PlayerGraphicComponent g) {
        super(position, true, g);
        this.lastDirection = new Point2D();
        this.backPack = new ArrayList<>();
    }
    
    @Override
    public void updateGraphic(final GraphicController g) {
        this.graphic.update(this, g);
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
    

}
