package it.aren.input;

import it.aren.common.Point2D;
import it.aren.model.Player;

public class PlayerInputComponent implements InputComponent {

    public final void update(final Player player, final InputController controller) {
        if (controller.isMoveUp()) {
            //Aren si muove verso l'alto
            player.setLastDirection(new Point2D(0, 1));
        } else if (controller.isMoveDown()) {
            //Aren si muove verso il basso
            player.setLastDirection(new Point2D(0, -1));
        } else if (controller.isMoveLeft()) {
            //Aren si muove verso snistra
            player.setLastDirection(new Point2D(-1, 0));
        } else if (controller.isMoveRight()) {
            //Aren si muove verso destra
            player.setLastDirection(new Point2D(1, 0));
        }
    }

}
