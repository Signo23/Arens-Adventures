package it.aren.model.game;

import it.aren.common.BaseObjectEnum;
import it.aren.model.*;

/**
 * Model for game object.
 * Extends {@link GameEntity}
 *
 */
public class GameObject extends GameEntity {

    private final BaseObjectEnum type;
    /**
     * Create a GameObject.
     * @param type {@link BaseObjectEnum} type of GameObject
     * @param position the {@link Vector2D} where to draw the GameObject
     * @param drawable if GameObject is drawable
     * @param graphic GameObject's {@link GraphicComponent}
     */
    public GameObject(final BaseObjectEnum type, final Vector position, final boolean drawable,
                      final Component graphic) {
        super(position, drawable);
        this.type = type;
        this.addComponent(GameComponent.GRAPHIC, graphic);
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
