/**
 * 
 */
package it.aren.model;

import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.input.InputComponent;
import it.aren.input.InputController;

/**
 * 
 *
 */
public class GameObject extends Entity {

    private String id;

    public GameObject(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final String id) {
        super(position, drawable, graphic, input);
        this.id = id;
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
