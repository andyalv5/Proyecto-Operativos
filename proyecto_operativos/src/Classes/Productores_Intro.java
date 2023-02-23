/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaces.Dashboard;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;


/**
 *
 * @author Andy
 */
public class Productores_Intro extends Thread{
    public int ganancia;
    public int Pro_per_Day;
    Semaphore drive_Intro;
    Semaphore s;
    public int productores;
    private int max_Drive;
    private int num;
    Semaphore empty;
    
    javax.swing.JTextField Cant_Productores_Intro;
    
    
    public Productores_Intro(Semaphore drive_Intro,Semaphore empty, Semaphore s,int productores,int max_Drive,int num) {
        this.drive_Intro = drive_Intro;
        this.s = s;
        this.max_Drive = max_Drive;
        this.productores=productores;
        this.num=num;
        this.empty=empty;
    }
    
    public void free_space(int n){        
        this.drive_Intro.release(n);
    }
    
    /*
    
    */
    
    public void set_Productores(int productores){
        this.productores=productores;
    }
    
    public int get_Pro_per_Day(){
        return this.Pro_per_Day;
    }
    
    public void set_Pro_per_Day(int Pro_per_Day){
        this.Pro_per_Day = Pro_per_Day;
    }
    
    public int get_ganancia(){
        return this.ganancia;
    }
    
    public void set_ganancia(int ganancia){
        this.ganancia = ganancia;
    }
    
    @Override
    public void run(){
        while(Proyecto_operativos.keep){
            
            try {
//              Proyecto_operativos.Pro_per_day_Intro_Ensambler.acquire();
                
                System.out.println("Estoy a punto de entrar al acquire");
                this.drive_Intro.acquire(num);
                System.out.println("Estoy saliendo del aquire");
                    
                Thread.sleep(Proyecto_operativos.dia_en_ms);
               
                if(Pro_per_Day < max_Drive){
                        
                    
                        
//                        Si la cedula está entre 0 y 3, entra
                    if(Proyecto_operativos.ci_Andy >= 0 && Proyecto_operativos.ci_Andy < 3){
                        
                            
//                            Intentamos acceder al area compartida sección critica
                        
                        s.acquire();
                            
//                            Leemos el texto
                            Pro_per_Day = Pro_per_Day + (productores * 1);
                            
//                            Liberamos el area compartida
                        s.release();
                       
                            
//                            System.out.println("-------------------------------");
//                            System.out.println(Integer.parseInt(Cant_Productores_Intro.getText()) );
//                            System.out.println("-------------------------------");
                            
                            
                    }
                    else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){

                        s.acquire();
                        Pro_per_Day = Pro_per_Day + (productores*2);
                        s.release();
                    }
                    else{
                        s.acquire();
                        Pro_per_Day = Pro_per_Day + (productores*3);
                        s.release();
                        }
                    }
                    
                if(Pro_per_Day >max_Drive){
                        s.acquire();
                        Pro_per_Day = max_Drive;
                        s.release();
                }
                
                if(Pro_per_Day <0){
                    s.acquire();
                    Pro_per_Day =0;
                    s.release();
                }
                System.out.println("Se hicieron " + Pro_per_Day + " intros");
                empty.release(Pro_per_Day);
                    
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
