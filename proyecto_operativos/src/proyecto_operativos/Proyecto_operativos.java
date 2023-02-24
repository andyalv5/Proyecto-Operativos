/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_operativos;
import Classes.Director;
import Classes.Project_manager;
import Interfaces.MainFrame;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.io.FileNotFoundException;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Andy
 */
public class Proyecto_operativos {
         
    public static int dia_en_ms = 1000;
    
    public static int nro_final_id_jose = 9;
    public static int nro_final_id_andy = 8;

//    ------------------------------------------------------------------------
//    Cantidad de dias entre despachos de series (NO CAMBIA)
    public static int dias_entre_despachos = 30;
//    -----------------------------------------------------------------------    
//   Director - Project_Manager
    
//    Semaforo que accede al contador (seccion critica)
//    public static Semaphore Contador = new Semaphore(1);
//    Semaforo que accede a la variable booleana de la clase "Project_Manager" Rick y Morty
    public static Semaphore Director_PM_Semaphore = new Semaphore(1);
    
    public static Semaphore Director_PM_Semaphore_jose = new Semaphore(1);
    public static Semaphore Director_PM_Semaphore_andy = new Semaphore(1);
    
//    Empieza con los días restantes que faltan para la entrega de la serie
//    public static int contador_dias_restantes;
    public static int contador_dias_restantes_andy;
    public static int contador_dias_restantes_jose;
    
    
////    Aqui tengo el project manager trabajando con la cedula de andy
//    public static Project_manager pm_andy = new Project_manager(Proyecto_operativos.ci_Andy, "andy");
////    Aqui le indico al director de andy a que productor vigilar, y además, le indico que es el director de andy
//    public static Director dir_andy = new Director(Proyecto_operativos.pm_andy, "andy");
    
    public static Semaphore Contador_andy = new Semaphore(1);
    public static Semaphore Contador_jose = new Semaphore(1);
    
//    -----------------------------------------------------------------------
    
//    Lo que para todo
    public static volatile boolean keep = true;
     
    
//    Final cédula Andy
    public static int ci_Andy = 8;
    
//    Final cédula José
    public static int ci_jose = 9;
    
//    public static int dia_en_ms = 1000;
    
    
    public static Semaphore Pro_per_day_Intro_Ensambler = new Semaphore(1);
        
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        
        
        JSONReaderWriter jsonrw = new JSONReaderWriter();
        jsonrw.Reader();
       
        MainFrame inicial = new MainFrame();
        inicial.setVisible(true);
        
    }
    
}
