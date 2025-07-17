import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CreateUI 
{
    public static void initUI()
    {
        JFrame window = new JFrame("My App");
        window.setSize(560, 315);
        window.setAutoRequestFocus(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.LIGHT_GRAY);
        window.setVisible(true);
    }

    
}
