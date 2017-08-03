import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Robi on 03/08/2017.
 */
public class Field implements MouseListener{
    ImageIcon _initialFieldIcon = new ImageIcon(getClass().getResource("gray.png"));
    ImageIcon _ordinaryMineFieldIcon = new ImageIcon(getClass().getResource("field_initial.jpg"));
    ImageIcon _dangerMineFieldIcon = new ImageIcon();
    ImageIcon _flagFieldIcon = new ImageIcon();
    JPanel clickedPanel;

    public JLabel createInitialField(){
        return new JLabel(_initialFieldIcon, JLabel.CENTER);
    }

    public JLabel createMineField(){
        return new JLabel(_ordinaryMineFieldIcon, JLabel.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickedPanel = (JPanel) e.getSource();
        JLabel lbl = (JLabel)clickedPanel.getComponent(0);
        lbl.setIcon(_ordinaryMineFieldIcon);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
