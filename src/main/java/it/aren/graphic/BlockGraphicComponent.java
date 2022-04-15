/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Block;
import it.aren.model.Entity;

/**
 * Graphic for {@link Block}
 *
 */
public class BlockGraphicComponent implements GraphicComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final Entity ent, final GraphicController w) {
        w.drawBlock((Block)ent);

    }

}
