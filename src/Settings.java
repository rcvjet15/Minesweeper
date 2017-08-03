import java.awt.*;

/**
 * Created by Robi on 03/08/2017.
 */
public class Settings {
    private static int _rows = 9;
    private static int _columns = 9;
    private static Color _backgroundColor = Color.black;

    public Settings()
    {

    }

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

    public static Color getBackgroundColor(){
        return _backgroundColor;
    }

    public static void setBackgroundColor(Color color){
        _backgroundColor = color;
    }
}
