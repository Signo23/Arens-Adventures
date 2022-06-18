package it.aren.graphic;

import javax.swing.JFrame;

import it.aren.common.ApplicationState;
import it.aren.common.BaseObjectEnum;
import it.aren.common.Settings;
import it.aren.graphic.game.GamePanel;
import it.aren.graphic.menu.MenuPanel;
import it.aren.graphic.menu.MenuSettingsPanel;
import it.aren.input.InputController;
import it.aren.input.KeyListenerImpl;
import it.aren.input.KeyboardInputController;
import it.aren.input.MenuInputController;
import it.aren.model.World;
/**
 * This class is the main view of the game using Java Swing.
 * Implements {@link BaseView}
 *
 */
public class SwingView implements BaseView {
    private final JFrame frame;
    private final GamePanel gamePanel;
    private final MenuPanel menuPanel;
    private final MenuSettingsPanel settingsPanel;
    private ApplicationState state;

    /**
     * Initialize the view.
     * @param world to render
     * @param controller for listen the input
     * @param menuController the menu's controller
     * @param settings the settings to use
     */
    public SwingView(final World world, final InputController controller, final MenuInputController menuController, final Settings settings) {
        this.frame = new JFrame("Aren's Adventures");
        this.gamePanel = new GamePanel(settings, world, controller);
        this.menuPanel = new MenuPanel(menuController);
        this.settingsPanel = new MenuSettingsPanel(menuController);
        this.state = ApplicationState.BOOT;
        this.frame.setIconImage(BaseObjectEnum.ICON.getTexture());
        this.frame.getContentPane().add(this.menuPanel);
        this.frame.addKeyListener(new KeyListenerImpl((KeyboardInputController) controller));
        this.frame.setResizable(false);
        this.frame.setAutoRequestFocus(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void render() {
        this.frame.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeState(final ApplicationState newState) {
        if (this.state != newState) {
            switch (newState) {
            case MENU:
                this.frame.getContentPane().removeAll();
                this.frame.getContentPane().add(this.menuPanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.state = newState;
                break;
            case MENU_SETTINGS:
                this.frame.getContentPane().removeAll();
                this.frame.getContentPane().add(this.settingsPanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.state = newState;
                break;
            case GAME:
                this.frame.getContentPane().removeAll();
                this.frame.getContentPane().add(this.gamePanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.state = newState;
                break;
            default:
                break;
            }
        }
    }
}
