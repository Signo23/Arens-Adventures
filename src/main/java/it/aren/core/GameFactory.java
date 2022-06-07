/**
 * 
 */
package it.aren.core;

import it.aren.common.BaseLevelEnum;
import it.aren.common.Constant;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.event.InteractWithPlayerEvent;
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
        final int ratio = SettingsLoader.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;
        final GameObject potion = new GameObject(BaseObjectEnum.POTION, new Point2D(11*dimension, 1*dimension), true,
                new GameObjectGraphicComponent());
        final GameObject sword = new GameObject(BaseObjectEnum.SWORD, new Point2D(12*dimension, 1*dimension), true,
                new GameObjectGraphicComponent());
        final GameObject jacket = new GameObject(BaseObjectEnum.JACKET, new Point2D(13*dimension, 1*dimension), true,
                new GameObjectGraphicComponent());
        final GameObject key = new GameObject(BaseObjectEnum.KEY, new Point2D(14*dimension, 1*dimension), true,
                new GameObjectGraphicComponent());

        final Block box = new Block(BaseObjectEnum.BOX, new InteractWithPlayerEvent(potion, "Ecco la pozione!"),
                new Point2D(9*dimension, 7*dimension), true, new BlockGraphicComponent());
        final Block chest = new Block(BaseObjectEnum.CHEST, new InteractWithPlayerEvent(sword, "Ecco la spada!", potion, "Prima la pozione!"),
                new Point2D(4*dimension, 5*dimension), true, new BlockGraphicComponent());
        final Block npc = new Block(BaseObjectEnum.NPC, new InteractWithPlayerEvent(jacket, "Ecco la giacca!", sword, "Prima la spada!"),
                new Point2D(9*dimension, 5*dimension), true, new BlockGraphicComponent());
        final Block sign = new Block(BaseObjectEnum.SIGN, new InteractWithPlayerEvent(key, "Ecco la chiave!", jacket, "Prima la giacca!"),
                new Point2D(11*dimension, 5*dimension), true, new BlockGraphicComponent());

        final GameMap map = new GameMap(BaseLevelEnum.ONE);
        map.addBlock(box);
        map.addBlock(chest);
        map.addBlock(npc);
        map.addBlock(sign);
        return map;
    }    

    public static Dialog createDialog(final String text) {
        final int ratio = SettingsLoader.loadSettings().scale();
        return new Dialog(new Point2D(Constant.DEFAULT_DIALOG_POSITION.getX() * ratio, Constant.DEFAULT_DIALOG_POSITION.getY() * ratio), true, new DialogGraphicComponent(),
                text);
    }
}
