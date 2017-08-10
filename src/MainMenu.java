import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class MainMenu extends JFrame {
    private JPanel contentPane;
    private JButton _buttonSettings;
    private JButton _buttonStart;
    private JButton _buttonExit;
    private JLabel _titleLabel;
    private JPanel _menuPanel;
    private JPanel _panelHeader;
    private Toolkit _toolkit = Toolkit.getDefaultToolkit();
    private Dimension _screenSize = _toolkit.getScreenSize();
    private Point _center = new Point(_screenSize.width / 2, _screenSize.height / 2);

    public MainMenu() {
        setContentPane(contentPane);
        setLocation(_center);
        getRootPane().setDefaultButton(_buttonStart);
        setupVisual();

        _buttonStart.addActionListener(e -> onStart());
        _buttonSettings.addActionListener(e -> onSettings());
        _buttonExit.addActionListener(e -> onExit());
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

    private void setupVisual(){
        contentPane.setBackground(Settings.getBgColor());
        _menuPanel.setBackground(Settings.getBgColor());
        _titleLabel.setForeground(Settings.getMainTextColor());
        for (int i = 0; i < _menuPanel.getComponentCount(); i++){
            if (_menuPanel.getComponent(i) instanceof JButton){
                JButton btn = (JButton) _menuPanel.getComponent(i);
                btn.setBackground(Settings.getMainButtonsColor());
            }
        }
    }

    private void onStart(){

        int width = Settings.getColumns() > 15 ? 850 : 650;
        int height = Settings.getRows() > 15 ? 1000 : 700;

        MinesweeperGame gameForm = new MinesweeperGame(new Dimension(width, height));
        gameForm.setVisible(true);
        gameForm.startTimer();
    }

    private void onSettings(){
        int width = 300;
        int height = 500;

        Settings settingsForm = new Settings(new Dimension(width, height));
        settingsForm.setVisible(true);

        setupVisual();
    }

    private void onExit() {
        dispose();
    }

}
