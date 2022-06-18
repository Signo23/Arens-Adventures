package it.aren.event;

import it.aren.common.Point2D;
import it.aren.model.GameState;

public class TransportEvent implements Event {

    private final Point2D position;
    private final int level;

    public TransportEvent(final Point2D position, final int level) {
        this.position = position;
        this.level = level;
    }

    @Override
    public final void launch(final GameState state) {
        state.getWorld().setCurrentMap(this.level);
        state.getWorld().getPlayer().setPosition(position);
    }

    @Override
    public final boolean isAlreadyLunch() {
        return true;
    }

}
