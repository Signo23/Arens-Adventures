package it.aren.graphic;

import it.aren.model.Dialog;
import it.aren.model.Entity;

public class DialogGraphicComponent implements GraphicComponent {

    @Override
    public final void update(final Entity ent, final GraphicController w) {
        w.drawDialog((Dialog) ent);
    }

}
