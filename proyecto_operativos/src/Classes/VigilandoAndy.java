+/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hallo
 */
public class VigilandoAndy extends Thread{
    
    int tiempo;
    
    public VigilandoAndy(int tiempo){
        this.tiempo = tiempo;
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(tiempo);
            Director.vigila_andy = false;
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(VigilandoAndy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}