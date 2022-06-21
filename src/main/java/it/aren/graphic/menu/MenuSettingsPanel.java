package it.aren.graphic.menu;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;
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

public class MenuSettingsPanel extends JPanel {

    private static final long serialVersionUID = 1L;

      /**
     * Initialize the panel.
     * @param w weight of panel
     * @param h height of panel
     * @param world to render
     * @param inputController for listen the input
     */
    public MenuSettingsPanel(final MenuInputController menuController) {

        final Settings settings = SettingsLoader.loadSettings();
        final int dimension = Constant.DEFAULT_HITBOX_DIMENSION * settings.scale();
        this.setPreferredSize(settings.getScreenSize());
        this.setLayout(null);
        final MenuButton playButton = new MenuButton(BaseActionEnum.SAVE.getTexture(), "Rendering: Fast");
        final MenuButton save = new MenuButton(BaseActionEnum.SAVE.getTexture(), "Salva");
        final MenuButton clear = new MenuButton(BaseActionEnum.CLEAR.getTexture(), "Annulla");
        final MenuCombo comboDimension = new MenuCombo();
        final MenuCheckBox antiAliasing = new MenuCheckBox("AntiAliasing");
        comboDimension.addItem(new ReadableDimension(512, 384));
        comboDimension.addItem(new ReadableDimension(1024, 768));

        playButton.setBounds(1 * dimension, 6 * dimension,
                8 * dimension, 1 * dimension);
        save.setBounds((int)(12.5 * dimension), (int)(10.5 * dimension),
                4 * dimension, 1 * dimension);
        clear.setBounds(1 * dimension, (int)(10.5 * dimension),
                4 * dimension, 1 * dimension);
        antiAliasing.setBounds(1 * dimension, (int)(7.5 * dimension),
                8 * dimension, 1 * dimension);
        comboDimension.setBounds(1 * dimension, (int)(9 * dimension),
                8 * dimension, 1 * dimension);

        playButton.addActionListener(a -> {
            if ("Rendering: Fast".equals(playButton.getText())) {
                playButton.setText("Rendering: Quality");
            } else {
                playButton.setText("Rendering: Fast");
            }
        });

        save.addActionListener(a -> {
            final int userChoice = JOptionPane.showConfirmDialog(this, "Salvare le nuove impostazioni?\n L'applicazione verrà riavviata");
            switch (userChoice) {
            case 0:
                final Settings settingsNew = new Settings();
                settingsNew.setAntiAliasingOn(antiAliasing.isSelected());
                settingsNew.setRenderQuality("Rendering: Quality".equals(playButton.getText()));
                settingsNew.setScreenSize((ReadableDimension) comboDimension.getSelectedItem());
                SettingsSaver.saveSettings(settingsNew);
                App.restart();
                break;
            case 1:
                menuController.notifyIsInteract();
                break;
            default:
                break;
            }
        });

        clear.addActionListener(a -> {
            menuController.notifyIsInteract();
        });

        if (settings.isAntiAliasingOn()) {
            antiAliasing.setSelected(true);
        }
        if (settings.isRenderQuality()) {
            playButton.setText("Rendering: Quality");
        }
        comboDimension.setSelectedItem(settings.getScreenSize());

        this.add(playButton);
        this.add(antiAliasing);
        this.add(comboDimension);
        this.add(save);
        this.add(clear);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.requestFocusInWindow(); 
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