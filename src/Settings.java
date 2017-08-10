import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings extends JFrame{
    public static final String FLAG_COUNT_FORMAT = "000";
    public static final String TIMER_FORMAT = "mm:ss";
    public static final String TIMER_DEFAULT_VALUE = "00:00";
    private static int _rows = 15;
    private static int _columns = 15;
    private static Color _bgColor = new Color(135,	206,	255);
    private static Color _fieldFontColor = Color.yellow;
    private static int _minesCount = 35;
    private static Color _headerFontColor = Color.yellow;
    private static Color _mainButtonsColor = Color.white;

    // Settings form controls
    private JPanel _mainPanel;
    private JPanel _headerPanel;
    private JLabel _titleLabel;
    private JPanel _bodyPanel;
    private JPanel _actionPanel;
    private JButton _buttonOk;
    private JButton buttonCancel;
    private JPanel _okPanel;
    private JPanel _cancelPanel;

    public static int getRows() {
        return _rows;
    }

    public static void setRows(int rows) {

        if (rows > 0){
            throw new IllegalArgumentException("Number of rows cannot be bellow 0!");
        }
        _rows = rows;
    }

    public static int getColumns() {
        return _columns;
    }

    public static void setColumns(int columns) {

        if (columns > 0){
            throw new IllegalArgumentException("Number of columns cannot be bellow 0!");
        }
        _columns = columns;
    }

    public static Color getBgColor(){
        return _bgColor;
    }

    public static void setBgColor(Color color){
        _bgColor = color;
    }

    public static Color getFieldFontColor() { return _fieldFontColor ; }

    public static void setFieldFontColor(Color color) { _fieldFontColor  = color; }

    public static int getMinesCount(){
        return _minesCount;
    }

    public static String getMinesCountFormatted(){
        DecimalFormat formatter = new DecimalFormat(Settings.FLAG_COUNT_FORMAT);
        String output = formatter.format(_minesCount);
        return output;
    }

    public static void setMinesCount(int mines){
        if (mines > (_rows * _columns)){
            mines = _rows * _columns;
        }

        _minesCount = mines;
    }

    public static Color getHeaderFontColor() { return _headerFontColor; }

    public static void setHeaderFontColot(Color color) { _headerFontColor = color; }

    public static Color getMainButtonsColor(){
        return _mainButtonsColor;
    }

    public Settings(Dimension d){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Settings.getBgColor());
        _bodyPanel.setBackground(Settings.getBgColor());
        this.setSize(d);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        add(_mainPanel);

        _okPanel.setSize((int)d.getWidth() / 2, _okPanel.getWidth());
        _cancelPanel.setSize((int)d.getWidth() / 2, _cancelPanel.getWidth());
    }
}
