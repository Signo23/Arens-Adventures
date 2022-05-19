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
        final GameObject go2 = new GameObject(new Point2D(), false, null, null, "d");
        final Event ev = new InteractWithPlayerEvent(go, "Prova");
        final Event evRequirement = new InteractWithPlayerEvent(go2, "Prova requisiti", go, "Requisiti non rispettati");
        final Block blk = new Block(new Point2D(), false, null, null);
        final Block blkReq = new Block(new Point2D(), false, null, null);
        final GameMap gm = new GameMap(16, 16, new ArrayList<>());
        
        
        blk.setEvent(ev);
        blkReq.setEvent(evRequirement);
        gm.getBlocks().add(blk);
        gm.getBlocks().add(blkReq);
        w.setPlayer(GameFactory.createPlayer());
        w.addMap(gm);
        w.setCurrentMap(0);
        
        final List<Event> listEvent = new ArrayList<>();
        listEvent.add(evRequirement);
        w.getCurrentMap().getBlocks().forEach(b -> listEvent.add(b.getEvent()));
        listEvent.forEach(e -> System.out.println(e));
        listEvent.forEach(e -> e.launch(w));
        
        final List<GameObject> listGo = new ArrayList<>();
        listGo.add(go);
        listGo.add(go2);
        System.out.println(w.getPlayer().getBackPack());
        System.out.println(go);
        assertEquals(w.getPlayer().getBackPack(), listGo);
    }
}
