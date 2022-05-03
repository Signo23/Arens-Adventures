package it.aren.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import it.aren.common.Constant;
import it.aren.core.GameFactory;
import it.aren.model.GameMap;
import it.aren.model.World;

public class Input {

    @Test void testGiveToPlayerInput() {
        final World world = new World();
        final GameMap gameMap = new GameMap(16, 16, new ArrayList<>());
        final KeyboardInputController ctrl = new KeyboardInputController();
        world.setPlayer(GameFactory.createPlayer());
        world.addMap(gameMap);
        world.setCurrentMap(0);

        ctrl.notifyMoveUp();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Constant.UP);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveUp();

        ctrl.notifyMoveDown();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Constant.DOWN);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveDown();

        ctrl.notifyMoveLeft();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Constant.LEFT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveLeft();

        ctrl.notifyMoveRight();
        world.getPlayer().updateInput(ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Constant.RIGHT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.notifyNoMoreMoveRight();

        world.getPlayer().updateInput(ctrl);
        assertTrue(world.getPlayer().isIdle());

    }
}
