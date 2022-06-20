/**
 * 
 */
package it.aren.core;

import java.util.ArrayList;
import java.util.List;

import it.aren.common.BaseLevelEnum;
import it.aren.common.Constant;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Point2D;
import it.aren.event.InteractWithPlayerEvent;
import it.aren.event.TransportEvent;
import it.aren.file.SettingsLoader;
import it.aren.graphic.component.BlockGraphicComponent;
import it.aren.graphic.component.DialogGraphicComponent;
import it.aren.graphic.component.GameObjectGraphicComponent;
import it.aren.graphic.component.PlayerGraphicComponent;
import it.aren.input.PlayerInputComponent;
import it.aren.model.game.Block;
import it.aren.model.game.Dialog;
import it.aren.model.game.GameMap;
import it.aren.model.game.GameObject;
import it.aren.model.game.Player;
import it.aren.physics.PlayerPhysicsComponent;
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
    public static List<GameMap> loadMaps() {
        final int ratio = SettingsLoader.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;
        final GameObject potion = new GameObject(BaseObjectEnum.POTION, new Point2D(11 * dimension, 1 * dimension), true,
                new GameObjectGraphicComponent());
        final GameObject sword = new GameObject(BaseObjectEnum.SWORD, new Point2D(12 * dimension, 1 * dimension), true,
                new GameObjectGraphicComponent());
        final GameObject jacket = new GameObject(BaseObjectEnum.JACKET, new Point2D(13 * dimension, 1 * dimension), true,
                new GameObjectGraphicComponent());
        final GameObject key = new GameObject(BaseObjectEnum.KEY, new Point2D(14 * dimension, 1 * dimension), true,
                new GameObjectGraphicComponent());

        final Block box = new Block(BaseObjectEnum.BOX, new InteractWithPlayerEvent(potion, "Ecco la pozione!"),
                new Point2D(13 * dimension, 4 * dimension), true, new BlockGraphicComponent());
        final Block chest = new Block(BaseObjectEnum.CHEST, new InteractWithPlayerEvent(sword, "Ecco la spada!", potion, "Prima la pozione!"),
                new Point2D(5 * dimension, 7 * dimension), true, new BlockGraphicComponent());
        final Block npc = new Block(BaseObjectEnum.NPC, new InteractWithPlayerEvent(jacket, "Ecco la giacca!", sword, "Prima la spada!"),
                new Point2D(11 * dimension, 4 * dimension), true, new BlockGraphicComponent());
        final Block sign = new Block(BaseObjectEnum.SIGN, new InteractWithPlayerEvent(key, "Ecco la chiave!", jacket, "Prima la giacca!"),
                new Point2D(9 * dimension, 7 * dimension), true, new BlockGraphicComponent());

        //Trnsport blocks
        final List<Block> transportL1 = new ArrayList<>();
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(0 * dimension, 5 * dimension), 1),
                new Point2D(16 * dimension, 5 * dimension), false, new BlockGraphicComponent()));
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(0 * dimension, 6 * dimension), 1),
                new Point2D(16 * dimension, 6 * dimension), false, new BlockGraphicComponent()));
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(0 * dimension, 7 * dimension), 1),
                new Point2D(16 * dimension, 7 * dimension), false, new BlockGraphicComponent()));

        final List<Block> transportL2 = new ArrayList<>();
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(15 * dimension, 5 * dimension), 0),
                new Point2D(-1 * dimension, 5 * dimension), false, new BlockGraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(15 * dimension, 6 * dimension), 0),
                new Point2D(-1 * dimension, 6 * dimension), false, new BlockGraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(15 * dimension, 7 * dimension), 0),
                new Point2D(-1 * dimension, 7 * dimension), false, new BlockGraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(6 * dimension, 0 * dimension), 2),
                new Point2D(6 * dimension, 12 * dimension), false, new BlockGraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(7 * dimension, 0 * dimension), 2),
                new Point2D(7 * dimension, 12 * dimension), false, new BlockGraphicComponent()));

        final List<Block> transportL3 = new ArrayList<>();
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(6 * dimension, 11 * dimension), 1),
                new Point2D(6 * dimension, -1 * dimension), false, new BlockGraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(7 * dimension, 11 * dimension), 1),
                new Point2D(7 * dimension, -1 * dimension), false, new BlockGraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(0 * dimension, 10 * dimension), 3),
                new Point2D(16 * dimension, 10 * dimension), false, new BlockGraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(0 * dimension, 11 * dimension), 3),
                new Point2D(16 * dimension, 11 * dimension), false, new BlockGraphicComponent()));

        final List<Block> transportL4 = new ArrayList<>();
        transportL4.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(15 * dimension, 10 * dimension), 2),
                new Point2D(-1 * dimension, 10 * dimension), false, new BlockGraphicComponent()));
        transportL4.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Point2D(15 * dimension, 11 * dimension), 2),
                new Point2D(-1 * dimension, 11 * dimension), false, new BlockGraphicComponent()));

        final List<GameMap> maps = new ArrayList<>();
        maps.add(new GameMap(BaseLevelEnum.ONE));
        maps.add(new GameMap(BaseLevelEnum.TWO));
        maps.add(new GameMap(BaseLevelEnum.THREE));
        maps.add(new GameMap(BaseLevelEnum.FOUR));
        maps.get(0).addBlocks(transportL1);
        maps.get(0).addBlock(sign);
        maps.get(1).addBlocks(transportL2);
        maps.get(1).addBlock(npc);
        maps.get(2).addBlocks(transportL3);
        maps.get(2).addBlock(box);
        maps.get(3).addBlocks(transportL4);
        maps.get(3).addBlock(chest);
        return maps;
    }

    public static Dialog createDialog(final String text) {
        final int ratio = SettingsLoader.loadSettings().scale();
        return new Dialog(new Point2D(Constant.DEFAULT_DIALOG_POSITION.getX() * ratio, Constant.DEFAULT_DIALOG_POSITION.getY() * ratio), true, new DialogGraphicComponent(),
                text);
    }
}
