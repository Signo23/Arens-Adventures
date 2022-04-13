/**
 * 
 */
package it.aren.graphic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import it.aren.common.Constant;
import it.aren.model.Block;
import it.aren.model.Player;

/**
 * Class for draw entities with Swing.
 * Implements {@link GraphicController}.
 */
public class SwingGraphic implements GraphicController {

    final private Graphics2D g2;
    /**
     * Create a SwingGraphic.
     * @param g2 for draw
     */
    public SwingGraphic(final Graphics2D g2) {
        this.g2 = g2;
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void drawPlayer(final Player player) {
        final int playerX = Math.round(player.getPosition().getX());
        final int playerY = Math.round(player.getPosition().getY());
        this.g2.setColor(Color.BLUE);
        this.g2.setStroke(new BasicStroke(4f));
        this.g2.drawRect(playerX, playerY, Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void drawBlock(final Block block) {
        if(block.isDrawable()) {
            final int playerX = Math.round(block.getPosition().getX());
            final int playerY = Math.round(block.getPosition().getY());
            this.g2.setColor(Color.YELLOW);
            this.g2.setStroke(new BasicStroke(4f));
            this.g2.drawRect(playerX, playerY, Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);   
        }
    }

}
