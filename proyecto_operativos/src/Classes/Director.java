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
    public int ganancia;
    public int sueldo_al_payaso =(7*8);
    
//    Variable que indica si el director está en un nuevo dia
    public static volatile boolean Director_nuevo_dia = false;
    
    Project_manager pm;
    
//    Solo puede o ser "jose" o "andy"
    String rodaje;
//    boolean keep = true;
    
//    El Project Manager que el director vigila
    
    public javax.swing.JTextField Contador_inter;
        
        
    public Director(Project_manager pm, String rodaje, javax.swing.JTextField Contador_inter){
        this.pm = pm;
        this.rodaje = rodaje;
        this.Contador_inter = Contador_inter;
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
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));
        }else{
            
            Proyecto_operativos.contador_dias_restantes_jose = Proyecto_operativos.dias_entre_despachos;
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_jose));
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
                    Proyecto_operativos.keep=false;
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
//            Project_manager.Veces_descubierto_flojeando++;
            this.Sumar_veces_descubierto_flojeando_rodaje();
            this.sueldo_al_payaso =sueldo_al_payaso-1;
            
        }else{
            System.out.println("Director: A la proxima te veo >.>");

        }
    }
    
    /**
     * Le suma las veces que fue descubierto al PM del rodaje respectivo
     */
    public void Sumar_veces_descubierto_flojeando_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            Project_manager.Veces_descubierto_flojeando_andy++;
        }else{
            Project_manager.Veces_descubierto_flojeando_jose++;
        }
    }
}
