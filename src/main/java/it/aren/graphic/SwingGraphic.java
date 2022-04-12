/**
 * 
 */
package it.aren.graphic;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.Player;

/**
 * 
 *
 */
public class SwingGraphic implements GraphicController {

    final private Graphics2D g2;
    final private ImageObserver io;
    final Texture tex;
    public SwingGraphic(final Graphics2D g2, final ImageObserver io, final Texture tex) {
        this.g2 = g2;
        this.io = io;
        this.tex = tex;
    }
    
    @Override
    public void drawPlayer(final Player player) {
        g2.drawImage(this.tex.getPlayer(), (int) player.getPosition().getX(), (int) player.getPosition().getY(), this.io);
    }

    @Override
    public void drawBlock(final Block block) {
        if(block.isDrawable()) {
            g2.drawImage(this.tex.getChest(), (int)block.getPosition().getX(), (int)block.getPosition().getY(), this.io);
        }
    }

    @Override
    public void drawGameMap(final GameMap gameMap) {
        g2.drawImage(this.tex.getLevelOne(), (int)gameMap.getPosition().getX(), (int)gameMap.getPosition().getY(), this.io);
    }

}
