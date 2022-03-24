package it.aren.input;

import it.aren.common.Point2D;
import it.aren.model.*;

public class PlayerInputComponent implements InputComponent {

    public final void update(final Entity entity, final InputController controller) {
        if (controller.isMoveUp()) {
            //Aren si muove verso l'alto
            entity.setLastDirection(new Point2D(0, 1));
        } else if (controller.isMoveDown()) {
            //Aren si muove verso il basso
            entity.setLastDirection(new Point2D(0, -1));
        } else if (controller.isMoveLeft()) {
            //Aren si muove verso snistra
            entity.setLastDirection(new Point2D(-1, 0));
        } else if (controller.isMoveRight()) {
            //Aren si muove verso destra
            entity.setLastDirection(new Point2D(1, 0));
        }
    }

}
