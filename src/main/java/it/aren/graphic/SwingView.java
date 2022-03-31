/**
 * 
 */
package it.aren.graphic;

import javax.swing.JFrame;

/**
 * @author lory4
 *
 */
public class SwingView implements View {
    final private JFrame frame;
    
    public SwingView() {
        frame = new JFrame("Aren's Adventure");
        frame.setSize(512, 512);
        frame.getContentPane().add(new SwingPanel(512, 512));
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void render() {
        frame.repaint();
    }

}
