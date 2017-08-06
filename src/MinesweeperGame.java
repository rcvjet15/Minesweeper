import oracle.jrockit.jfr.JFR;
import sun.applet.Main;

import javax.swing.*;import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

    public void IncrementFlagCount(){
        DecimalFormat formatter = new DecimalFormat(Settings.FLAG_COUNT_FORMAT);
        int value = Integer.parseInt(lblFlagCount.getText());
        if (value < Settings.getMinesCount()){
            lblFlagCount.setText(formatter.format((value++)));
        }
    }

    public void DecrementFlagCount(){
        DecimalFormat formatter = new DecimalFormat(Settings.FLAG_COUNT_FORMAT);
        int value = Integer.parseInt(lblFlagCount.getText());
        if (value > 0){
            lblFlagCount.setText(formatter.format((value--)));
        }
    }

    public void setupTimer(){
        ActionListener time = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentTime = Integer.parseInt(lblTimer.getText());
                DecimalFormat formater = new DecimalFormat(Settings.TIMER_FORMAT);
                currentTime++;
                lblTimer.setText(formater.format(currentTime));
            }
        };
        _timer = new Timer(1000, time);
    }

    public void startTimer(){
        _timer.start();
    }

    public void setGameOver(){
        _minefieldGrid.showAllFields();
    }

    private void resetGame(){
        _timer.stop();
        lblTimer.setText(Settings.FLAG_COUNT_FORMAT);
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
        lblTimer.setText("000");
        lblFlagCount.setFont(headerFont);
        lblFlagCount.setForeground(Settings.getHeaderFontColor());
        lblFlagCount.setBackground(Color.black);
        lblFlagCount.setText(Settings.getMinesCountFormatted());
    }

    public void setParentFrame(MainAppFrame appFrame){
        _parentFrame = appFrame;
    }
}
