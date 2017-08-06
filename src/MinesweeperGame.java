import oracle.jrockit.jfr.JFR;

import javax.swing.*;import java.awt.*;
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

    private Font headerFont = new Font("Curlz MT", Font.BOLD, 20);;

    public MinesweeperGame(){
        lblTimer.setFont(headerFont);
        lblTimer.setForeground(Settings.getHeaderFontColor());
        lblFlagCount.setFont(headerFont);
        lblFlagCount.setForeground(Settings.getHeaderFontColor());
        lblFlagCount.setText(Settings.getMinesCountFormatted());

        setupMainPanel();

        panelHeader.setBackground(Settings.getBgColor());
    }

    public JPanel getMainPanel(){
        return this.mainPanel;
    }

    public JPanel getGamePanel(){
        return this.gamePanel;
    }

    private void setupMainPanel(){
        this.mainPanel.setBackground(Settings.getBgColor());
        _minefieldGrid = new JPanelGrid();
        this.mainPanel.add( _minefieldGrid);
    }
}
