package it.aren.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.aren.common.Direction;
import it.aren.core.GameFactory;
import it.aren.model.World;
import it.aren.model.game.GameMap;

public class Input {

    @Test void testGiveToPlayerInput() {
        final World world = new World();
        final KeyboardInputController ctrl = new KeyboardInputController();
        world.setPlayer(GameFactory.createPlayer());
        world.addMaps(GameFactory.loadMaps());
        world.setCurrentMap(0);

        ctrl.notifyMoveUp();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.UP);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveUp();

        ctrl.notifyMoveDown();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.DOWN);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveDown();

        ctrl.notifyMoveLeft();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.LEFT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveLeft();

        ctrl.notifyMoveRight();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.RIGHT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveRight();

        world.getPlayer().updateInput(ctrl);
        assertTrue(world.getPlayer().isIdle());

    }
}
