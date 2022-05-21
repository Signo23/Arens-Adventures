/**
 * 
 */
package it.aren.graphic;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import it.aren.common.Constant;
import it.aren.model.Block;
import it.aren.model.GameMap;
import it.aren.model.Player;

/**
 * Class for draw entities with Swing.
 * Implements {@link GraphicController}.
 */
public class SwingGraphic implements GraphicController {

    final private Graphics2D g2;
    final private ImageObserver io;
    final Texture tex;
      /**
     * Create a SwingGraphic.
     * @param g2 for draw
     */
    public SwingGraphic(final Graphics2D g2, final ImageObserver io, final Texture tex) {
        this.g2 = g2;
        this.io = io;
        this.tex = tex;
    }
    
    @Override
    /**
     * {@inheritDoc}
     */
    public void drawPlayer(final Player player) {
        g2.drawImage(this.tex.getPlayer(), (int) player.getPosition().getX(), (int) player.getPosition().getY(), this.io);
        g2.drawRect((int) player.getHitBox().getX(), (int) player.getHitBox().getY(),
                Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void drawBlock(final Block block) {
        if(block.isDrawable()) {
            g2.drawImage(this.tex.getChest(), (int)block.getPosition().getX(), (int)block.getPosition().getY(), this.io);
            g2.drawRect((int) block.getHitBox().getX(), (int) block.getHitBox().getY(),
                    Constant.DEFAULT_HITBOX_DIMENSION, Constant.DEFAULT_HITBOX_DIMENSION);
        }
    }

    @Override
    public void drawGameMap(final GameMap gameMap) {
        g2.drawImage(this.tex.getLevelOne(), (int)gameMap.getPosition().getX(), (int)gameMap.getPosition().getY(), this.io);
    }

}
