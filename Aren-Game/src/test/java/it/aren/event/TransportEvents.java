package it.aren.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.aren.common.Settings;
import it.aren.core.GameFactory;
import org.junit.jupiter.api.Test;

import it.aren.common.BaseLevelEnum;
import it.aren.common.Constant;
import it.aren.geom.Vector2D;
import it.aren.file.SettingsLoader;
import it.aren.model.GameState;

public class TransportEvents {

    @Test void changeGameMap() {
        final int ratio = GameFactory.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;
        final GameState gs = new GameState(null);
        final BaseEvent te = new TransportEvent(new Vector2D(1 * dimension, 6 * dimension), 1);

        te.launch(gs);
        assertEquals(gs.getWorld().getCurrentMap().getType(), BaseLevelEnum.TWO);
        assertEquals(gs.getWorld().getPlayer().getPosition(), new Vector2D(1 * dimension, 6 * dimension));
    }
}
