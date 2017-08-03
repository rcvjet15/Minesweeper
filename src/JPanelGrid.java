import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by Robi on 03/08/2017.
 */
public class JPanelGrid extends JPanel {
    private int _rows;
    private int _columns;
    private Color _backgroundColor;

    public JPanelGrid(){
        _rows = Settings.getRows();
        _columns = Settings.getColumns();
        _backgroundColor = Settings.getBackgroundColor();

        setBackground(_backgroundColor);
        setLayout(new GridLayout(_rows, _columns));
//        setBorder(BorderFactory.createEmptyBorder());
        JLabel[][] fields = new JLabel[_rows][_columns];

        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                fields[i][j] = FieldFactory.createInitialField();
                add(fields[i][j]);
            }
        }
    }

}
