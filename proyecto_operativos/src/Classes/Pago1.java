/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import Interfaces.Dashboard;
import Interfaces.Dashboard1;
import static Interfaces.Dashboard1.Dhilo1;
import static Interfaces.Dashboard1.Dhilo2;
import static Interfaces.Dashboard1.Dhilo3;
import static Interfaces.Dashboard1.Dhilo4;
import static Interfaces.Dashboard1.Dhilo5;
import static Interfaces.Dashboard1.Dhilo6;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Hallo
 */
public class Pago1 extends Thread{
    Project_manager manager;
    Director director;
    public int ganancia_canadiense =100;
    public Pago1(Project_manager pm_andy, Director dir_andy){
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



                    Dashboard1.Dhilo1.ganancia=Dashboard1.Dhilo1.ganancia+Dashboard1.Dhilo1.productores*(3);
                    
                    
                    
                    Dashboard1.Dhilo2.ganancia=Dashboard1.Dhilo2.ganancia+Dashboard1.Dhilo2.productores*(7.5f);
                    
                    
                    
                    Dashboard1.Dhilo3.ganancia=Dashboard1.Dhilo3.ganancia+Dashboard1.Dhilo3.productores*(7);
                    
                  
                    
                    Dashboard1.Dhilo4.ganancia=Dashboard1.Dhilo4.ganancia+Dashboard1.Dhilo4.productores*(3);
                    
                    
                    
                    Dashboard1.Dhilo5.ganancia=Dashboard1.Dhilo5.ganancia+Dashboard1.Dhilo5.productores*(10);
                    
                        
                   
                    Dashboard1.Dhilo6.ganancia=Dashboard1.Dhilo6.ganancia+Dashboard1.Dhilo6.ensambladores*(8);
                    
                    
                    
                    this.director.ganancia=this.director.ganancia+ganancia_canadiense;
                    this.manager.ganancia=this.manager.ganancia+this.director.sueldo_al_payaso;
                    

            } catch (InterruptedException ex) {
                Logger.getLogger(Pago1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
