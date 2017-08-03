import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by Robi on 03/08/2017.
 */
@SuppressWarnings("serial")
public class JPanelGrid extends JPanel {
    private int _rows;
    private int _columns;
    private Color _backgroundColor;
    private Dimension _fieldSize = new Dimension(80, 80);

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
                fields[i][j].setPreferredSize(_fieldSize);
                add(fields[i][j]);
            }
        }
    }

    public static void createAndShowGui() {
        JPanelGrid mainPanel = new JPanelGrid();

        JFrame frame = new JFrame("JPanelGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
