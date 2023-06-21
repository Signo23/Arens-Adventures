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
    public <T, C extends Controller<T, K>, K> void update(Entity entity, C controller, K value) {
        final Player pl = (Player) entity;
        if (!pl.getVelocity().equals(Direction.NO_DIRECTION.getVector())) {
            final Vector currentPos = pl.getPosition();
            pl.setPosition(currentPos.sum(pl.getLastDirection().mul(velocity)));
        }
    }
}