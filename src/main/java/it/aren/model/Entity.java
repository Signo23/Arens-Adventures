/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;

public abstract class Entity {
    private Point2D position;
    private boolean drawable;
    //private GraphicComponent graphic;
    /**
     * @param position
     * @param drawble
     */
    public Entity(final Point2D position, final boolean drawable) {
        super();
        this.position = position;
        this.drawable = drawable;
    }
    /**
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }
    /**
     * @param position the position to set
     */
    public void setPosition(final Point2D position) {
        this.position = position;
    }
    /**
     * @return the drawable
     */
    public boolean isDrawble() {
        return drawable;
    }
    /**
     * @param drawble the drawable to set
     */
    public void setDrawble(final boolean drawable) {
        this.drawable = drawable;
    }
    
    public abstract void updateGraphic();
    
    

    
}
