package it.aren.input;

import it.aren.model.Dialog;
import it.aren.model.BaseEntity;

public class DialogInputComponent implements InputComponent {

    @Override
    public final void update(final BaseEntity entity, final InputController controller) {
        if (controller.isInteract())  {
            ((Dialog) entity).setScroll(true);
        } else if (controller.isOnClose()) {
            ((Dialog) entity).setScroll(false);
        }
    }
}
