package it.aren.graphic.menu;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.aren.App;
import it.aren.common.BaseActionEnum;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Constant;
import it.aren.common.Settings;
import it.aren.file.SettingsLoader;
import it.aren.file.SettingsSaver;
import it.aren.input.MenuInputController;

/**
 * Model for menu settings panel.
 * Extends {@link JPanel} 
 *
 */
public class MenuSettingsPanel extends JPanel {

    private static final double SAVE_START_X = 12.5;
    private static final int DIMENSION_START_Y = 9;
    private static final double LAYOUT_CONTROLLER_START_Y = 10.5;
    private static final int LAYOUT_CONTROLLER_WIDTH = 4;
    private static final int CONTROLLER_HEIGHT = 1;
    private static final int CONTROLLER_WIDTH = 8;
    private static final double ALIASING_START_Y = 7.5;
    private static final int RENDER_START_Y = 6;
    private static final int CONTROLLER_START_X = 1;
    private static final int Y_768 = 768;
    private static final int X_1024 = 1024;
    private static final int Y_384 = 384;
    private static final int X_512 = 512;
    private static final long serialVersionUID = 1L;
    private final MenuButton renderButton;
    private final MenuCombo comboDimension;
    private final MenuCheckBox antiAliasing;
    private final Settings settings;

    /**
     * Initialize the panel.
     * @param w weight of panel
     * @param h height of panel
     * @param world to render
     * @param inputController for listen the input
     */
    public MenuSettingsPanel(final MenuInputController menuController) {

        this.settings = SettingsLoader.loadSettings();
        final int dimension = Constant.DEFAULT_HITBOX_DIMENSION * this.settings.scale();
        this.setPreferredSize(this.settings.getScreenSize());
        this.setLayout(null);
        this.renderButton = new MenuButton(BaseActionEnum.SAVE.getTexture(), "Rendering: Fast");
        this.comboDimension = new MenuCombo();
        this.antiAliasing = new MenuCheckBox("AntiAliasing");
        final MenuButton save = new MenuButton(BaseActionEnum.SAVE.getTexture(), "Salva");
        final MenuButton clear = new MenuButton(BaseActionEnum.CLEAR.getTexture(), "Annulla");
        comboDimension.addItem(new ReadableDimension(X_512, Y_384));
        comboDimension.addItem(new ReadableDimension(X_1024, Y_768));

        this.renderButton.setBounds(CONTROLLER_START_X * dimension, RENDER_START_Y * dimension,
                CONTROLLER_WIDTH * dimension, CONTROLLER_HEIGHT * dimension);
        this.antiAliasing.setBounds(CONTROLLER_START_X * dimension, (int) (ALIASING_START_Y * dimension),
                CONTROLLER_WIDTH * dimension, CONTROLLER_HEIGHT * dimension);
        this.comboDimension.setBounds(CONTROLLER_START_X * dimension, (int) (DIMENSION_START_Y * dimension),
                CONTROLLER_WIDTH * dimension, CONTROLLER_HEIGHT * dimension);
        save.setBounds((int) (SAVE_START_X * dimension), (int) (LAYOUT_CONTROLLER_START_Y * dimension),
                LAYOUT_CONTROLLER_WIDTH * dimension, CONTROLLER_START_X * dimension);
        clear.setBounds(CONTROLLER_HEIGHT * dimension, (int) (LAYOUT_CONTROLLER_START_Y * dimension),
                LAYOUT_CONTROLLER_WIDTH * dimension, CONTROLLER_HEIGHT * dimension);

        this.renderButton.addActionListener(a -> {
            if ("Rendering: Fast".equals(renderButton.getText())) {
                this.renderButton.setText("Rendering: Quality");
            } else {
                this.renderButton.setText("Rendering: Fast");
            }
        });

        save.addActionListener(a -> {
            final int userChoice = JOptionPane.showConfirmDialog(this, "Salvare le nuove impostazioni?\n"
                                   + " L'applicazione verrà riavviata");
            switch (userChoice) {
            case 0:
                final Settings settingsNew = new Settings();
                settingsNew.setAntiAliasingOn(antiAliasing.isSelected());
                settingsNew.setRenderQuality("Rendering: Quality".equals(renderButton.getText()));
                settingsNew.setScreenSize((ReadableDimension) comboDimension.getSelectedItem());
                SettingsSaver.saveSettings(settingsNew);
                App.restart();
                break;
            case CONTROLLER_START_X:
                menuController.notifyIsInteract();
                break;
            default:
                break;
            }
        });

        clear.addActionListener(a -> {
            menuController.notifyIsInteract();
        });

        this.initSettingsControll();

        this.add(this.renderButton);
        this.add(this.antiAliasing);
        this.add(this.comboDimension);
        this.add(save);
        this.add(clear);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.requestFocusInWindow(); 
    }

    /**
     * Initialize the value of controller.
     */
    public final void initSettingsControll() {
        if (this.settings.isAntiAliasingOn()) {
            this.antiAliasing.setSelected(true);
        }
        if (this.settings.isRenderQuality()) {
            this.renderButton.setText("Rendering: Quality");
        }
        this.comboDimension.setSelectedItem(this.settings.getScreenSize());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(BaseObjectEnum.BACKGROUND.getTexture(), 0, 0, this);
    }
}