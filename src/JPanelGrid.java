import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Set;

@SuppressWarnings("serial")
public class JPanelGrid extends JPanel {
    public static final String GRID_NAME = "Minefield";
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
        _backgroundColor = Color.black;
        _field = new Field();

        setBackground(_backgroundColor);
        setLayout(new GridLayout(_rows, _columns));
        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setName(GRID_NAME);

        _builder = new MinefieldBuilder();
        _builder.createMinefield();

        _minefield = _builder.getMinefield();

        for (int i = 0; i < _rows; i++){
            for (int j = 0; j < _columns; j++){
                Field field = Field.createInitialField(i, j);
                field.setName(i + j + " field");

                field.setFieldType(getFieldTypeEnum(_minefield[i][j]));
                add(field);
            }
        }
    }

    public int[][] getMinefield(){
        return _minefield;
    }

    public void setMinefield(int[][] minefield){
        _minefield = minefield;
    }

    public Field getFieldByPosition(int row, int col){
        Field f;
        for (int i = 0; i < this.getComponentCount(); i++){
            if (this.getComponent(i)  instanceof Field ){
                f = (Field) this.getComponent(i);
                if (f.getRow() == row && f.getColumn() == col)
                return f;
            }
        }
        return null;
    }

    public void showAllFields(){
        Field f;
        for (int i = 0; i < this.getComponentCount(); i++){
            if (this.getComponent(i)  instanceof Field ){
                f = (Field) this.getComponent(i);
                f.revealField();
            }
        }
    }

    // Get number of (not)revealed fields based on 'revealed' parameter value
    public int getNumberOfFields(boolean revealed){
        int fieldCount = 0;
        Field tmpField;
        for (int i = 0; i < this.getComponentCount(); i++){
            if (this.getComponent(i) instanceof Field){
                tmpField = (Field)this.getComponent(i);
                if (tmpField.getFieldRevealed() == revealed){
                    fieldCount++;
                }
            }
        }
        return fieldCount;
    }

    // Show matrix in console
    public void outputMinefield(){
        for(int i = 0; i < _minefield.length; i++){
            for(int j = 0; j < _minefield[i].length; j++){
                System.out.print(_minefield[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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


