/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_operativos;
import Classes.Director;
import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
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
    
//    JOSÉ SE ROBARÁ ESTE ESPACIO MUAJAJAJA
//    ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
     
    public static int dia_en_ms = 1000;
    
    public static int nro_final_id_jose = 9;
    public static int nro_final_id_andy = 8;
    
    
//    Project_Manager
//    ------------------------------------------------------------------------
//    ------------------------------------------------------------------------
    
    
//    Director:
//    ------------------------------------------------------------------------
//    Cantidad de dias entre despachos de series (NO CAMBIA)
    public static int dias_entre_despachos = 30;
//    -----------------------------------------------------------------------
    
//   Director - Project_Manager
//    -----------------------------------------------------------------------
    
//    Semaforo que accede al contador (seccion critica)
    public static Semaphore Contador = new Semaphore(1);
//    Semaforo que accede a la variable booleana de la clase "Project_Manager" Rick y Morty
    public static Semaphore Director_PM_Semaphore = new Semaphore(1);
    
//    Empieza con los días restantes que faltan para la entrega de la serie
    public static volatile int contador_dias_restantes = 30;
    
//    -----------------------------------------------------------------------

    
//    ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    
    
    
    //prod hay que revisarlo para que sea una variable que se introduzca por interfaz 
    
//    Final cédula Andy
    public static int ci_Andy = 1;
    
//    Final cédula José
    public static int ci_jose = 10;
    
//    public static int dia_en_ms = 1000;
    
    
    public static Semaphore Pro_per_day_Intro_Ensambler = new Semaphore(1);
    
    
//    Tamaños diferentes en el drive
//    public static int tamanio_credito = 25;
//    public static int tamanio_Inicio = 50;
//    public static int tamanio_Cierre = 55;
//    public static int tamanio_Plot_Twist = 40;
    
//    Semaforos para cada tamaño diferente en el drive
//    public static Semaphore drive_credito = new Semaphore(tamanio_credito);
//    public static Semaphore drive_Inicio = new Semaphore(tamanio_Inicio);
//    public static Semaphore drive_Cierre = new Semaphore(tamanio_Cierre);
//    public static Semaphore drive_Plot_Twist = new Semaphore(tamanio_Plot_Twist);
//    public static Semaphore semaforo_s = new Semaphore(1);
    
    
    
    
//    public Semaphore semaforo_n = new Semaphore(1);
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        MainFrame inicial = new MainFrame();
//        inicial.setVisible(true);
        
//        JOSE VA A DOMINAR ESTO MUAJAJAJA
//        |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        Director dir = new Director();
        Project_manager pm = new Project_manager();
        
        dir.start();
        pm.start();
        
        JSONReaderWriter jsonrw = new JSONReaderWriter();
        
        jsonrw.Writer("1", "30", "30", "false", "25", "false", "50", "false", "55", "false", "40", "false", "15", "1", "1", "1", "1", "14", "1", "1", "1", "1", "1", "1");
        jsonrw.Reader();
//        |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
        
    }
    
}
