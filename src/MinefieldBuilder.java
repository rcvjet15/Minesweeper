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
    }

    private void createMinesPosition(){
        Random rand = new Random();
        int min = 1; // Minimum random number
        int max = Settings.getRows() * Settings.getColumns(); // Maximum random number

        int r = 0;
        boolean duplicate = false;

        for (int i = 0; i < Settings.getMinesCount(); i++){
            do{
                duplicate = false;
                r = min + rand.nextInt(max);

                for (int j = 0; j < _minesPosition.size(); j++){
                    if (r == _minesPosition.get(j)){
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate = false);
            _minesPosition.add(r);
        }

        Collections.sort(_minesPosition);
    }

    private void createMinefieldNumbers(){
        int fieldNumber = 0;

        for (int i = 0; i < _mineField.length; i++){
            for (int j = 0; j < _mineField[i].length; j++){

            }
        }
    }

    private int getFieldNumber(int row, int col){
        int fieldIndex = row * _mineField[0].length - (_mineField[0].length - col);
        int minesCount = 0;

        // If current element is found in mines position array then this element is mine
        if (isMine(fieldIndex)){
            return MINE_INDICATOR;
        }

        for (int i = 0; i < _minesPosition.size(); i++){
            
        }
    }

    // Check if field is mine
    private boolean isMine(int fieldPos){
        // Loop through mines position array and return true if mine is on position number 'fieldPos'
        for (int i = 0; i < _minesPosition.size(); i++){
            if (_minesPosition.get(i) == fieldPos){
                return true;
            }
        }
        return false;
    }
}
