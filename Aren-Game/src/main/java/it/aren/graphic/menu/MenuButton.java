package it.aren.graphic.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.core.GameFactory;
import it.aren.file.SettingsLoader;

/**
 * Model for menu button.
 * Extends {@link JButton}
 *
 */
public class MenuButton extends JButton {

    private static final long serialVersionUID = 1L;
    private final BufferedImage texture;

    /**
     * Create menu button.
     * @param texture
     * @param text
     */
    public MenuButton(final BufferedImage texture, final String text) {
        super(text);
        this.texture = texture;
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,
                    MenuButton.class.getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf"));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, Constant.DEFAULT_TEXT_DIMENSION * GameFactory
                    .loadSettings().scale());
            ge.registerFont(customFont);
            this.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.texture, 0, 0, this);
    }
}
