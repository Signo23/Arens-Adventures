/**
 * 
 */
package it.aren.core;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Constant;
import it.aren.common.Point2D;
import it.aren.input.DialogInputComponent;
import it.aren.event.InteractWithPlayerEvent;
import it.aren.input.PlayerInputComponent;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.GameObject;
import it.aren.model.Player;
import it.aren.physics.PlayerPhysicsComponent;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.DialogGraphicComponent;
import it.aren.graphic.PlayerGraphicComponent;
import it.aren.graphic.Texture;
import it.aren.graphic.View;
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
    public static GameMap loadMaps(final View view) {
        final List<Block> z = new ArrayList<>();
        z.add( new Block(new InteractWithPlayerEvent(view, new GameObject(new Point2D(12*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), true,
                new BlockGraphicComponent(), null, null), "Ciaoo"),
                new Point2D(4*Constant.DEFAULT_HITBOX_DIMENSION, 5*Constant.DEFAULT_HITBOX_DIMENSION), true, new BlockGraphicComponent()));
        
        z.add( new Block(new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 0*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 2*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        
        z.add( new Block(new Point2D(9*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(10*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(11*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(12*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(13*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(14*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));
        z.add( new Block(new Point2D(15*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION), false, new BlockGraphicComponent()));

        final GameMap map = new GameMap();
        map.setBlocks(z);
        return map;
    }
    //Da modificare
    public static Dialog createDialog() {
        return new Dialog(Constant.DEFAULT_DIALOG_POSITION, true, new DialogGraphicComponent(), new DialogInputComponent(), Constant.DEFAULT_DIALOG_SIZE, "prova");
    }
}
