import javafx.scene.control.Alert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class MainMenu extends JFrame {
    private JPanel contentPane;
    private JButton buttonStart;
    private JButton buttonAbout;
    private JButton buttonSettings;
    private JLabel labelAppTitle;
    private JButton buttonExit;
    private JPanel menuPanel;
    private MainAppFrame _appFrame;
    private Toolkit _toolkit = Toolkit.getDefaultToolkit();
    private Dimension _screenSize = _toolkit.getScreenSize();
    private Point _center = new Point(_screenSize.width / 2, _screenSize.height / 2);
    Dimension _mainAppFrameDimension;

    public MainMenu() {
        setContentPane(contentPane);
        setLocation(_center);
        contentPane.setBackground(Settings.getBgColor());
        menuPanel.setBackground(Settings.getBgColor());
        getRootPane().setDefaultButton(buttonStart);

        buttonStart.addActionListener(e -> onStart());
        buttonSettings.addActionListener(e -> onSettings());
        buttonAbout.addActionListener(e -> onAbout());
        buttonExit.addActionListener(e -> onExit());
//
        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });
//
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onStart(){

        int width = Settings.getColumns() > 15 ? 850 : 650;
        int height = Settings.getRows() > 15 ? 1000 : 700;

        _mainAppFrameDimension = new Dimension(width, height);
        _appFrame = new MainAppFrame(_mainAppFrameDimension);

        MinesweeperGame gameForm = new MinesweeperGame();
        JPanel p = gameForm.getMainPanel();

        _appFrame.addComponent(p);
        _appFrame.setSize(_mainAppFrameDimension);
        _appFrame.showFrame();
        _appFrame.setFocusable(true);
    }

    private void onSettings(){

    }

    private void onAbout(){

    }

    private void onExit() {
        dispose();
    }
}
