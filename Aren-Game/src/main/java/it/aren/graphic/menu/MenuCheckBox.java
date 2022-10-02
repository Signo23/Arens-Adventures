package it.aren.graphic.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import it.aren.common.BaseActionEnum;
import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.file.SettingsLoader;

/**
 * Model for menu check box.
 * Extends {@link JCheckBox} 
 *
 */
public class MenuCheckBox extends JCheckBox {

    private static final long serialVersionUID = 1L;

    /**
     * Create menu check box.
     * @param text
     */
    public MenuCheckBox(final String text) {
        super(text);
        this.setBackground(Color.YELLOW);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.setIcon(new ImageIcon(BaseActionEnum.CHECK_OFF.getTexture()));
        this.setSelectedIcon(new ImageIcon(BaseActionEnum.CHECK_ON.getTexture()));
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, MenuButton.class
                              .getResourceAsStream(Constant.FONT_FOLDER + "Minecraft.ttf"));
            final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            final SettingsLoader settingsLoader = new SettingsLoader();
            final Settings settings = settingsLoader.loadFile(Constant.SETTINGS_FILE);
            customFont = customFont.deriveFont(Font.PLAIN, Constant.DEFAULT_TEXT_DIMENSION * settings.scale());
            ge.registerFont(customFont);
            this.setFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}