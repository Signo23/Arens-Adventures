package it.aren.event;

import it.aren.model.GameObject;
import it.aren.model.World;
/**
 * A class for display a message and add an {@link GameObect} to {@link Player}'s backpack.
 * Implements {@link Event}
 *
 */
public class GiveToPlayerEvent implements Event {

    private final GameObject object;
    private final String dialog;
    
    /**
     * Constructor for GiveToPlayerEvent.
     * @param object the {@link GameObject} to give to {@link Player}
     * @param dialog the message to display 
     */
    public GiveToPlayerEvent(final GameObject object, final String dialog) {
        this.object = object;
        this.dialog = dialog;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void launch(final World world) {
        System.out.println(this.dialog);
        world.getPlayer().getBackPack().add(this.object);
    }

}
