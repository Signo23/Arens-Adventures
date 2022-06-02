package it.aren.graphic;

import it.aren.model.BaseEntity;
import it.aren.model.GameObject;

public class GameObjectGraphicComponent implements GraphicComponent {

    @Override
    public void update(final BaseEntity ent, final GraphicController w) {
        w.drawObject((GameObject)ent);
    }

}
