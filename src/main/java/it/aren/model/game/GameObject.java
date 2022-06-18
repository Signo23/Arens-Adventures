package it.aren.model.game;

import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.graphic.GraphicComponent;
import it.aren.model.BaseEntity;

/**
 * Model for game object.
 * Extends {@link BaseEntity} 
 *
 */
public class GameObject extends BaseEntity {

    private final BaseObjectEnum type;
    /**
     * Create a GameObject.
     * @param type GemObject's type
     * @param position where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     * @param ratio ratio for hitBox

     */
    public GameObject(final BaseObjectEnum type, final Point2D position, final boolean drawable, final GraphicComponent graphic) {
        super(position, drawable, graphic);
        this.type = type;
    }

    /**
     * Get GameObject's type.
     * @return the type
     */
    public final BaseObjectEnum getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "GameObject [type=" + this.type + "]";
    }


}
