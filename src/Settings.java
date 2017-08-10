import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings extends JDialog{
    private static final int BACKGROUND_TARGET = 2;
    private static final int BUTTON_TARGET = 3;

    public static final String FLAG_COUNT_FORMAT = "000";
    public static final String TIMER_FORMAT = "mm:ss";
    public static final String TIMER_DEFAULT_VALUE = "00:00";
    private static int _rows = 15;
    private static int _columns = 15;
    private static Color _bgColor = new Color(135,	206,	255);
    private static Color _mainTextColor = Color.darkGray;
    private static int _minesCount = 35;
    private static Color _headerFontColor = Color.yellow;
    private static Color _mainButtonsColor = Color.white;

    // Settings form controls
    private JPanel _mainPanel;
    private JPanel _headerPanel;
    private JLabel _titleLabel;
    private JPanel _bodyPanel;
    private JPanel _actionPanel;
    private JButton _buttonSave;
    private JButton _buttonCancel;
    private JPanel _okPanel;
    private JPanel _cancelPanel;
    private JLabel _lblRows;
    private JLabel _lblColumns;
    private JLabel _lblMinesCout;
    private JSpinner _rowsSpin;
    private JSpinner _colSpin;
    private JSpinner _mineSpin;
    private JLabel lblGbColor;
    private JPanel _rowPanel;
    private JPanel _colPanel;
    private JPanel _minePanel;
    private JPanel _bgPanel;
    private JPanel _btnPanel;
    private JButton _btnBtnClr;
    private JButton _btnBg;
    private JLabel _lblBgResult;
    private JLabel _lblBtnBgResult;
    private JPanel _lblPanel;
    private JLabel _textColor;
    private JLabel _lblTxtResult;
    private JButton _btnLblClr;
    private JLabel _lbl;

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

    public static Color getMainTextColor() { return _mainTextColor ; }

    public static void setMainTextColor(Color color) { _mainTextColor   = color; }

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
            mines = (_rows * _columns);
        }

        _minesCount = mines;
    }

    public static Color getHeaderFontColor() { return _headerFontColor; }

    public static void setHeaderFontColot(Color color) { _headerFontColor = color; }

    public static Color getMainButtonsColor(){
        return _mainButtonsColor;
    }

    public Settings(Dimension d){
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(d);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        setupVisual();
        add(_mainPanel);

        _buttonSave.addActionListener(e -> onSave());
        _buttonCancel.addActionListener(e -> onCancel());
        _btnBg.addActionListener(e -> onChoose(e));
        _btnBtnClr.addActionListener(e -> onChoose(e));
        _btnLblClr.addActionListener(e -> onChoose(e));
        _rowsSpin.setValue(_rows);
        _colSpin.setValue(_columns);
        _mineSpin.setValue(_minesCount);

        setResizable(false);
    }

    private void onSave() {
        if (wf_check() == false){
            return;
        }
        _bgColor = _lblBgResult.getBackground();
        _mainButtonsColor = _lblBtnBgResult.getBackground();
        _mainTextColor = _lblTxtResult.getBackground();
        _rows = (int)_rowsSpin.getValue();
        _columns = (int)_colSpin.getValue();
        Settings.setMinesCount((int) _mineSpin.getValue());
        dispose();
    }

    private boolean wf_check() {
        if ((int)_rowsSpin.getValue() < 1){
            JOptionPane.showMessageDialog(null, "Rows number must be greater than 0!", "Settings Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if ((int)_colSpin.getValue() < 1){
            JOptionPane.showMessageDialog(null, "Columns number must be greater than 0!", "Settings Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if ((int)_mineSpin.getValue() < 1){
            JOptionPane.showMessageDialog(null, "Mines number must be greater than 0!", "Settings Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void onCancel() {
        dispose();
    }


    private void setupVisual(){
        setBackground(_bgColor);
        _mainPanel.setBackground(_bgColor);
        _bodyPanel.setBackground(_bgColor);
        _buttonSave.setBackground(_mainButtonsColor);
        _buttonCancel.setBackground(_mainButtonsColor);
        _btnBg.setBackground(_mainButtonsColor);
        _btnBtnClr.setBackground(_mainButtonsColor);
        _lblBgResult.setBackground(_bgColor);
        _lblBtnBgResult.setBackground(_mainButtonsColor);
        _titleLabel.setForeground(_mainTextColor);
    }

    void onChoose(ActionEvent e){

        if (e.getSource() == _btnBg){

            Color bgClr = JColorChooser.showDialog(this, "Choose Background Color", _bgColor);
            if (bgClr != null){
                _lblBgResult.setBackground(bgClr);
            }
        }
        else if (e.getSource() == _btnBtnClr){
            Color btnClr = JColorChooser.showDialog(this, "Choose Background Color", _mainButtonsColor);
            if (btnClr != null){
                _lblBtnBgResult.setBackground(btnClr);
            }
        }
        else if (e.getSource() == _btnLblClr){
            Color txtClr = JColorChooser.showDialog(this, "Choose Background Color", _mainTextColor);
            if (txtClr != null){
                _lblTxtResult.setBackground(txtClr);
            }
        }
    }

}
