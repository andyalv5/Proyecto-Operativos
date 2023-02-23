/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import Interfaces.Dashboard;
import static Interfaces.Dashboard.hilo1;
import static Interfaces.Dashboard.hilo2;
import static Interfaces.Dashboard.hilo3;
import static Interfaces.Dashboard.hilo4;
import static Interfaces.Dashboard.hilo5;
import static Interfaces.Dashboard.hilo6;
import Interfaces.Dashboard1;
import static Interfaces.Dashboard1.Dhilo1;
import static Interfaces.Dashboard1.Dhilo2;
import static Interfaces.Dashboard1.Dhilo3;
import static Interfaces.Dashboard1.Dhilo4;
import static Interfaces.Dashboard1.Dhilo5;
import static Interfaces.Dashboard1.Dhilo6;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Hallo
 */
public class Pago extends Thread{
    Project_manager manager;
    Director director;
    public int ganancia_canadiense=100;
    
    public Pago(Project_manager pm_andy, Director dir_andy){
    this.director=dir_andy;
    this.manager=pm_andy;
    
    }
    
    @Override
    public void run(){
        while(Proyecto_operativos.keep){
            
            try {
                
                
    //            Duerme un dia para posteriormente hacer el pago
                Thread.sleep(Proyecto_operativos.dia_en_ms);
                
                
                    
                    
////                    Se le indica al director que ya pasó un día
//                    Director.Director_nuevo_dia = true;
////                    Se le indica al PM que ya pasó un día
//                    Project_manager.PM_nuevo_dia = true;



                    hilo1.ganancia=hilo1.ganancia+hilo1.productores*(3);
                    
                    
                    hilo2.ganancia=hilo2.ganancia+hilo2.productores*(7.5f);
                    
                    
                    hilo3.ganancia=hilo3.ganancia+hilo3.productores*(7);
                    
                  
                    
                    hilo4.ganancia=hilo4.ganancia+hilo4.productores*(3);
                    
                    
                    
                    hilo5.ganancia=hilo5.ganancia+hilo5.productores*(10);
                    
                        
                    
                    hilo6.ganancia=hilo6.ganancia+hilo6.ensambladores*(8);
                    
                    
                    this.director.ganancia=this.director.ganancia+ganancia_canadiense;
                    this.manager.ganancia=this.manager.ganancia+this.director.sueldo_al_payaso;
                    

            } catch (InterruptedException ex) {
                Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
