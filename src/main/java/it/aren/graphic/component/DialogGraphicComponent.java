package it.aren.graphic.component;

import it.aren.model.Dialog;
import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.model.BaseEntity;
/**
 * Graphic for {@link Dialog}.
 * Implements {@link GraphicComponent}
 */
public class DialogGraphicComponent implements GraphicComponent {

    /**
     * {@inheritDoc}
     */
    @Override
    public final void update(final BaseEntity ent, final GraphicController w) {
        w.drawDialog((Dialog) ent);
    }

}
