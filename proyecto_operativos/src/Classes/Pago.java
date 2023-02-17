/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Hallo
 */
public class Pago extends Thread{
    
    @Override
    public void run(){
        while(Proyecto_operativos.keep){
            
            try {
    //            Duerme un dia para posteriormente hacer el pago
                Thread.sleep(Proyecto_operativos.dia_en_ms);


            } catch (InterruptedException ex) {
                Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
