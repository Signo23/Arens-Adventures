/**
 * 
 */
package it.aren.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import it.aren.input.InputController;
import it.aren.model.World;
/**
 * This class is the main view of the game using Java Swing.
 * Implements {@link View}
 *
 */
public class SwingView implements View {
    final private JFrame frame;
    
    /**
     * Initialize the view.
     * @param world to render
     * @param controller for listen the input
     */
    public SwingView(final World world, final InputController controller) {
        this.frame = new JFrame("Aren's Adventures");
        frame.setSize(512, 384);
        frame.getContentPane().add(new SwingPanel(512, 384, world, controller, new Texture()));
        frame.setResizable(false);
        final Dimension userScreenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((userScreenDimension.getWidth() - frame.getWidth()) / 2);
        final int y = (int) ((userScreenDimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setAutoRequestFocus(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void render() {
        this.frame.repaint();
    }

}
