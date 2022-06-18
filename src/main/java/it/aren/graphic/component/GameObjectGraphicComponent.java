package it.aren.graphic.component;

import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.model.BaseEntity;
import it.aren.model.GameObject;
/**
 * Graphic for {@link GameObject}.
 * Implements {@link GraphicComponent}
 */
public class GameObjectGraphicComponent implements GraphicComponent {

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final BaseEntity ent, final GraphicController w) {
        w.drawObject((GameObject) ent);
    }

}
