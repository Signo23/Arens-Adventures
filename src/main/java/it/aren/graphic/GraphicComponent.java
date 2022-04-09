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

    void update( Entity ent, GraphicController w);
}
