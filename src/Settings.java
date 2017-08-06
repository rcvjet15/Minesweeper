import java.awt.*;
import java.text.DecimalFormat;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings {
    private static int _rows = 25;
    private static int _columns = 25;
    private static Color _mainBgColor = Color.black;
    private static Color _bgColor = new Color(255, 255, 255);
    private static Color _fieldFontColor = Color.yellow;
    private static int _minesCount = (_rows * _columns) / 10;
    private static Color _headerFontColor = Color.yellow;


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

    public static Color getMainBgColor(){
        return _mainBgColor;
    }

    public static void setMainBgColor(Color color){
        _mainBgColor = color;
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
        DecimalFormat formatter = new DecimalFormat("0000");
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
}
