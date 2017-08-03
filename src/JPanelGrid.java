import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Set;

/**
 * Created by Robi on 03/08/2017.
 */
@SuppressWarnings("serial")
public class JPanelGrid extends JPanel {
    private static final int GAP = 3;
    private int _rows;
    private int _columns;
    private Color _backgroundColor;
    private Dimension _fieldSize = new Dimension(3, 3);
    private Field _field;

    public JPanelGrid(){
        _rows = Settings.getRows();
        _columns = Settings.getColumns();
        _backgroundColor = Settings.getBgColor();
        _field = new Field();

        setBackground(_backgroundColor);
        setLayout(new GridLayout(_rows, _columns));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                JPanel panel = new JPanel();
                panel.setEnabled(true);
                panel.setBackground(Color.yellow);
                panel.setPreferredSize(_fieldSize);
                panel.setBorder(BorderFactory.createLineBorder(Color.black));
                panel.setLayout(new BorderLayout());

                panel.setName(i + j + " Panel");

                JLabel lbl = _field.createInitialField();
                panel.add(lbl);
                panel.addMouseListener(_field);
                add(panel);
            }
        }
    }
}


