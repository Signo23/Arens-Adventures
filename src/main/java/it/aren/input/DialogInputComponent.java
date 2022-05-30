package it.aren.input;

import it.aren.model.Dialog;
import it.aren.model.Entity;

public class DialogInputComponent implements InputComponent {

    @Override
    public final void update(final Entity entity, final InputController controller) {
        if (controller.isInteract())  {
            ((Dialog) entity).setScroll(true);
        } else if (controller.isOnClose()) {
            ((Dialog) entity).setScroll(false);
        }
    }
}
