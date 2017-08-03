import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robi on 03/08/2017.
 */
public class MainAppFrame extends JFrame {

    private Color _bgColor = Color.WHITE;

    ArrayList<Component> _frameComponents;

    public MainAppFrame(){
        JFrame frame = new JFrame("JPanelGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        setBackground(_bgColor);
    }

    public void AddComponent(Component component){
        _frameComponents.add(component);
    }

    public void showFrame(){
        for(Component c : _frameComponents){
            this.getContentPane().add(c);
        }
        this.setVisible(true);
    }
}
