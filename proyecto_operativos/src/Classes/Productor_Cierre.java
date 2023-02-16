/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_1;

/**
 *
 * @author Andy
 */
public class Productor_Cierre extends Thread{
    public int Pro_per_Day;
    private int productores;
    private int max_Drive;
    Semaphore drive_Cierre;
    Semaphore s;
    
    public Productor_Cierre(Semaphore drive_Cierre, Semaphore s, int productores,int max_Drive) {
        this.drive_Cierre=drive_Cierre;
        this.s=s;
        this.productores=productores;
        this.max_Drive = max_Drive;
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
                    
                    this.drive_Cierre.acquire();
                    
                    
                    if(Proyecto_1.ci_Andy>=0 && Proyecto_1.ci_Andy<3){
                        if(Pro_per_Day <max_Drive){
                            Thread.sleep(4*Proyecto_1.dia_en_ms);
                            s.acquire();
                            Pro_per_Day = Pro_per_Day+productores*(1);}
                            s.release();
                    }
                    else if(Proyecto_1.ci_Andy>=3 && Proyecto_1.ci_Andy<6){
                        if(Pro_per_Day <max_Drive){
                            Thread.sleep(2*Proyecto_1.dia_en_ms);
                            s.acquire();
                            Pro_per_Day=Pro_per_Day+productores*(1);}
                            s.release();
                    }
                    else{
                        if(Pro_per_Day <max_Drive){
                            
                            Thread.sleep(3*Proyecto_1.dia_en_ms);
                            s.acquire();
                            Pro_per_Day=Pro_per_Day+productores*(1);
                            s.release();
                        }
                        
                    }
                    if(Pro_per_Day >max_Drive){
                        s.acquire();
                        Pro_per_Day =max_Drive;
                        s.release();
                    }
                    System.out.println("Se hicieron "+Pro_per_Day+" Cierres");
                  


                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
        }
    }
   
}
