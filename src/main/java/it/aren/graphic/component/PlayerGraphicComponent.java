package it.aren.graphic.component;

import it.aren.graphic.GraphicComponent;
import it.aren.graphic.GraphicController;
import it.aren.graphic.game.PlayerAnimation;
import it.aren.model.BaseEntity;
import it.aren.model.Player;

/**
 * Graphic for {@link Player}.
 * Implements {@link GraphicComponent}
 */
public class PlayerGraphicComponent implements GraphicComponent {


    private final PlayerAnimation animation;

    public PlayerGraphicComponent() {
        this.animation = new PlayerAnimation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final BaseEntity player, final GraphicController g) {
        final Player tmpPlayer = (Player) player;
        g.drawPlayer(player.getPosition(), tmpPlayer.isIdle() ? this.animation.getNextIdle(tmpPlayer.getLastDirection())
                : this.animation.getNextWalk(tmpPlayer.getLastDirection()));
        tmpPlayer.getBackPack().forEach(go -> go.updateGraphic(g));
    }

}
