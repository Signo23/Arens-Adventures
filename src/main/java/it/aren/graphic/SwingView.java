/**
 * 
 */
package it.aren.graphic;

import javax.swing.JFrame;

import it.aren.common.Settings;
import it.aren.graphic.menu.MenuPanel;
import it.aren.input.InputController;
import it.aren.input.KeyListenerImpl;
import it.aren.input.KeyboardInputController;
import it.aren.model.World;
/**
 * This class is the main view of the game using Java Swing.
 * Implements {@link View}
 *
 */
public class SwingView implements View {
    final private JFrame frame;
    final private SwingPanel gamePanel;
    final private MenuPanel menuPanel;

    /**
     * Initialize the view.
     * @param world to render
     * @param controller for listen the input
     * @param settings 
     */
    public SwingView(final World world, final InputController controller, final Settings settings) {
        this.frame = new JFrame("Aren's Adventures");
        this.gamePanel = new SwingPanel(settings, world, controller);
        this.menuPanel = new MenuPanel();
        this.frame.getContentPane().add(this.gamePanel);
        this.frame.addKeyListener(new KeyListenerImpl((KeyboardInputController)controller));
        this.frame.setResizable(false);
        this.frame.setAutoRequestFocus(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);

    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void render() {
        this.frame.repaint();
    }

}
