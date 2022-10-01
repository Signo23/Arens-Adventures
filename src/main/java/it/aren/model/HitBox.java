package it.aren.model;

import it.aren.common.Vector;
import it.aren.common.Vector2D;

public interface HitBox {
    /**
     * Determines whether or not this {@code HitBox} and the specified
     * {@code HitBox} collide. Two hitboxes collide if
     * their intersection is nonempty.
     * @param hb the specified {@code HitBox}
     * @return {@code true} if the specified {@code HitBox}
     *      and this {@code HitBox} collide;
     *      {@code false} otherwise.
     */
    boolean isColliding(HitBox hb);

    /**
     * Determinate the position of the hit box.
     * @return a {@link Vector} containg the position
     */
    Vector position();

    /**
     * Determinate the dimension of the hit box.
     * @return a {@link Vector} containing the dimension
     */
    Vector dimension();

    HitBox clone();
}
