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
public class Project_manager extends Thread{
    
//    Si está viendo R y M
    public static volatile boolean Rick_y_Morty = false;
//    Si está revisando Sprints reviews
    public static boolean Sprint_reviews = false;
    
    public static volatile int Veces_descubierto_flojeando = 0;
    
    public Project_manager(){
        
    }
    
    
    @Override
    public void run(){
        while(true){
            
            try {
//                Trabajaremos con el caso "andy"
                int tiempo;
                                
                Proyecto_1.Contador.acquire();
                if(Proyecto_1.contador_dias_restantes > 0){
    //                Tomaremos el valor de "final de la cedula" + "1 hora" en relación a lo que vale un día en milisegundos
                    tiempo = Proyecto_1.dia_en_ms * Proyecto_1.nro_final_id_andy / 24 + Proyecto_1.dia_en_ms / 24;

    //                Se duermen las horas establecidas
                    Thread.sleep(tiempo);
                    
//                    Disminuimos el contador de dias restantes
                    Proyecto_1.contador_dias_restantes--;
                    
                    System.out.println("Tomaa: " + Proyecto_1.contador_dias_restantes);
                    
                    Proyecto_1.Contador.release();
                    
                }else{
                    Proyecto_1.Contador.release();

                }
                
//                Calculamos el (15 + ultimo digito cedula) minutos en los milisegundos correspondientes EN BASE A LO QUE VALE UN DIA
                tiempo = (Proyecto_1.dia_en_ms*15/24)/60 + (Proyecto_1.dia_en_ms*Proyecto_1.nro_final_id_andy/24)/60;
                
                //Se dispone a ver Rick_y_Morty xd
//                Proyecto_1.Director_PM_Semaphore.acquire();
                System.out.println("Verdadero");
                Project_manager.Rick_y_Morty = true;
//                Proyecto_1.Director_PM_Semaphore.release(); 
                
                Thread.sleep(tiempo);                
                
//                Ya quiere dejar de ver Rick y Morty
//                Proyecto_1.Director_PM_Semaphore.acquire();
                System.out.println("FALSO");
                Project_manager.Rick_y_Morty = false;
//                Proyecto_1.Director_PM_Semaphore.release();
                
                
//                Ahora se dispone a ver Sprints Reviews
                Project_manager.Sprint_reviews = true;
                
                Thread.sleep(tiempo);
                
                Project_manager.Sprint_reviews = false;
                
                Thread.sleep(tiempo);
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Project_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
