package it.aren.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.aren.common.*;
import it.aren.file.MapsLoader;
import it.aren.file.SettingsSaver;
import it.aren.model.GameComponent;
import it.aren.geom.Vector2D;
import it.aren.event.InteractWithPlayerEvent;
import it.aren.event.TransportEvent;
import it.aren.graphic.component.GraphicComponent;
import it.aren.model.input.PlayerInputComponent;
import it.aren.file.SettingsLoader;
import it.aren.model.game.Block;
import it.aren.model.game.Dialog;
import it.aren.model.game.GameMap;
import it.aren.model.game.GameObject;
import it.aren.model.game.Player;
import it.aren.model.physics.PlayerPhysicsComponent;

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
     * Creates a new {@link Player}.
     * @return the new {@link Player}
     */
    public static Player createPlayer() {
         final Player player = new Player(new Vector2D(0, 1));
         player.addComponent(GameComponent.INPUT, new PlayerInputComponent());
         player.addComponent(GameComponent.GRAPHIC, new GraphicComponent());
         player.addComponent(GameComponent.PHYSIC, new PlayerPhysicsComponent());
         return player;
    }

    /**
     * Loads the {@link GameMap}.
     * @return maps a {@link List} of {@link GameMap}
     */
    public static List<GameMap> loadMaps() {
        final int ratio = GameFactory.loadSettings().scale();
        final int dimension = ratio * Constant.DEFAULT_HITBOX_DIMENSION;

        final GameObject potion = new GameObject(BaseObjectEnum.POTION, new Vector2D(11 * dimension, 1 * dimension), true,
                new GraphicComponent());
        final GameObject sword = new GameObject(BaseObjectEnum.SWORD, new Vector2D(12 * dimension, 1 * dimension), true,
                new GraphicComponent());
        final GameObject jacket = new GameObject(BaseObjectEnum.JACKET, new Vector2D(13 * dimension, 1 * dimension), true,
                new GraphicComponent());
        final GameObject key = new GameObject(BaseObjectEnum.KEY, new Vector2D(14 * dimension, 1 * dimension), true,
                new GraphicComponent());
        final GameObject voidObject = new GameObject(BaseObjectEnum.VOID, new Vector2D(0, 0), false,
                new GraphicComponent());

        final Block box = new Block(BaseObjectEnum.BOX, new InteractWithPlayerEvent(potion, "Hai trovato la pozione!"),
                new Vector2D(13 * dimension, 4 * dimension), true, new GraphicComponent());
        final Block chest = new Block(BaseObjectEnum.CHEST, new InteractWithPlayerEvent(sword, "Hai trovato la spada!",
                potion, "Non riesci ad aprire la cassa.\nForse una pozione potrebbe aiutarti!"),
                new Vector2D(5 * dimension, 7 * dimension), true, new GraphicComponent());
        final Block npc = new Block(BaseObjectEnum.NPC, new InteractWithPlayerEvent(jacket,
                "Ti serve una giacca per proseguire\nla tua avventura?\nEcco puoi prendere la mia!", sword, 
                "Mi dispiace, ma non parlo con\nnessuno che non abbia una spada"),
                new Vector2D(11 * dimension, 4 * dimension), true, new GraphicComponent());
        final Block sign = new Block(BaseObjectEnum.SIGN, new InteractWithPlayerEvent(key,
                "Hai trovato la chiave!\nSei quasi pronto per la tua\navventura", jacket, 
                "Non e' facile prendere quello che e'\nincastrato nel cartello.\nUna giacca potrebbe aiutarti"),
                new Vector2D(9 * dimension, 7 * dimension), true, new GraphicComponent());
        final Block npc2 = new Block(BaseObjectEnum.NPC_2, new InteractWithPlayerEvent(voidObject,
                "Ottimo! Vedo che hai la chiave ed\naltri oggetti utili. Ora sei pronto per la\ntua avventura", key, 
                "Se vuoi partire, devi portarmi\nla chiave del cancello della citta'"),
                new Vector2D(13 * dimension, 9 * dimension), true, new GraphicComponent());

        final List<Block> transportL1 = new ArrayList<>();
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(0 * dimension, 5 * dimension), 1),
                new Vector2D(16 * dimension, 5 * dimension), false, new GraphicComponent()));
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(0 * dimension, 6 * dimension), 1),
                new Vector2D(16 * dimension, 6 * dimension), false, new GraphicComponent()));
        transportL1.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(0 * dimension, 7 * dimension), 1),
                new Vector2D(16 * dimension, 7 * dimension), false, new GraphicComponent()));

        final List<Block> transportL2 = new ArrayList<>();
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(15 * dimension, 5 * dimension), 0),
                new Vector2D(-1 * dimension, 5 * dimension), false, new GraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(15 * dimension, 6 * dimension), 0),
                new Vector2D(-1 * dimension, 6 * dimension), false, new GraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(15 * dimension, 7 * dimension), 0),
                new Vector2D(-1 * dimension, 7 * dimension), false, new GraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(6 * dimension, 0 * dimension), 2),
                new Vector2D(6 * dimension, 12 * dimension), false, new GraphicComponent()));
        transportL2.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(7 * dimension, 0 * dimension), 2),
                new Vector2D(7 * dimension, 12 * dimension), false, new GraphicComponent()));

        final List<Block> transportL3 = new ArrayList<>();
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(6 * dimension, 11 * dimension), 1),
                new Vector2D(6 * dimension, -1 * dimension), false, new GraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(7 * dimension, 11 * dimension), 1),
                new Vector2D(7 * dimension, -1 * dimension), false, new GraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(0 * dimension, 10 * dimension), 3),
                new Vector2D(16 * dimension, 10 * dimension), false, new GraphicComponent()));
        transportL3.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(0 * dimension, 11 * dimension), 3),
                new Vector2D(16 * dimension, 11 * dimension), false, new GraphicComponent()));

        final List<Block> transportL4 = new ArrayList<>();
        transportL4.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(15 * dimension, 10 * dimension), 2),
                new Vector2D(-1 * dimension, 10 * dimension), false, new GraphicComponent()));
        transportL4.add(new Block(BaseObjectEnum.VOID, new TransportEvent(new Vector2D(15 * dimension, 11 * dimension), 2),
                new Vector2D(-1 * dimension, 11 * dimension), false, new GraphicComponent()));

        final List<GameMap> maps = new ArrayList<>();
        maps.add(new GameMap(BaseLevelEnum.ONE));
        maps.add(new GameMap(BaseLevelEnum.TWO));
        maps.add(new GameMap(BaseLevelEnum.THREE));
        maps.add(new GameMap(BaseLevelEnum.FOUR));
        maps.get(0).addBlocks(transportL1);
        maps.get(0).addBlock(sign);
        maps.get(0).addComponent(GameComponent.GRAPHIC, new GraphicComponent());
        maps.get(1).addBlocks(transportL2);
        maps.get(1).addBlock(npc);
        maps.get(1).addComponent(GameComponent.GRAPHIC, new GraphicComponent());
        maps.get(2).addBlocks(transportL3);
        maps.get(2).addBlock(box);
        maps.get(2).addComponent(GameComponent.GRAPHIC, new GraphicComponent());
        maps.get(3).addBlocks(transportL4);
        maps.get(3).addBlock(chest);
        maps.get(3).addBlock(npc2);
        maps.get(3).addComponent(GameComponent.GRAPHIC, new GraphicComponent());
        return maps;
    }

    /**
     * Create a {@link Dialog}.
     * @param text the message to display
     * @return a new {@link Dialog}
     */
    public static Dialog createDialog(final String text) {
        final SettingsLoader settingsLoader = new SettingsLoader();
        final int ratio = GameFactory.loadSettings().scale();
        return new Dialog(new Vector2D(Constant.DEFAULT_DIALOG_POSITION.getX() * ratio,
                Constant.DEFAULT_DIALOG_POSITION.getY() * ratio), true, new GraphicComponent(), text);
    }

    public static Settings loadSettings(){
        final SettingsLoader settingsLoader = new SettingsLoader();
        return settingsLoader.loadFile(Constant.SETTINGS_FILE);
    }

    public static void saveSettings(final Settings settings){
        final SettingsSaver settingsSaver = new SettingsSaver();
        settingsSaver.saveFile(settings, Constant.SETTINGS_FILE);
    }

    public static Map<String, List<PointRange>> loadMapsBlocks(){
        final MapsLoader mapsLoader = new MapsLoader();
        return mapsLoader.loadFile(Constant.MAPS_FILE);
    }
}
