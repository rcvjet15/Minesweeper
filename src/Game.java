import javax.swing.*;

/**
 * Created by Robi on 03/08/2017.
 */
public class Game extends JFrame {
    public Game(String name){
        JPanelGrid playGround = new JPanelGrid();

        setName(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(playGround);
        pack();
        setVisible(true);
    }


    // On exit close this window and open main menu
    public void onExit(){

    }
}
