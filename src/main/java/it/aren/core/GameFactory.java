/**
 * 
 */
package it.aren.core;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.Constant;
import it.aren.common.ObjectType;
import it.aren.common.Point2D;
import it.aren.event.InteractWithPlayerEvent;
import it.aren.event.NullEvent;
import it.aren.input.PlayerInputComponent;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.GameObject;
import it.aren.model.Player;
import it.aren.physics.PlayerPhysicsComponent;
import it.aren.graphic.BlockGraphicComponent;
import it.aren.graphic.DialogGraphicComponent;
import it.aren.graphic.GameObjectGraphicComponent;
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
    public static GameMap loadMaps() {
        final List<Block> z = new ArrayList<>();
        final GameObject potion = new GameObject(ObjectType.POTION, new Point2D(11*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), true,
                new GameObjectGraphicComponent());
        final GameObject sword = new GameObject(ObjectType.SWORD, new Point2D(12*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), true,
                new GameObjectGraphicComponent());
        final GameObject jacket = new GameObject(ObjectType.JACKET, new Point2D(13*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), true,
                new GameObjectGraphicComponent());
        final GameObject key = new GameObject(ObjectType.KEY, new Point2D(14*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION), true,
                new GameObjectGraphicComponent());

        final Block box = new Block(ObjectType.BOX, new InteractWithPlayerEvent(potion, "Ecco la pozione!"),
                new Point2D(6*Constant.DEFAULT_HITBOX_DIMENSION, 5*Constant.DEFAULT_HITBOX_DIMENSION), true, new BlockGraphicComponent());
        final Block chest = new Block(ObjectType.CHEST, new InteractWithPlayerEvent(sword, "Ecco la spada!", potion, "Prima la pozione!"),
                new Point2D(4*Constant.DEFAULT_HITBOX_DIMENSION, 5*Constant.DEFAULT_HITBOX_DIMENSION), true, new BlockGraphicComponent());
        final Block npc = new Block(ObjectType.NPC, new InteractWithPlayerEvent(jacket, "Ecco la giacca!", sword, "Prima la spada!"),
                new Point2D(9*Constant.DEFAULT_HITBOX_DIMENSION, 5*Constant.DEFAULT_HITBOX_DIMENSION), true, new BlockGraphicComponent());
        final Block sign = new Block(ObjectType.SIGN, new InteractWithPlayerEvent(key, "Ecco la chiave!", jacket, "Prima la giacca!"),
                new Point2D(11*Constant.DEFAULT_HITBOX_DIMENSION, 5*Constant.DEFAULT_HITBOX_DIMENSION), true, new BlockGraphicComponent());

        z.add(box);
        z.add(chest);
        z.add(npc);
        z.add(sign);

        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 0*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 1*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*Constant.DEFAULT_HITBOX_DIMENSION, 2*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));

        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(9*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(10*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(11*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(12*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(13*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(14*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(15*Constant.DEFAULT_HITBOX_DIMENSION, 3*Constant.DEFAULT_HITBOX_DIMENSION),
                false, new BlockGraphicComponent()));

        final GameMap map = new GameMap();
        map.setBlocks(z);
        return map;
    }

    public static Dialog createDialog(final String text) {
        return new Dialog(Constant.DEFAULT_DIALOG_POSITION, true, new DialogGraphicComponent(), Constant.DEFAULT_DIALOG_SIZE, text);
    }
}
