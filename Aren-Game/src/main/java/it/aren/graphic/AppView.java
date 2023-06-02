package it.aren.graphic;

import javax.swing.JFrame;

import it.aren.Observer;
import it.aren.graphic.game.GamePanel;
import it.aren.graphic.menu.MenuPanel;
import it.aren.graphic.menu.MenuSettingsPanel;
import it.aren.common.ApplicationState;
import it.aren.common.BaseObjectEnum;
import it.aren.model.event.EventObservable;
import it.aren.model.input.InputController;
import it.aren.model.input.KeyListenerImpl;
import it.aren.model.input.KeyboardInputController;
import it.aren.model.input.MenuInputController;
import it.aren.model.World;

/**
 * This class is the main view of the game using Java Swing.
 * Implements {@link BaseView}
 *
 */
public class AppView implements Observer {
    private final JFrame frame;
    private final GamePanel gamePanel;
    private final MenuPanel menuPanel;
    private final MenuSettingsPanel settingsPanel;
    private final EventObservable eventObservable;
    private ApplicationState lastState;


    /**
     * Initialize the view.
     *
     * @param world           to render
     * @param controller      the game's input controller
     * @param menuController  the menu's input controller
     * @param eventObservable
     */
    public AppView(final World world, final InputController controller, final MenuInputController menuController,
                   final EventObservable eventObservable) {
        this.eventObservable = eventObservable;
        this.frame = new JFrame("Aren's Adventures");
        this.gamePanel = new GamePanel(world, controller);
        this.menuPanel = new MenuPanel(menuController);
        this.settingsPanel = new MenuSettingsPanel(menuController);
        this.lastState = ApplicationState.BOOT;
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
    public void update() {
        changeState();
        frame.repaint();
    }

    public void changeState() {
        if (this.lastState != eventObservable.getState()) {
            switch (eventObservable.getState()) {
            case MENU:
                this.frame.getContentPane().removeAll();
                this.frame.getContentPane().add(this.menuPanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.lastState = eventObservable.getState();
                break;
            case MENU_SETTINGS:
                this.frame.getContentPane().removeAll();
                this.settingsPanel.initSettingsControll();
                this.frame.getContentPane().add(this.settingsPanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.lastState = eventObservable.getState();
                break;
            case GAME:
                this.frame.getContentPane().removeAll();
                this.frame.getContentPane().add(this.gamePanel);
                this.frame.requestFocusInWindow();
                this.frame.pack();
                this.frame.setVisible(true);
                this.lastState = eventObservable.getState();
                break;
            default:
                break;
            }
        }
    }
}
