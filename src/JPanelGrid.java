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

                JPanel field = _field.createInitialField();
                add(field);
                field.setName(i + j + " field");
            }
        }
    }
}


