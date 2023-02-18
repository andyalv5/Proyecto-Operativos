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
                
                    Director.Director_nuevo_dia = true;
                    Project_manager.PM_nuevo_dia = true;

                    Dashboard.Jtext_Productores_Intro.acquire();
                    hilo1.ganancia=hilo1.ganancia+hilo1.productores*(3);
                    Dashboard.Jtext_Productores_Intro.release();
                    
                    Dashboard.Jtext_Productores_Cierre.acquire();
                    hilo2.ganancia=hilo2.ganancia+hilo2.productores*(7.5f);
                    Dashboard.Jtext_Productores_Cierre.release();
                    
                    Dashboard.Jtext_Productores_Inicio.acquire();
                    hilo3.ganancia=hilo3.ganancia+hilo3.productores*(7);
                    Dashboard.Jtext_Productores_Inicio.release();
                  
                    Dashboard.Jtext_Productores_Credito.acquire();
                    hilo4.ganancia=hilo4.ganancia+hilo4.productores*(3);
                    Dashboard.Jtext_Productores_Credito.release();
                    
                    Dashboard.Jtext_Productores_Plot_Twist.acquire();
                    hilo5.ganancia=hilo5.ganancia+hilo5.productores*(10);
                    Dashboard.Jtext_Productores_Plot_Twist.release();
                        
                    Dashboard.Jtext_Productores_Ensamblado.acquire();
                    hilo6.ganancia=hilo6.ganancia+hilo6.ensambladores*(8);
                    Dashboard.Jtext_Productores_Ensamblado.release();
                

            } catch (InterruptedException ex) {
                Logger.getLogger(Pago.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
