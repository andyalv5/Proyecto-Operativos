package Classes;
import Interfaces.Dashboard;
import java.awt.Color;

import javax.swing.JPanel;
/**
 *
 * @author Andy
 */
public class SetLocationRelativeToDashboard {
    public static void SetLocationRelativeToDashboard(){
        Dashboard ventana = new Dashboard();
        ventana.setLayout(null);
        ventana.setVisible(true);
        JPanel p = new JPanel();
        p.setBackground(Color.getHSBColor(20, 26, 77));
        p.setBounds(1790,500,50,50);
        ventana.add(p);
        ventana.setSize(960, 640);
        ventana.setLocationRelativeTo(p);
    }
}
