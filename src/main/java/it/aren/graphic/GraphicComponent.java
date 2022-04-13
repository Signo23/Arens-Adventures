/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Entity;

/**
 * A component for graphic.
 *
 */
public interface GraphicComponent {

    /**
     * Draw the {@link Entity}'s graphic state.
     * @param ent {@link Entity} to draw
     * @param w {@link GraphicController} for draw
     */
    void update( Entity ent, GraphicController w);
}
