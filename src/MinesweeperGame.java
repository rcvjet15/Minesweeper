import javafx.util.converter.LocalTimeStringConverter;
import oracle.jrockit.jfr.JFR;
import sun.applet.Main;

import javax.swing.*;import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * Created by Robi on 06/08/2017.
 */
public class MinesweeperGame {
    private JPanel mainPanel;
    private JPanel panelHeader;
    private JLabel lblTimer;
    private JButton btnReset;
    private JPanel gamePanel;
    private JLabel lblFlagCount;
    private JPanelGrid _minefieldGrid;
    private Timer _timer;
    private MainAppFrame _parentFrame;

    private Font headerFont = new Font("Curlz MT", Font.BOLD, 20);;

    public MinesweeperGame(){
        setPanelHeader();
        setupMainPanel();

        setupTimer();

        btnReset.addActionListener(e -> resetGame());
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public void incrementFlagCount(){
        DecimalFormat formatter = new DecimalFormat(Settings.FLAG_COUNT_FORMAT);
        int value = Integer.parseInt(lblFlagCount.getText());
        if (value <= Settings.getMinesCount()){
            lblFlagCount.setText(formatter.format((++value)));
        }
    }

    public void decrementFlagCount(){
        DecimalFormat formatter = new DecimalFormat(Settings.FLAG_COUNT_FORMAT);
        int value = Integer.parseInt(lblFlagCount.getText());
        if (value > 0){
            lblFlagCount.setText(formatter.format((--value)));
        }
    }

    public int getFlagCount(){
        return Integer.parseInt(lblFlagCount.getText());
    }

    public void setupTimer(){
        ActionListener time = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat f = new SimpleDateFormat(Settings.TIMER_FORMAT);

                try{
                    Date dateValue = f.parse(lblTimer.getText());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dateValue);
                    cal.add(Calendar.SECOND, 1);
                    String newTime = f.format(cal.getTime());
                    lblTimer.setText(newTime);
                }catch (java.text.ParseException exc){
                    exc.printStackTrace();
                }
            }
        };
        _timer = new Timer(1000, time);
    }

    public void startTimer(){
        _timer.start();
    }

    // Stop timer, show all fields and show eng message based on 'success' parameter
    public void setGameOver(boolean success){
        _timer.stop();
        _minefieldGrid.showAllFields();

        if (success){
            JOptionPane.showMessageDialog(null, "Game Won!!!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Game Lost!", "Fail", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Check if remaining closed fields are mines
    public boolean isGameWon(){
        if (_minefieldGrid.getNumberOfFields( false) == Settings.getMinesCount()){
            return true;
        }
        return false;
    }

    public void setParentFrame(MainAppFrame appFrame){
        _parentFrame = appFrame;
    }

    // Reveal empty fields by using Flood-fill algorithm.
    public void revealEmptyNeighboursFields(Field field, int targetNum, int replacementNum){
        // This method will take minefield matrix that was used in creating _minefieldGrid matrix whose elements are numbers.
        // Empty elements have value 0. Elements that will be revealed will get new value 'replacementNum'.
        if (field.getFieldRevealed()){
            return;
        }
        else if (field.getFieldFlagged()){
            return;
        }


        int[][] minefieldMatrix = _minefieldGrid.getMinefield();

        ArrayList<Field> queue = new ArrayList<Field>();
        queue.add(field);

        for(Field F : queue){
            Field fWest = F;
            Field fEast = F;

            ArrayList<Field> betweenEastWest = new ArrayList<Field>();
            // Search west
            int row = fWest.getRow();

            for (int c = fWest.getColumn(); c < minefieldMatrix[row].length; c++){
                if (minefieldMatrix[row][c] == targetNum){
                    betweenEastWest.add(_minefieldGrid.getFieldByPosition(row, c));
                }
                else{
                    break;
                }
            }

            // Search east
            row = fEast.getRow();

            for (int c = fEast.getColumn(); c >= 0; c--){
                if (minefieldMatrix[row][c] == targetNum){
                    betweenEastWest.add(_minefieldGrid.getFieldByPosition(row, c));
                }
                else{
                    break;
                }
            }

            for (Field f : betweenEastWest){
                minefieldMatrix[f.getRow()][f.getColumn()] = replacementNum;
                _minefieldGrid.getFieldByPosition(f.getRow(), f.getColumn()).setFieldRevealed(true);

                int column = f.getColumn();

                // Search empty north fields and add them tu queue
                for (int r = f.getRow(); r >= 0; r--){
                    if (minefieldMatrix[r][column] == targetNum){
                        queue.add(_minefieldGrid.getFieldByPosition(r, column));
                    }
                }

                // Search empty south fields and add them tu queue
                for (int r = f.getRow(); r < minefieldMatrix.length; r++){
                    if (minefieldMatrix[r][column] == targetNum){
                        queue.add(_minefieldGrid.getFieldByPosition(r, column));
                    }
                }
            }
        }
    }

    private void resetGame(){
        _timer.stop();
        lblTimer.setText(Settings.TIMER_DEFAULT_VALUE);
        lblFlagCount.setText(Settings.getMinesCountFormatted());

//       mainPanel.removeAll();
//       _parentFrame.removeAll();
//
    }

    private void setupMainPanel(){
        this.mainPanel.setBackground(Settings.getBgColor());
        _minefieldGrid = new JPanelGrid();
        this.mainPanel.add( _minefieldGrid);
    }

    private void setPanelHeader(){
        panelHeader.setBackground(Settings.getBgColor());
        lblTimer.setFont(headerFont);
        lblTimer.setForeground(Settings.getHeaderFontColor());
        lblTimer.setBackground(Color.black);
        lblTimer.setText(Settings.TIMER_DEFAULT_VALUE);

        lblFlagCount.setFont(headerFont);
        lblFlagCount.setForeground(Settings.getHeaderFontColor());
        lblFlagCount.setBackground(Color.black);
        lblFlagCount.setText(Settings.getMinesCountFormatted());
    }
}
