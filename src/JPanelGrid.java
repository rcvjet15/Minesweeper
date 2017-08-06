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
    private MinefieldBuilder _builder;
    private int[][] _minefield;

    public JPanelGrid(){
        _rows = Settings.getRows();
        _columns = Settings.getColumns();
        _backgroundColor = Settings.getBgColor();
        _field = new Field();

        setBackground(_backgroundColor);
        setLayout(new GridLayout(_rows, _columns));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

        _builder = new MinefieldBuilder();
        _builder.createMinefield();

        _minefield = _builder.getMinefield();

        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                Field field = Field.createInitialField();
                field.setName(i + j + " field");

                field.setFieldType(getFieldTypeEnum(_minefield[i][j]));
                add(field);
            }
        }
    }

    private Field.FieldType getFieldTypeEnum(int minefieldNum){
        Field.FieldType type = null;
        switch (minefieldNum){
            case MinefieldBuilder.MINE_INDICATOR:
                return Field.FieldType.Mine;
            case 0:
                return Field.FieldType.Empty;
            case 1:
                return Field.FieldType.One;
            case 2:
                return Field.FieldType.Two;
            case 3:
                return Field.FieldType.Three;
            case 4:
                return Field.FieldType.Four;
            case 5:
                return Field.FieldType.Five;
            case 6:
                return Field.FieldType.Six;
            case 7:
                return Field.FieldType.Seven;
            case 8:
                return Field.FieldType.Eight;
        }

        return null;
    }
}


