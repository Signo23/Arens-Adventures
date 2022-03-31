package it.aren.graphic;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class SwingPanel extends JPanel {


    private static final long serialVersionUID = 1L;

    public SwingPanel(final int w, final int h){
        setSize(w,h);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        requestFocusInWindow(); 
        
    }
    
    public void paint(final Graphics g){
            final Graphics2D g2 = (Graphics2D) g;
            
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                      RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                      RenderingHints.VALUE_RENDER_QUALITY);
            g2.clearRect(0,0,this.getWidth(),this.getHeight());
        
            /* TODO graphic and input */
    }
    
}
