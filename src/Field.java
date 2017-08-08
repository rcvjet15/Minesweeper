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
    public static enum FieldType { Mine, MineDanger, Empty, Flag, One, Two, Three, Four, Five, Six, Seven, Eight, Nine };
    protected ImageIcon initialFieldIcon;
    protected ImageIcon revealedFieldIcon;
    private Dimension _fieldSize;
    private Font _fieldFont;
    private FieldType _type;
    private boolean _fieldRevealed;
    private boolean _fieldFlagged;
    private int _row;
    private int _column;

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

    public boolean getFieldFlagged(){
        return _fieldFlagged;
    }

    public static Field createInitialField(int row, int column) {
        Field f = new Field();
        f._row = row;
        f._column = column;

        JLabel lbl = new JLabel(f.initialFieldIcon, JLabel.CENTER);
        f.add(lbl);
        return f;
    }

    public void revealField(){
        if (_fieldRevealed == true){
            return;
        }

        JLabel lbl = (JLabel)this.getComponent(0);
        revealedFieldIcon = getFieldIconByType(lbl);
        lbl.setIcon(revealedFieldIcon);
        _fieldRevealed = true;
    }

    public int getRow(){
        return _row;
    }

    public int getColumn(){
        return _column;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (_fieldRevealed){
            return;
        }
        else if(SwingUtilities.isLeftMouseButton(e)){
            processLeftClick();
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            processRightClick();
        }
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

    private void processLeftClick(){
        MinesweeperGame gameForm = getMinesweeperGameFrame();

        if (_fieldFlagged){
            return;
        }
        else if(_type == FieldType.Mine && _fieldRevealed == false){
            _type = FieldType.MineDanger;
            revealField();
            gameForm.setGameOver(false);
            return;
        }
        else if(_type == FieldType.Empty){
            // TODO: reveal all nearby empty fields
            gameForm.revealEmptyNeighboursFields(this, 0, -10);
        }
        else{
            revealField();
        }

        if (gameForm.isGameWon()){
            gameForm.setGameOver(true);
        }
    }

    private void processRightClick(){
        MinesweeperGame gameForm = getMinesweeperGameFrame();
        JLabel lbl = (JLabel)this.getComponent(0);

        if (_fieldFlagged){
            _fieldFlagged = false;
            lbl.setIcon(initialFieldIcon);
            gameForm.incrementFlagCount();
        }
        else{
            if (gameForm.getFlagCount() == 0){
                JOptionPane.showMessageDialog(null, "All flags are used!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else{
                _fieldFlagged = true;
                ImageIcon flagIcon = createFieldFlagIcon(lbl);
                lbl.setIcon(flagIcon);
                gameForm.decrementFlagCount();
            }
        }
    }

    private MinesweeperGame getMinesweeperGameFrame(){
        Component parent = this.getParent();

        while(!(parent instanceof MinesweeperGame)){
            parent = parent.getParent();
        }
        return (MinesweeperGame) parent;
    }

    private ImageIcon createFieldFlagIcon(JLabel lbl){
        return new ImageIcon(new ImageIcon(getClass().getResource("flag.png")).getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
    }

    private ImageIcon getFieldIconByType(JLabel lblContainer){
        String iconName = null;

        switch (_type){
            case Mine:
                iconName = "mine.jpg";
                break;
            case MineDanger:
                iconName = "mine_danger.jpg";
                break;
            case Empty:
                iconName = "white.png";
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
