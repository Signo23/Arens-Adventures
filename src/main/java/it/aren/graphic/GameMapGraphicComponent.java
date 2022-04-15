package it.aren.graphic;

import it.aren.model.Entity;
import it.aren.model.GameMap;
/**
 * Graphic for {@link GameMap}.
 * Implements {@link GraphicComponent}
 */
public class GameMapGraphicComponent implements GraphicComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final Entity ent, final GraphicController w) {
        w.drawGameMap((GameMap)ent);
    }

}
