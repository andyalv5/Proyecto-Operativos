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
    
//    Variable que indica si el director está en un nuevo dia
    public static volatile boolean Director_nuevo_dia = false;
    
    Project_manager pm;
    
//    Solo puede o ser "jose" o "andy"
    String rodaje;
//    boolean keep = true;
    
//    El Project Manager que el director vigila
        
        
    public Director(Project_manager pm, String rodaje){
        this.pm = pm;
        this.rodaje = rodaje;
    }
    /**
     * Hace un acquire del semaforo de su respectivo rodaje
     * @throws InterruptedException 
     */
    public void Semaforo_RM_acquire() throws InterruptedException{
        if(this.rodaje.equalsIgnoreCase("andy")){
            
            Proyecto_operativos.Director_PM_Semaphore_andy.acquire();
            
        }else{
            
            Proyecto_operativos.Director_PM_Semaphore_jose.acquire();
        }
    }
    
    /**
     * Hace un release del semaforo de su respectivo rodaje
     * @throws InterruptedException 
     */
    public void Semaforo_RM_release() throws InterruptedException{
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            Proyecto_operativos.Director_PM_Semaphore_andy.release();
        }else{
            Proyecto_operativos.Director_PM_Semaphore_jose.release();
        }
    }
    
    /**
     * Resetea el contador de dias restantes para el respectivo rodaje
     */
    public void resetear_contador_dias_restantes_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
//            System.out.println("Toca el reseteo a andy");
            Proyecto_operativos.contador_dias_restantes_andy = Proyecto_operativos.dias_entre_despachos;
        
        }else{
            
            Proyecto_operativos.contador_dias_restantes_jose = Proyecto_operativos.dias_entre_despachos;
        }
    }
    
    @Override
    public void run(){
        
        
        while(Proyecto_operativos.keep){
            try {
                
//                Proyecto_operativos.Contador.acquire();
                pm.Semaforo_Contador_acquire();
                
                if(pm.Contador_dias_restantes_rodaje() != 0 && Director.Director_nuevo_dia){
                    
//                    Proyecto_operativos.Contador.release();
                    pm.Semaforo_Contador_release();
                    
                    Director.Director_nuevo_dia = false;
                    
//                    genera un numero random de 30 a 90 min en base al día establecido
                    random = (int)(Math.random()*((double)(Proyecto_operativos.dia_en_ms)/24 + (double)(Proyecto_operativos.dia_en_ms)/24/60) + (double)(Proyecto_operativos.dia_en_ms)/24/2);
                    
                    Thread.sleep(random);
                    
    //                Agregamos semaforo a la sección critica
//                    Proyecto_operativos.Director_PM_Semaphore.acquire();
    //                Llamamos al metodo "cachado"
                    
                    this.Semaforo_RM_acquire();
    
                    cachado();                 
                    
                    this.Semaforo_RM_release();

    //                Liberamos semaforo a la sección critica
//                    Proyecto_operativos.Director_PM_Semaphore.release();
                    
//                    Toma su descanso de vigilación cada 30-90 minutos
                    
                }else if(pm.Contador_dias_restantes_rodaje() == 0 && Director.Director_nuevo_dia){
//                    ---------------------------------------
//                    Aquí pondremos el método para agregar todos los capitulos creados a la serie
//                    Y además resetearemos el contador a su valor original
                    
//                    Proyecto_operativos.contador_dias_restantes = Proyecto_operativos.dias_entre_despachos;
                    this.resetear_contador_dias_restantes_rodaje();
//                    --------------------------------------------

//                    Proyecto_operativos.Contador.release();
                    pm.Semaforo_Contador_release();
                    
                }else{
                    
                    pm.Semaforo_Contador_release();
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
        
        if(this.pm.Rick_y_Morty == true){
            
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
