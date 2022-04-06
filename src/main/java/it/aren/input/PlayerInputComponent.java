package it.aren.input;

import it.aren.model.Entity;
import it.aren.model.Player;
import it.aren.common.Constant;

public class PlayerInputComponent implements InputComponent {

    public final void update(final Entity entity, final InputController controller) {
        if (controller.isMoveUp()) {
            //Aren si muove verso l'alto
            ((Player) entity).setLastDirection(Constant.UP);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveDown()) {
            //Aren si muove verso il basso
            ((Player) entity).setLastDirection(Constant.DOWN);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveLeft()) {
            //Aren si muove verso snistra
            ((Player) entity).setLastDirection(Constant.LEFT);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveRight()) {
            //Aren si muove verso destra
            ((Player) entity).setLastDirection(Constant.RIGHT);
            ((Player) entity).setIdle(false);
        } else {
            //Aren sta oziando
            ((Player) entity).setIdle(true);
        }
    }

}
