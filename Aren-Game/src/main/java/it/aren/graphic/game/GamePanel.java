package it.aren.graphic.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import it.aren.common.Settings;
import it.aren.model.BaseEntity;
import it.aren.file.SettingsLoader;
import it.aren.graphic.GraphicController;
import it.aren.input.InputController;
import it.aren.input.KeyListenerImpl;
import it.aren.input.KeyboardInputController;
import it.aren.model.World;
/**
 * This is an extension of JPanel.
 * Every {@link BaseEntity} is rendered there
 *
 */
public class GamePanel extends JPanel {


    private static final long serialVersionUID = 1L;
    private final World world;
    private final Settings settings;
    private final GraphicController controller;

      /**
     * Initialize the panel.
     * @param world to render
     * @param inputController for listen the input
     */
    public GamePanel(final World world, final InputController inputController) {
        this.world = world;
        this.settings = SettingsLoader.loadSettings();
        this.setPreferredSize(this.settings.getScreenSize());
        this.addKeyListener(new KeyListenerImpl((KeyboardInputController) inputController));
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.requestFocusInWindow();
        controller = new GameGraphicController((Graphics2D) this.getGraphics(), this);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(final Graphics g) {
            final Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                      this.settings.isAntiAliasingOn() ? RenderingHints.VALUE_ANTIALIAS_ON 
                              : RenderingHints.VALUE_ANTIALIAS_OFF);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                      this.settings.isRenderQuality() ? RenderingHints.VALUE_RENDER_QUALITY 
                              : RenderingHints.VALUE_RENDER_SPEED);
            g2.clearRect(0, 0, this.getWidth(), this.getHeight());

        ((GameGraphicController)controller).setG2AndIO(g2, this);
            this.world.getCurrentMap().updateGraphic(controller);
            this.world.getPlayer().updateGraphic(controller);
            if (this.world.getDialog() != null) {
                this.world.getDialog().updateGraphic(controller);
            }
    }

}
