/**
 * 
 */
package it.aren.graphic;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import it.aren.common.Point2D;
import it.aren.file.SettingsLoader;
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

    private final Graphics2D g2;
    private final ImageObserver io;
      /**
     * Create a SwingGraphic.
     * @param g2 for draw
     */
    public SwingGraphic(final Graphics2D g2, final ImageObserver io) {
        this.g2 = g2;
        this.io = io;
    }

    @Override
    public void drawPlayer(final Player player) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void drawPlayer(final Point2D playerPosition, final BufferedImage sprite) {
        g2.drawImage(sprite, (int) playerPosition.getX(), (int) playerPosition.getY(), this.io);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void drawBlock(final Block block) {
        if (block.isDrawable()) {
            g2.drawImage(block.getType().getTexture(), (int) block.getPosition().getX(), (int) block.getPosition().getY(), this.io);
            g2.drawRect((int) block.getHitBox().getX(), (int) block.getHitBox().getY(),
                    block.getHitBox().width, block.getHitBox().height);
        }
    }

    @Override
    public final void drawGameMap(final GameMap gameMap) {
        g2.drawImage(gameMap.getType().getImage(), (int) gameMap.getPosition().getX(), (int) gameMap.getPosition().getY(), this.io);
    }

    @Override
    public final void drawObject(final GameObject obj) {
        g2.drawImage(obj.getType().getTexture(), (int) obj.getPosition().getX(), (int) obj.getPosition().getY(), this.io);
    }

    @Override
    public final void drawDialog(final Dialog dialog) {
        final int ratio = SettingsLoader.loadSettings().scale();
        g2.setColor(Color.white);
        g2.fillRect((int) dialog.getPosition().getX(), (int) dialog.getPosition().getY(), 
                dialog.getHitBox().width, dialog.getHitBox().height - 11 * Constant.DEFAULT_HITBOX_DIMENSION);
        //stampa del testo
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf"));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, 24 * ratio);
            ge.registerFont(customFont);
            g2.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        g2.setColor(Color.black);
        g2.drawString(dialog.getText(), (int) dialog.getPosition().getX() + 16 * ratio, (int) dialog.getPosition().getY() + 32 * ratio);
    }
}
