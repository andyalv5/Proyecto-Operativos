/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_operativos;
import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
import Interfaces.MainFrame;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Andy
 */
public class Proyecto_operativos {
    //prod hay que revisarlo para que sea una variable que se introduzca por interfaz 
    
    public static int ci_Andy = 9;
    public static int ci_jose = 10;
    
    public static int tamanio_Intro = 30;
    public static int tamanio_credito = 25;
    public static int tamanio_Inicio = 50;
    public static int tamanio_Cierre = 55;
    public static int tamanio_Plot_Twist = 40;
    
    public static Semaphore drive_Intro = new Semaphore(tamanio_Intro);
    public static Semaphore drive_credito = new Semaphore(tamanio_credito);
    public static Semaphore drive_Inicio = new Semaphore(tamanio_Inicio);
    public static Semaphore drive_Cierre = new Semaphore(tamanio_Cierre);
    public static Semaphore drive_Plot_Twist = new Semaphore(tamanio_Plot_Twist);
    public static Semaphore semaforo_s = new Semaphore(1);
    
    public static Productores_Intro hilo1= new Productores_Intro(drive_Intro, semaforo_s,1);
    public static Productor_Cierre hilo2= new Productor_Cierre(drive_Cierre, semaforo_s,1);
    public static Productor_Inicio hilo3= new Productor_Inicio(drive_Inicio, semaforo_s,1);
    public static Productor_Credito hilo4= new Productor_Credito(drive_credito, semaforo_s,1);
    public static Productor_Plot_Twist hilo5= new Productor_Plot_Twist(drive_Plot_Twist, semaforo_s,1);
    
    
    
//    public Semaphore semaforo_n = new Semaphore(1);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        MainFrame inicial =new MainFrame();
        inicial.setVisible(true);
    }
    
}
