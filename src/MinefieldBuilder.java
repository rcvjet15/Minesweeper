import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Robi on 05/08/2017.
 */
public class MinefieldBuilder {
    private int[][] _mineField;
    private ArrayList<Integer> _minesPosition;
    public static final int MINE_INDICATOR = -1; // Elements that -1 are mines

    public MinefieldBuilder(){
        _mineField = new int[Settings.getRows()][Settings.getColumns()];
        _minesPosition = new ArrayList<Integer>(Settings.getMinesCount());
    }

    public int[][] getMinefield(){
        return _mineField;
    }

    private void createMinefield(){
        createMinesPosition();
        createMinefieldNumbers();
    }

    private void createMinesPosition(){
        Random rand = new Random();
        int max = Settings.getRows() * Settings.getColumns(); // Maximum random number

        int r = 0;
        boolean duplicate = false;

        for (int i = 0; i < Settings.getMinesCount(); i++){
            do{
                duplicate = false;
                r = rand.nextInt(max);

                for (int j = 0; j < _minesPosition.size(); j++){
                    if (r == _minesPosition.get(j)){
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate == true);
            _minesPosition.add(r);
        }

        Collections.sort(_minesPosition);
    }

    private void createMinefieldNumbers(){

        for (int i = 0; i < _mineField.length; i++){
            for (int j = 0; j < _mineField[i].length; j++){
                _mineField[i][j] = getFieldNumber(i, j);
            }
        }
    }

    private int getFieldNumber(int row, int col){
        int minesCount = 0;

        // If current element is found in mines position array then this element is mine
        if (isMine(row, col)){
            return MINE_INDICATOR;
        }

        int fieldIndex = row * _mineField[0].length - (_mineField[0].length - col);

        // Get surrounding elements
        int previousRow = row > 0 ? row - 1 : 0;
        int nextRow = row < _mineField.length - 1 ? row + 1 : _mineField.length - 1;

        int previousCol = col > 0 ? col - 1 : 0;
        int nextCol = col < _mineField[0].length - 1 ? col + 1 : _mineField[0].length - 1;

        // Loop through elements that surround current field
        for (int i = previousRow; i < nextRow; i++){
            for (int j = previousCol; j < nextCol; j++){
                if (isMine(i, j)){
                    minesCount++;
                }
            }
        }

        return minesCount;
    }

    // Check if field is mine
    private boolean isMine(int row, int col){
        // Loop through mines position array and return true if mine is on position number 'fieldPos'
        for (int i = 0; i < _minesPosition.size(); i++){
            if (_minesPosition.get(i) == _mineField[row][col]){
                return true;
            }
        }
        return false;
    }
}
