package it.aren.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.core.GameFactory;
import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.World;

class CollisionTest {
    @Test void testPlayerCollision() {
        final World w = new World();
        final Block blk = new Block(new Point2D(33, 33),false, null, null);
        final GameMap gm = new GameMap(16, 16, new ArrayList<>());
        
        gm.getBlocks().add(blk);
        w.setPlayer(GameFactory.createPlayer());
        w.addMap(gm);
        w.setCurrentMap(0);
        
        w.getPlayer().setIdle(false);
        w.getPlayer().setLastDirection(Constant.DOWN);
        w.getPlayer().setPosition(new Point2D(32, 0));
        w.updateState();
        
        System.out.println(w.getPlayer().getPosition());
        assertEquals(w.getPlayer().getPosition(), new Point2D(32, 0));
        w.updateState();
        
        System.out.println(w.getPlayer().getPosition());
        assertEquals(w.getPlayer().getPosition(), new Point2D(32, 0));
        
        w.getPlayer().setLastDirection(Constant.LEFT);
        w.updateState();
        
        System.out.println(w.getPlayer().getPosition());
        assertNotEquals(w.getPlayer().getPosition().getX(), 32);
        
        w.getPlayer().setLastDirection(Constant.DOWN);
        w.updateState();
        
        System.out.println(w.getPlayer().getPosition());
        assertEquals(w.getPlayer().getPosition().getY(), 0);
    }
}
