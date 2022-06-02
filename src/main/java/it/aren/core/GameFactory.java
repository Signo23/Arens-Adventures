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
import it.aren.file.SettingsLoader;
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
                new PlayerPhysicsComponent(),
                SettingsLoader.loadSettings().scale());
    }
    /**
     * Loads the game maps.
     * @return GameMap
     */
    public static GameMap loadMaps() {
        final int ratio = SettingsLoader.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;
        final List<Block> z = new ArrayList<>();
        final GameObject potion = new GameObject(ObjectType.POTION, new Point2D(11*dimension, 1*dimension), true,
                new GameObjectGraphicComponent(), ratio);
        final GameObject sword = new GameObject(ObjectType.SWORD, new Point2D(12*dimension, 1*dimension), true,
                new GameObjectGraphicComponent(), ratio);
        final GameObject jacket = new GameObject(ObjectType.JACKET, new Point2D(13*dimension, 1*dimension), true,
                new GameObjectGraphicComponent(), ratio);
        final GameObject key = new GameObject(ObjectType.KEY, new Point2D(14*dimension, 1*dimension), true,
                new GameObjectGraphicComponent(), ratio);

        final Block box = new Block(ObjectType.BOX, new InteractWithPlayerEvent(potion, "Ecco la pozione!"),
                new Point2D(6*dimension, 5*dimension), true, new BlockGraphicComponent(), ratio);
        final Block chest = new Block(ObjectType.CHEST, new InteractWithPlayerEvent(sword, "Ecco la spada!", potion, "Prima la pozione!"),
                new Point2D(4*dimension, 5*dimension), true, new BlockGraphicComponent(), ratio);
        final Block npc = new Block(ObjectType.NPC, new InteractWithPlayerEvent(jacket, "Ecco la giacca!", sword, "Prima la spada!"),
                new Point2D(9*dimension, 5*dimension), true, new BlockGraphicComponent(), ratio);
        final Block sign = new Block(ObjectType.SIGN, new InteractWithPlayerEvent(key, "Ecco la chiave!", jacket, "Prima la giacca!"),
                new Point2D(11*dimension, 5*dimension), true, new BlockGraphicComponent(), ratio);

        z.add(box);
        z.add(chest);
        z.add(npc);
        z.add(sign);

        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*dimension, 0*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*dimension, 1*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(8*dimension, 2*dimension),
                false, new BlockGraphicComponent(), ratio));

        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(9*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(10*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(11*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(12*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(13*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(14*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));
        z.add(new Block(ObjectType.VOID, new NullEvent(), new Point2D(15*dimension, 3*dimension),
                false, new BlockGraphicComponent(), ratio));

        final GameMap map = new GameMap();
        map.setBlocks(z);
        return map;
    }

    public static Dialog createDialog(final String text) {
        final int ratio = SettingsLoader.loadSettings().scale();
        return new Dialog(new Point2D(Constant.DEFAULT_DIALOG_POSITION.getX() * ratio, Constant.DEFAULT_DIALOG_POSITION.getY() * ratio), true, new DialogGraphicComponent(),
                ratio * Constant.DEFAULT_DIALOG_SIZE, text);
    }
}
