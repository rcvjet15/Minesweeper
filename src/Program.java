import javax.swing.*;
import java.awt.*;

public class Program {

    private static void StartApp(){
        MainMenu dialog = new MainMenu();
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void main(String[] args) {

        StartApp();

        // JPanelGrid.createAndShowGui();
    }
}