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
    private static Object _childForm;

    ArrayList<Component> _frameComponents;

    public MainAppFrame(Dimension d){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(_bgColor);
        this.setSize(d);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
    }

    public static Object getChildForm(){
        return _childForm;
    }

    public static void setChildForm(Object form){
        _childForm = form;
    }
}
