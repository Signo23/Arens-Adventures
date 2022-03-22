/**
 * 
 */
package it.aren.model;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Point2D;

/**
 * 
 *
 */
public class Player extends Entity {

    private Point2D lastDirection;
    private List<GameObject> backPack;

    public Player(final Point2D position) {
        super(position, true);
        this.lastDirection = new Point2D();
        this.backPack = new ArrayList<>();
    }
    
    @Override
    public void updateGraphic() {
        // TODO when graphic is implemented
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
