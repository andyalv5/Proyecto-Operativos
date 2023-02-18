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
public class Project_manager extends Thread{
    public int ganancia;
    
//    Si está viendo R y M
    boolean Rick_y_Morty = false;
//    Si está revisando Sprints reviews
    boolean Sprint_reviews = false;
    
//    public static volatile int Veces_descubierto_flojeando = 0;
    public static volatile int Veces_descubierto_flojeando_andy = 0;
    public static volatile int Veces_descubierto_flojeando_jose = 0;
    
//    Variable que indica que el project manager está en un nuevo dia
    public static volatile boolean PM_nuevo_dia = false;    
    int ci;    
    //    Solo puede o ser "jose" o "andy"
    String rodaje;
    
    javax.swing.JTextField Contador_inter;
    
    /**
     * 
     * @param ci 
     * @param rodaje 
     * @param Contador_inter 
     */
    public Project_manager(int ci, String rodaje, javax.swing.JTextField Contador_inter){
        this.ci = ci;
        this.rodaje = rodaje;
        this.Contador_inter = Contador_inter;
    }
    
    /**
     * Revisa que rodaje es, y en consecuencia,usa el semaforo correspondiente para acquire
     * @throws InterruptedException 
     */
    public void Semaforo_Contador_acquire() throws InterruptedException{
        if(this.rodaje.equalsIgnoreCase("andy")){
//            System.out.println("toca un acquire PM Contador en andy");
            Proyecto_operativos.Contador_andy.acquire();
//            System.out.println(Proyecto_operativos.Contador_andy);
            
        }else{
            Proyecto_operativos.Contador_jose.acquire();
        }
    }
    
    /**
     * Revisa que rodaje es, y en consecuencia, usa el semaforo correspondiente para release
     * @throws InterruptedException 
     */
    public void Semaforo_Contador_release() throws InterruptedException{
        if(this.rodaje.equalsIgnoreCase("andy")){
//            System.out.println("toca un release PM Contador en andy");
            Proyecto_operativos.Contador_andy.release();
//            System.out.println(Proyecto_operativos.Contador_andy);
        }else{
            Proyecto_operativos.Contador_jose.release();
        }
    }
   
    /**
     * Evalua en que rodaje se está
     * @return el contador de dias restantes segun el rodaje 
     */
    public int Contador_dias_restantes_rodaje(){
        if(this.rodaje.equalsIgnoreCase("andy")){
            return Proyecto_operativos.contador_dias_restantes_andy;
        }else{
            return Proyecto_operativos.contador_dias_restantes_jose;            
        }
    }
    /**
     * Resta en 1 el contador de dias restantes en el rodaje en específico
     */
    public void Restar_contador_dias_restantes_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            Proyecto_operativos.contador_dias_restantes_andy--;  
            System.out.println(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));
                        
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));
        }else{
            Proyecto_operativos.contador_dias_restantes_jose--;            
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_jose));
        }
    }
    
    @Override
    public void run(){
        while(Proyecto_operativos.keep){
            
            try {
//                Trabajaremos con el caso "andy"
                int tiempo;
                                
//                Proyecto_operativos.Contador.acquire();
                this.Semaforo_Contador_acquire();
//                System.out.println("Soy un PM que no puede entrar");
//                System.out.println(Project_manager.PM_nuevo_dia);
                if(this.Contador_dias_restantes_rodaje() > 0 && Project_manager.PM_nuevo_dia){
                    
                    Project_manager.PM_nuevo_dia = false;
    //                Tomaremos el valor de "final de la cedula" + "1 hora" en relación a lo que vale un día en milisegundos
                    tiempo = Proyecto_operativos.dia_en_ms * ci / 24 + Proyecto_operativos.dia_en_ms / 24;

    //                Se duermen las horas establecidas
                    Thread.sleep(tiempo);
                    
//                    Disminuimos el contador de dias restantes
//                    Proyecto_operativos.contador_dias_restantes--;
                    this.Restar_contador_dias_restantes_rodaje();
                    
                    System.out.println("Tomaa: " + this.Contador_dias_restantes_rodaje());
                    
//                    Proyecto_operativos.Contador.release();
                    this.Semaforo_Contador_release();
                    
                }else{
                    this.Semaforo_Contador_release();
                    
                }
                
//                Calculamos el (15 + ultimo digito cedula) minutos en los milisegundos correspondientes EN BASE A LO QUE VALE UN DIA
                tiempo = (Proyecto_operativos.dia_en_ms*15/24)/60 + (Proyecto_operativos.dia_en_ms*Proyecto_operativos.nro_final_id_andy/24)/60;
                
                //Se dispone a ver Rick_y_Morty xd
                if(this.rodaje.equalsIgnoreCase("andy")){
//                    Si es del rodaje de andy, pues entrará aquí

//                    Sección critica
                    Proyecto_operativos.Director_PM_Semaphore_andy.acquire();                    
//                    System.out.println("Verdadero en andy");
                    this.Rick_y_Morty = true;                    
                    Proyecto_operativos.Director_PM_Semaphore_andy.release();
                    
//                    Espera su tiempo
                    Thread.sleep(tiempo);                
                    
//                    Sección crítica
                    Proyecto_operativos.Director_PM_Semaphore_andy.acquire();                                        
//                    System.out.println("FALSO en andy");
                    this.Rick_y_Morty = false;                    
                    Proyecto_operativos.Director_PM_Semaphore_andy.release();
                    
                }else{
//                    Si no es "andy", awebo tiene que ser "jose"

//                    Sección critica
                    Proyecto_operativos.Director_PM_Semaphore_jose.acquire();                    
                    System.out.println("Verdadero en jose");
                    this.Rick_y_Morty = true;                    
                    Proyecto_operativos.Director_PM_Semaphore_jose.release();
                    
//                    Duerme su tiempo
                    Thread.sleep(tiempo);                
                    
//                    Seccion critica
                    Proyecto_operativos.Director_PM_Semaphore_jose.acquire();
                    System.out.println("FALSO en jose");
                    this.Rick_y_Morty = false;                                        
                    Proyecto_operativos.Director_PM_Semaphore_jose.release();
                }
                
//                Proyecto_operativos.Director_PM_Semaphore.acquire();
//                System.out.println("Verdadero");
//                this.Rick_y_Morty = true;
//                Proyecto_operativos.Director_PM_Semaphore.release(); 
                
//                Thread.sleep(tiempo);                
                
//                Ya quiere dejar de ver Rick y Morty
//                Proyecto_operativos.Director_PM_Semaphore.acquire();
//                System.out.println("FALSO");
//                this.Rick_y_Morty = false;
//                Proyecto_operativos.Director_PM_Semaphore.release();
                
                
//                Ahora se dispone a ver Sprints Reviews
                this.Sprint_reviews = true;
                
                Thread.sleep(tiempo);
                
                this.Sprint_reviews = false;
                
                Thread.sleep(tiempo);
                
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Project_manager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
