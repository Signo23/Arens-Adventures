/**
 * 
 */
package it.aren.input;

import it.aren.model.BaseEntity;
import it.aren.model.game.Player;
import it.aren.common.Direction;
/**
 * The input component for the {@link Player}.
 * Implements {@link InputComponent}
 */
public class PlayerInputComponent implements InputComponent {

    @Override
    /**
     * {@inheritDoc}
     */
    public final void update(final BaseEntity entity, final InputController controller) {
        if (controller.isMoveUp()) {
            ((Player) entity).setLastDirection(Direction.UP);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveDown()) {
            ((Player) entity).setLastDirection(Direction.DOWN);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveLeft()) {
            ((Player) entity).setLastDirection(Direction.LEFT);
            ((Player) entity).setIdle(false);
        } else if (controller.isMoveRight()) {
            ((Player) entity).setLastDirection(Direction.RIGHT);
            ((Player) entity).setIdle(false);
        } else {
            ((Player) entity).setIdle(true);
        }
    }

}
