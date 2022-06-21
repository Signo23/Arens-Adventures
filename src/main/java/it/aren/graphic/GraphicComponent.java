package it.aren.graphic;

import it.aren.model.BaseEntity;

/**
 * A component for graphic.
 *
 */
public interface GraphicComponent {

    /**
     * Draw the {@link BaseEntity}'s graphic state.
     * @param ent {@link BaseEntity} to draw
     * @param w {@link GraphicController} for draw
     */
    void update(BaseEntity ent, GraphicController w);
}
