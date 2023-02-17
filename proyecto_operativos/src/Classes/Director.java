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
public class Director extends Thread{
//    Estas variables random las pienso usar para calculos futuros
    int random;
    int random2;
//    boolean keep = true;
    
//    El Project Manager que el director vigila
        
        
    public Director(){
    }
    
    
    @Override
    public void run(){
        
        
        while(Proyecto_operativos.keep){
            try {
                
                Proyecto_operativos.Contador.acquire();
                
                if(Proyecto_operativos.contador_dias_restantes != 0){
                    
                    Proyecto_operativos.Contador.release();
                    
//                    genera un numero random de 30 a 90 min en base al día establecido
                    random = (int)(Math.random()*((double)(Proyecto_operativos.dia_en_ms)/24 + (double)(Proyecto_operativos.dia_en_ms)/24/60) + (double)(Proyecto_operativos.dia_en_ms)/24/2);
                    
                    Thread.sleep(random);
                    
    //                Agregamos semaforo a la sección critica
//                    Proyecto_operativos.Director_PM_Semaphore.acquire();
    //                Llamamos al metodo "cachado"

                    cachado();                    

    //                Liberamos semaforo a la sección critica
//                    Proyecto_operativos.Director_PM_Semaphore.release();
                    
//                    Toma su descanso de vigilación cada 30-90 minutos
                    
                }else{
//                    ---------------------------------------
//                    Aquí pondremos el método para agregar todos los capitulos creados a la serie
//                    Y además resetearemos el contador a su valor original
                    Proyecto_operativos.contador_dias_restantes = Proyecto_operativos.dias_entre_despachos;
//                    --------------------------------------------

                    Proyecto_operativos.Contador.release();
                    
                }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   
    /*
    Revisa si el PM está viendo RyM
    */
    public void cachado() throws InterruptedException{
        
        if(Project_manager.Rick_y_Morty == true){
            
            System.out.println("Director: Te vi menooor");
            
//            Medimos las horas que tarda el Director 12-18 horas aleatoriamente
            int random2 = (int)(Math.random()*Proyecto_operativos.dia_en_ms*6/24 + Proyecto_operativos.dia_en_ms*12/24);
            
            Thread.sleep(random2);
            
            //Se agrega +1 a las veces que fue descubierto flojeando al Project_manager
            Project_manager.Veces_descubierto_flojeando++;
            
        }else{
            System.out.println("Director: A la proxima te veo >.>");

        }
    }
}
