import java.awt.*;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings {
    private static int _rows = 30;
    private static int _columns = 25;
    private static Color _mainBgColor = Color.black;
    private static Color _bgColor = Color.black;
    private static Color _fieldFontColor = Color.yellow;

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
}