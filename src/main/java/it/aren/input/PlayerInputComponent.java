package it.aren.input;

import it.aren.common.Point2D;
import it.aren.model.Entity;
import it.aren.model.Player;

public class PlayerInputComponent implements InputComponent {

    public final void update(final Entity entity, final InputController controller) {
        if (controller.isMoveUp()) {
            //Aren si muove verso l'alto
            ((Player) entity).setLastDirection(new Point2D(0, 1));
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveDown()) {
            //Aren si muove verso il basso
            ((Player) entity).setLastDirection(new Point2D(0, -1));
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveLeft()) {
            //Aren si muove verso snistra
            ((Player) entity).setLastDirection(new Point2D(-1, 0));
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveRight()) {
            //Aren si muove verso destra
            ((Player) entity).setLastDirection(new Point2D(1, 0));
            ((Player) entity).setIdle(false);
        } else {
            //Aren sta oziando
            ((Player) entity).setIdle(true);
        }
    }

}
