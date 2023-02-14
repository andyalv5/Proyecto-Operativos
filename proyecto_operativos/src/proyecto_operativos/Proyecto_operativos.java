/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_operativos;
import Interfaces.MainFrame;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Andy
 */
public class Proyecto_operativos {
    public static int ci_Andy = 9;
    public static int ci_jose = 10;
    
    public int tamanio_Intro = 30;
    public int tamanio_credito = 25;
    public int tamanio_Inicio = 50;
    public int tamanio_Cierre = 55;
    public int tamanio_Plot_Twist = 40;
    
    public Semaphore drive_Intro = new Semaphore(tamanio_Intro);
    public Semaphore drive_credito = new Semaphore(tamanio_credito);
    public Semaphore drive_Inicio = new Semaphore(tamanio_Inicio);
    public Semaphore drive_Cierre = new Semaphore(tamanio_Cierre);
    public Semaphore drive_Plot_Twist = new Semaphore(tamanio_Plot_Twist);
    public Semaphore semaforo_s = new Semaphore(1);
//    public Semaphore semaforo_n = new Semaphore(1);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame inicial =new MainFrame();
        inicial.setVisible(true);
    }
    
}
