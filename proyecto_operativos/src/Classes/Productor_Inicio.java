/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Andy
 */
public class Productor_Inicio extends Thread{
    private int productores;
    private int max_Drive;
    public int Pro_per_Day;
    Semaphore drive_Inicio;
    Semaphore s;
    
    public Productor_Inicio(Semaphore drive_Inicio, Semaphore s, int productores, int max_Drive) {
        this.drive_Inicio=drive_Inicio;
        this.s=s;
        this.productores=productores;
        this.max_Drive =max_Drive;
    }
    
    public int get_Pro_per_Day(){
        return this.Pro_per_Day;
    }
    
    public void set_Pro_per_Day(int Pro_per_Day){
        this.Pro_per_Day = Pro_per_Day;
    }
    
    public void free_space(){        
    }
    
    /*
    
    */
    
    public void set_Productores(int productores){
        this.productores=productores;
    }
    
    
     @Override
    public void run(){
        while(true){
                try {
                    
                    this.drive_Inicio.acquire();
                    
                    if(Pro_per_Day <max_Drive){
                        if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                            Thread.sleep(2*Proyecto_operativos.dia_ms);
                            s.acquire();
                            Pro_per_Day=Pro_per_Day+productores*(1);
                            s.release();
                        }
                        else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){
                            Thread.sleep(3*Proyecto_operativos.dia_ms);
                            s.acquire();
                            Pro_per_Day=Pro_per_Day+productores*(1);
                            s.release();
                        }
                        else{
                            Thread.sleep(4*Proyecto_operativos.dia_ms);
                            s.acquire();
                            Pro_per_Day=Pro_per_Day+productores*(1);
                            s.release();
                        }
                    if(Pro_per_Day >max_Drive){
                        s.acquire();
                        Pro_per_Day =max_Drive;
                        s.release();
                        }
                        System.out.println("Se hicieron "+Pro_per_Day+"inicios");
               
                    }


                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    }  
    
}
