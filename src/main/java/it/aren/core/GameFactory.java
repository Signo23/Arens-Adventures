/**
 * 
 */
package it.aren.core;

import java.util.Arrays;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.input.DialogInputComponent;
import it.aren.input.PlayerInputComponent;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.Player;
import it.aren.physics.PlayerPhysicsComponent;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.DialogGraphicComponent;
import it.aren.graphic.PlayerGraphicComponent;
import it.aren.graphic.Texture;
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
    public static Player createPlayer(final Texture texture) {
        return new Player(new Point2D(0, 1),
                new PlayerGraphicComponent(texture),
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
    //Da modificare
    public static Dialog createDialog() {
        return new Dialog(Constant.DEFAULT_DIALOG_POSITION, true, new DialogGraphicComponent(), new DialogInputComponent(), Constant.DEFAULT_DIALOG_SIZE, "prova");
    }
}
