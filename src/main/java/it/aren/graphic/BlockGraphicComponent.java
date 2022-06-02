/**
 * 
 */
package it.aren.graphic;

import it.aren.model.Block;
import it.aren.model.BaseEntity;

/**
 * Graphic for {@link Block}.
 * Implements {@link GraphicComponent}
 */
public class BlockGraphicComponent implements GraphicComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final BaseEntity ent, final GraphicController w) {
        w.drawBlock((Block)ent);

    }

}
