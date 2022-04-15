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
 * Model for game object.
 * Extends {@link Entity} 
 *
 */
public class GameObject extends Entity {

    private String id;

    /**
     * Create a GameObject.
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param input GameObject's {@link InputComponent}
     * @param id GemObject's identifier
     */
    public GameObject(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final String id) {
        super(position, drawable, graphic, input);
        this.id = id;
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
     * Get GameObeject's ID.
     * @return the id
     */
    public String getId() {
        return this.id;
    }
    /**
     * Set GameObeject's ID.
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public String toString() {
        return "GameObject [id=" + this.id + "]";
    }


}
