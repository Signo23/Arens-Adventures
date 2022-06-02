/**
 * 
 */
package it.aren.model;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.input.InputComponent;

/**
 * Model for game object.
 * Extends {@link BaseEntity} 
 *
 */
public class GameObject extends BaseEntity {

    private String id;
    
    /**
     * Create a GameObject.
     * @param id GemObject's identifier
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     */
    public GameObject(final String id, final Point2D position, final boolean drawable, final GraphicComponent graphic){
        this(id, position, drawable, graphic, Constant.DEFAULT_RATIO);
    }
    
    /**
     * Create a GameObject.
     * @param id GemObject's identifier
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param ratio ratio for hitBox

     */
    public GameObject(final String id, final Point2D position, final boolean drawable, final GraphicComponent graphic, final int ratio){
        super(position, drawable, graphic, ratio);
        this.id = id;
    }

    @Deprecated
    /**
     * @deprecated
     * Create a GameObject.
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param input GameObject's {@link InputComponent}
     * @param id GemObject's identifier
     */
    public GameObject(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final String id) {
        this(id, position, drawable, graphic);
    }
    
    @Deprecated
    /**
     * @deprecated
     * Create a GameObject.
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param input GameObject's {@link InputComponent}
     * @param id GemObject's identifier
     * @param hitboxDimension dimension of hibox
     */
    public GameObject(final Point2D position, final boolean drawable, final GraphicComponent graphic, final InputComponent input, final String id,
            final int hitboxDimension) {
        this(id, position, drawable, graphic, hitboxDimension);
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
