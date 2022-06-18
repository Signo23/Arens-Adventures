package it.aren.graphic.component;

import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.model.BaseEntity;
import it.aren.model.GameObject;

public class GameObjectGraphicComponent implements GraphicComponent {

    @Override
    public void update(final BaseEntity ent, final GraphicController w) {
        w.drawObject((GameObject)ent);
    }

}
