/**
 * 
 */
package it.aren.core;

import java.util.Arrays;

import it.aren.common.Point2D;
import it.aren.input.PlayerInputComponent;
import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.Player;
import it.aren.physics.PlayerPhysicsComponent;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.PlayerGraphicComponent;
/**
 * The main factory.
 */
public final class GameFactory {

    /**
     * The GameFactory constructor.
     */
    private GameFactory() {

    }
    /**
     * Creates a new player.
     * @return player
     */
    public static Player createPlayer() {
        return new Player(new Point2D(0, 1),
                new PlayerGraphicComponent(),
                new PlayerInputComponent(),
                new PlayerPhysicsComponent());
    }
    /**
     * Loads the game maps.
     * @return GameMap
     */
    public static GameMap loadMaps() {
        final Block blk = new Block(new Point2D(130,150), true, new BlockGraphicComponent(), null);
        final GameMap map = new GameMap();
        map.setBlocks(Arrays.asList(blk));
        return map;
    }
}
