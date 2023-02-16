/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_1;

/**
 *
 * @author Hallo
 */
public class Pago extends Thread{
    
    @Override
    public void run(){
        try {
//            Duerme un dia para posteriormente hacer el pago
            Thread.sleep(Proyecto_1.dia_en_ms);
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
