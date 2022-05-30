package it.aren.graphic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import it.aren.input.InputController;
import it.aren.input.KeyListenerImpl;
import it.aren.input.KeyboardInputController;
import it.aren.model.World;
/**
 * This is an extension of JPanel.
 * Every {@link it.aren.model.Entity} is rendered there
 *
 */
public class SwingPanel extends JPanel {


    private static final long serialVersionUID = 1L;
    private final World world;
    private final Texture tex;

      /**
     * Initialize the panel.
     * @param w weight of panel
     * @param h height of panel
     * @param world to render
     * @param inputController for listen the input
     */
    public SwingPanel(final int w, final int h, final World world, final InputController inputController, final Texture texture){
        setSize(w,h);
        this.world = world;
        this.tex = texture;
        addKeyListener(new KeyListenerImpl((KeyboardInputController)inputController));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow(); 
        
    }
    
    /**
     * {@inheritDoc}
     */
    public void paint(final Graphics g){
            final Graphics2D g2 = (Graphics2D) g;
            
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                      RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                      RenderingHints.VALUE_RENDER_QUALITY);
            g2.clearRect(0,0,this.getWidth(),this.getHeight());
        
            final GraphicController controller = new SwingGraphic(g2, this, this.tex);
            this.world.getCurrentMap().updateGraphic(controller);
            this.world.getPlayer().updateGraphic(controller);
            if (this.world.getDialog() != null) {
                this.world.getDialog().updateGraphic(controller);
            }
    }
    
}
