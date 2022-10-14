package it.aren.model.physics;

import it.aren.*;
import it.aren.common.Constant;
import it.aren.core.GameFactory;
import it.aren.geom.Vector2D;
import it.aren.model.game.Player;

/**
 * The physics component for {@link Player}.
 * Implements {@link PhysicsComponent}
 */
public class PlayerPhysicsComponent implements Command {

    private final int velocity;

    public PlayerPhysicsComponent() {
        this.velocity = GameFactory.loadSettings().scale() * Constant.DEFAULT_VEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, C extends Controller<T>> void update(Entity entity, C controller) {
        final Player pl = (Player) entity;
        if (!pl.getVelocity().equals(Direction.NO_DIRECTION)) {
            final Direction pos = pl.getLastDirection();
            final Vector currentPos = pl.getPosition();
            switch (pos) {
                case LEFT:
                    pl.setPosition(new Vector2D(currentPos.getX() - velocity, currentPos.getY()));
                    break;
                case RIGHT:
                    pl.setPosition(new Vector2D(currentPos.getX() + velocity, currentPos.getY()));
                    break;
                case UP:
                    pl.setPosition(new Vector2D(currentPos.getX(), currentPos.getY() - velocity));
                    break;
                case DOWN:
                    pl.setPosition(new Vector2D(currentPos.getX(), currentPos.getY() + velocity));
                    break;
                default:
                    break;
            }
        }
    }
}