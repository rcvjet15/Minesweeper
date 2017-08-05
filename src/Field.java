import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

/**
 * Created by Robi on 03/08/2017.
 */
public class Field implements MouseListener{
    private ImageIcon _initialFieldIcon;
    private ImageIcon _ordinaryMineFieldIcon;
    private ImageIcon _dangerMineFieldIcon;
    private ImageIcon _flagFieldIcon;
    private ImageIcon _numberFieldIcon;
    private Dimension _fieldSize;
    private JPanel _fieldPanel;
    private Font _fieldFont;

    JPanel clickedPanel;

    public Field(){
        _initialFieldIcon = new ImageIcon(getClass().getResource("gray.png"));
        _ordinaryMineFieldIcon = new ImageIcon(getClass().getResource("field_initial.jpg"));
        _dangerMineFieldIcon = new ImageIcon();
        _flagFieldIcon = new ImageIcon();
        _fieldSize = new Dimension(3, 3);
        _fieldFont = new Font("Field font", Font.PLAIN, 26);
    }

    public JPanel createInitialField() {
        setupFieldPanel();
        JLabel lbl = new JLabel(_initialFieldIcon, JLabel.CENTER);
        _fieldPanel.add(lbl);
        return _fieldPanel;
    }

    public JLabel createMineField(){
        return new JLabel(_ordinaryMineFieldIcon, JLabel.CENTER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickedPanel = (JPanel) e.getSource();
        JLabel lbl = (JLabel)clickedPanel.getComponent(0);
        _numberFieldIcon = new ImageIcon(new ImageIcon(getClass().getResource("four.png")).getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
        lbl.setIcon(_numberFieldIcon);

//        lbl.setFont(_fieldFont);
//        lbl.setForeground(Settings.getFieldFontColor());
//        lbl.setText("1");
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

    private void setupFieldPanel(){
        _fieldPanel = new JPanel();
        _fieldPanel.setEnabled(true);
        _fieldPanel.setBackground(Color.black);
        _fieldPanel.setPreferredSize(_fieldSize);
        _fieldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        _fieldPanel.setLayout(new BorderLayout());
        _fieldPanel.addMouseListener(this);
    }
}
