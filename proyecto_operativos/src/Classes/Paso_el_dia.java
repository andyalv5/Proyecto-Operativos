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
public class Paso_el_dia extends Thread{
    
    @Override
    public void run(){
        
        while(Proyecto_operativos.keep){
            try {
                                
                Thread.sleep(Proyecto_operativos.dia_en_ms);
                
//                Se le indica al director que ya pasó un día
                Director.Director_nuevo_dia_andy = true;
                Director.Director_nuevo_dia_jose = true;
//                Se le indica al PM que ya pasó un día
                Project_manager.PM_nuevo_dia_andy = true;
                Project_manager.PM_nuevo_dia_jose = true;
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Paso_el_dia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
