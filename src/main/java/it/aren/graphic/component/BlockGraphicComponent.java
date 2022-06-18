package it.aren.graphic.component;

import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.model.BaseEntity;
import it.aren.model.game.Block;

/**
 * Graphic for {@link Block}.
 * Implements {@link GraphicComponent}
 */
public class BlockGraphicComponent implements GraphicComponent {


    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final BaseEntity ent, final GraphicController w) {
        w.drawBlock((Block) ent);

    }

}
