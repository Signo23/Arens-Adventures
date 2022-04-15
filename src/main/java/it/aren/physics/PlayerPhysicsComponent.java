/**
 * 
 */
package it.aren.physics;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.model.Entity;
import it.aren.model.Player;

/**
 * The physics component for {@link Player}.
 * Implements {@link PhysicsComponent}
 */
public class PlayerPhysicsComponent implements PhysicsComponent {
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void update(final Entity player) {
        final Player pl = (Player)player;
        if(!pl.isIdle()) {
            final Point2D pos = pl.getLastDirection();
            final Point2D currentPos = pl.getPosition();
            if(pos.equals(Constant.LEFT)) {
                pl.setPosition(new Point2D(currentPos.getX() - Constant.DEFAULT_VEL, currentPos.getY()));
            }
            if(pos.equals(Constant.RIGHT)) {
                pl.setPosition(new Point2D(currentPos.getX() + Constant.DEFAULT_VEL, currentPos.getY()));
            }
            if(pos.equals(Constant.UP)) {
                pl.setPosition(new Point2D(currentPos.getX(), currentPos.getY() - Constant.DEFAULT_VEL));
            }
            if(pos.equals(Constant.DOWN)) {
                pl.setPosition(new Point2D(currentPos.getX(), currentPos.getY() + Constant.DEFAULT_VEL));
            }
        }
    }
}
