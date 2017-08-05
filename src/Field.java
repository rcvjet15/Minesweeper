import sun.swing.SwingAccessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

/**
 * Created by Robi on 03/08/2017.
 */
public class Field extends JPanel implements MouseListener{
    public static enum FieldType { Mine, Flag, One, Two, Three, Four, Five, Six, Seven, Eight, Nine };
    protected ImageIcon initialFieldIcon;
    protected ImageIcon revealedFieldIcon;
    private Dimension _fieldSize;
    private Font _fieldFont;
    private FieldType _type;
    private boolean _fieldRevealed;
    private boolean _fieldFlagged;

    protected Field(){
        initialFieldIcon = new ImageIcon(getClass().getResource("gray.png"));
        _fieldSize = new Dimension(3, 3);
        _fieldRevealed = false;

        setEnabled(true);
        setBackground(Color.black);
        setPreferredSize(_fieldSize);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        addMouseListener(this);
    }

    public FieldType getFieldType(){
        return _type;
    }

    public void setFieldType(FieldType type){
        _type = type;
    }

    public boolean getFieldRevealed(){
        return _fieldRevealed;
    }

    public void setFieldRevealed(boolean revealed){
        _fieldRevealed = revealed;
    }

    public boolean getFieldFlagged(){
        return _fieldFlagged;
    }

    public void setFieldFlagged(boolean flagged){
        _fieldFlagged = flagged;
    }

    public static Field createInitialField() {
        Field f = new Field();
        JLabel lbl = new JLabel(f.initialFieldIcon, JLabel.CENTER);
        f.add(lbl);
        return f;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
//        this = (Field) e.getSource();
        JLabel lbl = (JLabel)this.getComponent(0);
        revealedFieldIcon = getFieldIconByType(lbl);
        lbl.setIcon(revealedFieldIcon);
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

    private ImageIcon getFieldIconByType(JLabel lblContainer){
        String iconName = null;

        switch (_type){
            case Mine:
                iconName = "mine.jpg";
                break;
            case Flag:
                iconName = "flag.jpg";
                break;
            case One:
                iconName = "one.png";
                break;
            case Two:
                iconName = "two.png";
                break;
            case Three:
                iconName = "three.png";
                break;
            case Four:
                iconName = "four.png";
                break;
            case Five:
                iconName = "five.png";
                break;
            case Six:
                iconName = "six.png";
                break;
            case Seven:
                iconName = "seven.png";
                break;
            case Eight:
                iconName = "eight.png";
                break;
            case Nine:
                iconName = "nine.png";
                break;
            default:
                break;
        }

        return new ImageIcon(new ImageIcon(getClass().getResource(iconName)).getImage().getScaledInstance(lblContainer.getWidth(), lblContainer.getHeight(), Image.SCALE_SMOOTH));
    }
}
