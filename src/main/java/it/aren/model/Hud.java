package it.aren.model;

import it.aren.graphic.GraphicController;

public class Hud {
    private final World world;

    public Hud(final World world) {
        this.world = world;
    }

    public final void render(final GraphicController g) {
        if (!this.world.getPlayer().getBackPack().isEmpty()) {
            this.world.getPlayer().getBackPack().forEach(obj -> g.drawObject(obj));
        }
    }

    public void update() {
        //Aggiorno l'HUD
    }

}
