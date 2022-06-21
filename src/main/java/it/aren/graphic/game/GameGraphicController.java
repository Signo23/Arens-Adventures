package it.aren.graphic.game;

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
import it.aren.graphic.GraphicController;
import it.aren.model.game.Block;
import it.aren.model.game.Dialog;
import it.aren.model.game.GameMap;
import it.aren.model.game.GameObject;
import it.aren.common.Constant;

/**
 * Class for draw entities with Swing.
 * Implements {@link GraphicController}.
 */
public class GameGraphicController implements GraphicController {

    private static final int FONT_DEFAULT_DIMENSION = 24;
    private final Graphics2D g2;
    private final ImageObserver io;

     /**
     * Create a SwingGraphic.
     * @param g2 for draw
     * @param io the {@link ImageObserver} to draw
     */
    public GameGraphicController(final Graphics2D g2, final ImageObserver io) {
        this.g2 = g2;
        this.io = io;
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
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void drawGameMap(final GameMap gameMap) {
        g2.drawImage(gameMap.getType().getImage(), (int) gameMap.getPosition().getX(), (int) gameMap.getPosition().getY(), this.io);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void drawObject(final GameObject obj) {
        g2.drawImage(obj.getType().getTexture(), (int) obj.getPosition().getX(), (int) obj.getPosition().getY(), this.io);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void drawDialog(final Dialog dialog) {
        final int ratio = SettingsLoader.loadSettings().scale();
        this.g2.setColor(Color.white);
        this.g2.fillRect((int) dialog.getPosition().getX(), (int) dialog.getPosition().getY(), 
                dialog.getHitBox().width, dialog.getHitBox().height);
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, this.getClass()
                                  .getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf"));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, FONT_DEFAULT_DIMENSION * ratio);
            ge.registerFont(customFont);
            this.g2.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.g2.setColor(Color.black);
        final int lineHeight = this.g2.getFontMetrics().getHeight();
        final int x = (int) dialog.getPosition().getX() + 16 * ratio;
        int y = (int) dialog.getPosition().getY() + 32 * ratio;
        for (final String line : dialog.getText().split("\n")) {
            this.g2.drawString(line, x, y);
            y += lineHeight;
        }
    }
}
