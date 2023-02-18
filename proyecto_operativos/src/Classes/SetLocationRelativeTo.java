/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import Interfaces.Dashboard1;
import java.awt.Color;

import javax.swing.JPanel;
/**
 *
 * @author Andy
 */
public class SetLocationRelativeTo {
    public static void SetLocationRelativeTo(){
        Dashboard1 ventana = new Dashboard1();
        ventana.setLayout(null);
        ventana.setVisible(true);
        JPanel p = new JPanel();
        p.setBackground(Color.getHSBColor(20, 26, 77));
        p.setBounds(400,500,50,50);
        ventana.add(p);
        ventana.setSize(960, 640);
        ventana.setLocationRelativeTo(p);
    }
}
