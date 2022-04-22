package it.aren.event;

import java.util.Optional;

import it.aren.model.GameObject;
import it.aren.model.World;
/**
 * A class for display a message and add an {@link GameObect} to {@link Player}'s backpack.
 * Implements {@link Event}
 *
 */
public class InteractWithPlayerEvent implements Event {

    private final GameObject object;
    private final String dialog;
    private final Optional<GameObject> requirement;
    private final String alternativeDialog;
    
    /**
     * Constructor for InteractWithPlayerEvent.
     * @param object the {@link GameObject} to give to {@link Player}
     * @param dialog the message to display 
     */
    public InteractWithPlayerEvent(final GameObject object, final String dialog) {
        this.object = object;
        this.dialog = dialog;
        this.requirement = Optional.empty();
        this.alternativeDialog = "";
    }
    
    /**
     * Constructor for InteractWithPlayerEvent with requirement.
     * @param object the {@link GameObject} to give to {@link Player}
     * @param dialog the message to display 
     * @param requirement the {@link GameObject} required to launch the main event
     * @param alternativeDialog the message to display if the requirement is not respected
     */
    public InteractWithPlayerEvent(final GameObject object, final String dialog, final GameObject requirement, final String alterantiveDialog) {
        this.object = object;
        this.dialog = dialog;
        this.requirement = Optional.of(requirement);
        this.alternativeDialog = alterantiveDialog;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void launch(final World world) {
        if(this.requirement.isPresent()) {
            if(world.getPlayer().getBackPack().contains(this.requirement.get())) {
                launchMainEvent(world);
            } else {
                System.out.println(this.alternativeDialog);
            }
        } else {
            launchMainEvent(world);
        }
    }

    private void launchMainEvent(final World world) {
        System.out.println(this.dialog);
        world.getPlayer().getBackPack().add(this.object);
    }

}
