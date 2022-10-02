package it.aren.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import it.aren.common.Direction;
import it.aren.core.GameFactory;
import it.aren.model.World;

public class Input {

    @Test void testGiveToPlayerInput() {
        final World world = new World();
        final KeyboardInputController ctrl = new KeyboardInputController();
        world.setPlayer(GameFactory.createPlayer());
        world.addMaps(GameFactory.loadMaps());
        world.setCurrentMap(0);

        ctrl.update(InputController.UP);
        world.getPlayer().update("input",ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.UP);
        assertFalse(world.getPlayer().isIdle());
        ctrl.update(InputController.NO_ACTION);

        ctrl.update(InputController.DOWN);
        System.out.println(world.getPlayer());
        world.getPlayer().update("input",ctrl);
        System.out.println(world.getPlayer());
        assertEquals(world.getPlayer().getLastDirection(), Direction.DOWN);
        assertFalse(world.getPlayer().isIdle());
        ctrl.update(InputController.NO_ACTION);

        ctrl.update(InputController.LEFT);
        world.getPlayer().update("input",ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.LEFT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.update(InputController.NO_ACTION);

        ctrl.update(InputController.RIGHT);
        world.getPlayer().update("input",ctrl);
        assertEquals(world.getPlayer().getLastDirection(), Direction.RIGHT);
        assertFalse(world.getPlayer().isIdle());
        ctrl.update(InputController.NO_ACTION);

        world.getPlayer().update("input",ctrl);
        assertTrue(world.getPlayer().isIdle());

    }
}
