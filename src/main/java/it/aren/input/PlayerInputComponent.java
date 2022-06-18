/**
 * 
 */
package it.aren.input;

import it.aren.model.BaseEntity;
import it.aren.model.game.Player;
import it.aren.common.Direction;
/**
 * The input component for the player.
 * Implements {@link InputComponent}
 */
public class PlayerInputComponent implements InputComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public final void update(final BaseEntity entity, final InputController controller) {
        if (controller.isMoveUp()) {
            //Aren si muove verso l'alto
            ((Player) entity).setLastDirection(Direction.UP);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveDown()) {
            //Aren si muove verso il basso
            ((Player) entity).setLastDirection(Direction.DOWN);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveLeft()) {
            //Aren si muove verso snistra
            ((Player) entity).setLastDirection(Direction.LEFT);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveRight()) {
            //Aren si muove verso destra
            ((Player) entity).setLastDirection(Direction.RIGHT);
            ((Player) entity).setIdle(false);
        } else {
            //Aren sta oziando
            ((Player) entity).setIdle(true);
        }
    }

}
