import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings extends JFrame{
    private static final int BACKGROUND_TARGET = 2;
    private static final int BUTTON_TARGET = 3;

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
    private JButton _buttonCancel;
    private JPanel _okPanel;
    private JPanel _cancelPanel;
    private JLabel _lblRows;
    private JLabel _lblColumns;
    private JLabel _lblMinesCout;
    private JSpinner _rowsSpin;
    private JSpinner _colSpin;
    private JSpinner _mineSPin;
    private JLabel lblGbColor;
    private JPanel _rowPanel;
    private JPanel _colPanel;
    private JPanel _minePanel;
    private JPanel _bgPanel;
    private JPanel _btnPanel;
    private JButton _btnBtnClr;
    private JButton _btnBg;

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
        this.setSize(d);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        setupVisual();
        add(_mainPanel);

        _btnBg.addActionListener(e -> onChoose(BACKGROUND_TARGET));
        _btnBg.addActionListener(e -> onChoose(BUTTON_TARGET));

        setResizable(false);
    }

    private void setupVisual(){
        setBackground(Settings.getBgColor());
        _mainPanel.setBackground(Settings.getBgColor());
        _bodyPanel.setBackground(Settings.getBgColor());
        _buttonOk.setBackground(Settings.getMainButtonsColor());
        _buttonCancel.setBackground(Settings.getMainButtonsColor());
        _rowPanel.setBackground(Settings.getMainButtonsColor());
        _colPanel.setBackground(Settings.getMainButtonsColor());
        _minePanel.setBackground(Settings.getMainButtonsColor());
        _bgPanel.setBackground(Settings.getMainButtonsColor());
        _btnPanel.setBackground(Settings.getMainButtonsColor());
        _btnBg.setBackground(Settings.getMainButtonsColor());
        _btnBtnClr.setBackground(Settings.getMainButtonsColor());
    }

    void onChoose(int target){

        switch (target){
            case BACKGROUND_TARGET:
                Color bgClr = JColorChooser.showDialog(this, "Choose Background Color", _bgColor);
                if (bgClr != null){
                    _bgColor = bgClr;
                }
                break;
            case BUTTON_TARGET:
                Color btnClr = JColorChooser.showDialog(this, "Choose Background Color", _mainButtonsColor);
                if (btnClr != null){
                    _mainButtonsColor = btnClr;
                }
                break;
            default:
                break;
        }
    }

}
