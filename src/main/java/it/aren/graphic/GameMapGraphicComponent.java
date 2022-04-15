package it.aren.graphic;

import it.aren.model.Entity;
import it.aren.model.GameMap;

public class GameMapGraphicComponent implements GraphicComponent {

    @Override
    public void update(final Entity ent, final GraphicController w) {
        w.drawGameMap((GameMap)ent);
    }

}
