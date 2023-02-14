/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;


/**
 *
 * @author Andy
 */
public class Productores_Intro extends Thread{
    private int Pro_per_Day;
    Semaphore drive_Intro;
    Semaphore s;
    
    public Productores_Intro(Semaphore drive_Intro, Semaphore s) {
        this.drive_Intro=drive_Intro;
        this.s=s;
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                this.drive_Intro.acquire();
                
                if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                Pro_per_Day=1;
                }
                else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){
                    Pro_per_Day=2;
                }
                else{
                    Pro_per_Day=3;
                }
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }  
    
    public void ProducirIntro(int Pro_per_Day){
        
        
    };
}
