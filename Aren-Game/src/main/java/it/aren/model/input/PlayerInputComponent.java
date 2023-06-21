package it.aren.model.input;

import it.aren.Direction;
import it.aren.Entity;
import it.aren.Controller;
import it.aren.geom.Vector2D;
import it.aren.model.GameComponent;
import it.aren.model.game.Player;

/**
 * The input component for the {@link Player}.
 * Implements {@link GameComponent}
 */
public class PlayerInputComponent extends GameComponent {

    @Override
    public <T, C extends Controller<T, K>, K> void update(Entity entity, C controller, K value) {
        if(controller instanceof InputController) {
            InputController c = (InputController)controller;
            Vector2D newDirection = new Vector2D(0,0);

            if(c.getAction(InputController.UP)){
                newDirection.sum(Direction.UP.getVector());
            }
            if(c.getAction(InputController.DOWN)) {
                newDirection.sum(Direction.DOWN.getVector());
            }
            if(c.getAction(InputController.LEFT)) {
                newDirection.sum(Direction.LEFT.getVector());
            }
            if(c.getAction(InputController.RIGHT)) {
                newDirection.sum(Direction.RIGHT.getVector());
            }
            if(c.getAction(InputController.NO_ACTION)) {
                newDirection = (Vector2D) Direction.NO_DIRECTION.getVector();
            }
            entity.setVelocity(newDirection);
            if(!newDirection.equals(Direction.NO_DIRECTION.getVector())){
                ((Player) entity).setLastDirection(newDirection);
            }
        }
    }
}
