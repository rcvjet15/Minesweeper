import javax.swing.*;

/**
 * Created by Robi on 03/08/2017.
 */
public class FieldFactory {
    static ImageIcon _initialFieldIcon = new ImageIcon("/content/field_initial.jpg");
    static ImageIcon _ordinaryMineFieldIcon = new ImageIcon();
    static ImageIcon _dangerMineFieldIcon = new ImageIcon();
    static ImageIcon _flagFieldIcon = new ImageIcon();

    public static JLabel createInitialField(){
        return new JLabel(_initialFieldIcon);
    }
}
