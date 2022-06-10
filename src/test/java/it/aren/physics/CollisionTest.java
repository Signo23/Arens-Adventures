package it.aren.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import it.aren.common.Direction;
import it.aren.common.Point2D;
import it.aren.core.GameFactory;
import it.aren.graphic.Texture;
import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.World;

class CollisionTest {
    @Test void testPlayerCollision() {
        final World world = new World();
        final Block block = new Block(new Point2D(33, 33),false, null);
        final GameMap gameMap = new GameMap(16, 16, new ArrayList<>());
        
        gameMap.getBlocks().add(block);
        world.setPlayer(GameFactory.createPlayer(new Texture()));
        world.addMap(gameMap);
        world.setCurrentMap(0);
        
        world.getPlayer().setIdle(false);
        world.getPlayer().setLastDirection(Direction.DOWN);
        world.getPlayer().setPosition(new Point2D(32, 0));
        world.updateState();
        
        System.out.println(world.getPlayer().getPosition());
        assertEquals(world.getPlayer().getPosition(), new Point2D(32, 0));
        world.updateState();
        
        System.out.println(world.getPlayer().getPosition());
        assertEquals(world.getPlayer().getPosition(), new Point2D(32, 0));
        
        world.getPlayer().setLastDirection(Direction.LEFT);
        world.updateState();
        
        System.out.println(world.getPlayer().getPosition());
        assertNotEquals(world.getPlayer().getPosition().getX(), 32);
        
        world.getPlayer().setLastDirection(Direction.DOWN);
        world.updateState();
        
        System.out.println(world.getPlayer().getPosition());
        assertEquals(world.getPlayer().getPosition().getY(), 0);
    }
}