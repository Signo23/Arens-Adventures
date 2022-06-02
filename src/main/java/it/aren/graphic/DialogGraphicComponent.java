package it.aren.graphic;

import it.aren.model.Dialog;
import it.aren.model.BaseEntity;

public class DialogGraphicComponent implements GraphicComponent {

    @Override
    public final void update(final BaseEntity ent, final GraphicController w) {
        w.drawDialog((Dialog) ent);
    }

}
