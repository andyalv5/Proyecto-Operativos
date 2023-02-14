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
public class Productores_Intro extends Thread{
    public int Pro_per_Day;
    Semaphore drive_Intro;
    Semaphore s;
    private int productores;
    private int max_Drive;
    
    
    public Productores_Intro(Semaphore drive_Intro, Semaphore s,int productores, int max_Drive) {
        this.drive_Intro=drive_Intro;
        this.s=s;
        this.productores=productores;
        this.max_Drive=max_Drive;
        
    }
    public int get_Pro_per_Day(){
        return this.Pro_per_Day;
    }
    
    public void set_Pro_per_Day(int Pro_per_Day){
        this.Pro_per_Day = Pro_per_Day;
    }
    @Override
    public void run(){
        while(true){
                try {
                    if(Pro_per_Day <max_Drive){
                        this.drive_Intro.acquire();
                        Thread.sleep(1000);
                        if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                            Pro_per_Day=Pro_per_Day+productores*(1);
                        }
                        else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){

                            Pro_per_Day=Pro_per_Day+productores*(2);
                        }
                        else{
                            Pro_per_Day=Pro_per_Day+productores*(3);
                        }
                    }
                    else{
                            this.drive_Intro.acquire();
                            Pro_per_Day =max_Drive;
                        }
                    System.out.println("Se hicieron "+Pro_per_Day+" intros");
                    this.drive_Intro.release();
                    
                }
            catch (InterruptedException ex) {
                Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}
