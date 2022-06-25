package it.aren.graphic.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import it.aren.common.Constant;
import it.aren.file.SettingsLoader;
import it.aren.model.BaseEntity;

/**
 * Model for menu combo.
 * Extends {@link JComboBox} of {@Link ReadableDimension}
 *
 */
public class MenuCombo extends JComboBox<ReadableDimension> {

    private static final long serialVersionUID = 1L;

    /**
     * Create menu combo.
     */
    public MenuCombo() {
        super();
        this.setBackground(Color.YELLOW);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, MenuButton.class
                              .getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf"));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            customFont = customFont.deriveFont(Font.PLAIN, Constant.DEFAULT_TEXT_DIMENSION * SettingsLoader
                         .loadSettings().scale());
            ge.registerFont(customFont);
            this.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

}