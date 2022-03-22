/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;

/**
 * 
 *
 */
public class GameObject extends Entity {

    private String id;

    public GameObject(final Point2D position, final boolean drawable, final String id) {
        super(position, drawable);
        this.id = id;
    }

    @Override
    public void updateGraphic() {
        // TODO when graphic is implemented
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GameObject [id=" + id + "]";
    }

}
