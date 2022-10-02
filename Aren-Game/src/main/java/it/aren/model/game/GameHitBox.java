package it.aren.model.game;

import it.aren.geom.Vector2D;
import it.aren.HitBox;
import it.aren.Vector;

public class GameHitBox implements HitBox {

    private Vector position;
    private Vector dimension;

    public GameHitBox (final Vector position, final Vector dimension){
        this.dimension = dimension;
        this.position = position;
    }

    public GameHitBox(final float x, final float y, final float width, final float height){
        this(new Vector2D(x, y), new Vector2D(width, height));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isColliding(HitBox hb) {
        float thisWidth = this.dimension.getX();
        float thisHeight = this.dimension.getY();
        float rw = hb.dimension().getX();
        float rh = hb.dimension().getY();
        if (rw <= 0 || rh <= 0 || thisWidth <= 0 || thisHeight <= 0) {
            return false;
        }
        float tx = this.position.getX();
        float ty = this.position.getY();
        float rx = hb.position().getX();
        float ry = hb.position().getY();
        rw += rx;
        rh += ry;
        thisWidth += tx;
        thisHeight += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (thisWidth < tx || thisWidth > rx) &&
                (thisHeight < ty || thisHeight > ry));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector position() {
        return this.position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector dimension() {
        return this.dimension;
    }

    @Override
    public HitBox clone() {
        return new GameHitBox(this.position.getX(), this.position.getY(), this.dimension.getX(), this.dimension.getY());
    }
}
