import javax.swing.*;

/**
 * Created by Robi on 03/08/2017.
 */
public class Game extends JFrame {
    public Game(){
        JPanelGrid playGround = new JPanelGrid();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(playGround);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    // On exit close this window and open main menu
    public void onExit(){

    }
}
