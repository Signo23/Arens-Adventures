/**
 * 
 */
package it.aren.graphic;

import java.awt.Dimension;
import java.awt.Toolkit;

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
        final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        final int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        final int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
        frame.setAutoRequestFocus(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void render() {
        this.frame.repaint();
    }

}
