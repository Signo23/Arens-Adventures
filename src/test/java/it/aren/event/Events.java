package it.aren.event;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.aren.common.Point2D;
import it.aren.core.GameFactory;
import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.GameObject;
import it.aren.model.World;

class Events {

    @Test void testGiveToPlayerEvent() {
        final World w = new World();
        final GameObject go = new GameObject(new Point2D(), false, null, null, "1");
        final Event ev = new GiveToPlayerEvent(go, "Prova");
        final Block blk = new Block(new Point2D(), false, null, null);
        final GameMap gm = new GameMap(16, 16, new ArrayList<>());
        
        
        blk.setEvent(ev);
        gm.getBlocks().add(blk);
        w.setPlayer(GameFactory.createPlayer());
        w.addMap(gm);
        w.setCurrentMap(0);
        
        final List<Event> listEvent = new ArrayList<>();
        w.getCurrentMap().getBlocks().forEach(b -> listEvent.add(b.getEvent()));
        listEvent.forEach(e -> System.out.println(e));
        listEvent.forEach(e -> e.launch(w));
        
        final List<GameObject> listGo = new ArrayList<>();
        listGo.add(go);
        System.out.println(w.getPlayer().getBackPack());
        System.out.println(go);
        assertEquals(w.getPlayer().getBackPack(), listGo);
    }
}
