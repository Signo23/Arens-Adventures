/**
 * 
 */
package it.aren.model;

import it.aren.common.Constant;
import it.aren.common.ObjectType;
import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.input.InputComponent;

/**
 * Model for game object.
 * Extends {@link BaseEntity} 
 *
 */
public class GameObject extends BaseEntity {

    @Deprecated
    private String id;
    private final ObjectType type;
    
    /**
     * Create a GameObject.
     * @param type GemObject's type
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     */
    public GameObject(final ObjectType type, final Point2D position, final boolean drawable, final GraphicComponent graphic){
        this(type, position, drawable, graphic, Constant.DEFAULT_RATIO);
    }
    
    /**
     * Create a GameObject.
     * @param type GemObject's type
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param ratio ratio for hitBox

     */
    public GameObject(final ObjectType type, final Point2D position, final boolean drawable, final GraphicComponent graphic, final int ratio){
        super(position, drawable, graphic, ratio);
        this.type = type;
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
        this(ObjectType.VOID, position, drawable, graphic);
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
        this(ObjectType.VOID, position, drawable, graphic, hitboxDimension);
    }

    @Deprecated
    /**
     * @deprecated
     * Get GameObeject's ID.
     * @return the id
     */
    public String getId() {
        return this.id;
    }
    @Deprecated
    /**
     * @deprecated
     * Set GameObeject's ID.
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Get GameObject's type.
     * @return the type
     */
    public final ObjectType getType() {
        return type;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public String toString() {
        return "GameObject [type=" + this.type+ "]";
    }


}
