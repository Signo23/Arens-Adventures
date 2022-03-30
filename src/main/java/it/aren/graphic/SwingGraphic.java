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
 * 
 *
 */
public class SwingGraphic implements GraphicController {

    final private Graphics2D g2;
    public SwingGraphic(final Graphics2D g2) {
        this.g2 = g2;
    }
    
    @Override
    public void drawPlayer(final Player player) {
        final int playerX = Math.round(player.getPosition().getX());
        final int playerY = Math.round(player.getPosition().getY());
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(playerX, playerY, Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);
    }

    @Override
    public void drawBlock(final Block block) {
        if(block.isDrawable()) {
            final int playerX = Math.round(block.getPosition().getX());
            final int playerY = Math.round(block.getPosition().getY());
            g2.setColor(Color.YELLOW);
            g2.setStroke(new BasicStroke(4f));
            g2.drawRect(playerX, playerY, Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);   
        }
    }

}
