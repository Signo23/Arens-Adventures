/**
 * 
 */
package it.aren.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import it.aren.common.Point2D;
import it.aren.common.Constant;
import it.aren.model.Block;
import it.aren.model.Dialog;
import it.aren.model.GameMap;
import it.aren.model.GameObject;
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
    public void drawPlayer(final Player player) {        
    }
    @Override
    /**
     * {@inheritDoc}
     */
    public void drawPlayer(final Point2D playerPosition, final BufferedImage sprite) {
        g2.drawImage(sprite, (int) playerPosition.getX(), (int) playerPosition.getY(), this.io);
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

    @Override
    public final void drawObject(final GameObject obj) {
        //Da modificare le posizioni
        g2.drawImage(this.tex.getChest(), (int) obj.getPosition().getX(), (int) obj.getPosition().getY(), this.io);
    }

    //Da modificare
    @Override
    public final void drawDialog(final Dialog dialog) {
        g2.setColor(Color.white);
        g2.fillRect((int) dialog.getPosition().getX(), (int) dialog.getPosition().getY(), dialog.getHitBox().width, dialog.getHitBox().height - 64);
        //stampa del testo
        g2.setFont(new Font("Century Gothic", Font.PLAIN, Constant.DEFAULT_TEXT_DIMENSION));
        g2.setColor(Color.black);
        g2.drawString(dialog.getText(), (int) dialog.getPosition().getX() + 16, (int) dialog.getPosition().getY() + 32);
    }
}
