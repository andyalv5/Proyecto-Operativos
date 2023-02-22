/*
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
public class VigilandoJose extends Thread{
    
    int tiempo;
    
    public VigilandoJose(int tiempo){
        this.tiempo = tiempo;
    }
    
    @Override
    public void run(){
        try {
            Thread.sleep(tiempo);
            Director.vigila_jose = false;
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(VigilandoJose.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
