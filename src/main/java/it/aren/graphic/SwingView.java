/**
 * 
 */
package it.aren.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import it.aren.common.Settings;
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
    
    /**
     * Initialize the view.
     * @param world to render
     * @param controller for listen the input
     * @param settings 
     */
    public SwingView(final World world, final InputController controller, final Settings settings) {
        this.frame = new JFrame("Aren's Adventures");
        //this.frame.getContentPane().add(new SwingPanel(512, 384, world, controller, new Texture()));
        this.gamePanel = new SwingPanel(512, 384, world, controller, new Texture());
        this.frame.getContentPane().add(this.gamePanel);
        this.frame.addKeyListener(new KeyListenerImpl((KeyboardInputController)controller));
        this.frame.setResizable(false);
        final Dimension userScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((userScreenDimension.getWidth() - frame.getWidth()) / 2);
        final int y = (int) ((userScreenDimension.getHeight() - frame.getHeight()) / 2);
        this.frame.setLocation(x, y);
        this.frame.setAutoRequestFocus(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.pack();

    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void render() {
        this.frame.repaint();
    }

}
