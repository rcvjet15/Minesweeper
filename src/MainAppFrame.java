import oracle.jrockit.jfr.JFR;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robi on 03/08/2017.
 */
public class MainAppFrame extends JFrame {

    private Color _bgColor = Color.WHITE;
    private Dimension _dSize;

    ArrayList<Component> _frameComponents;

    public MainAppFrame(Dimension d){
        JFrame frame = new JFrame("JPanelGrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(_bgColor);
        _frameComponents = new ArrayList<>();
        _dSize = d;
    }

    public void addComponent(Component component){
        _frameComponents.add(component);
    }

    public void showFrame(){
        for(Component c : _frameComponents){
            this.getContentPane().add(c);
        }

        this.setSize(_dSize);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static JPanelGrid getMinefieldGrid(){
        Frame[] allFrames = Frame.getFrames();

        for (Frame frame : allFrames){
            if (frame instanceof MainAppFrame){
                for (int i = 0; i < frame.getComponentCount(); i++){
                    if (frame.getComponent(i) instanceof JPanelGrid && frame.getComponent(i).getName() == JPanelGrid.GRID_NAME){
                        return (JPanelGrid) frame.getComponent(i);
                    }
                }
            }
        }

        return null;
    }
}
