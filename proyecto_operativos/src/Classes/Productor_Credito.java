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
public class Productor_Credito extends Thread{
    private int productores;
    private int max_Drive;
    public int Pro_per_Day;
    Semaphore drive_Credito;
    Semaphore s;
    
    public Productor_Credito(Semaphore drive_Credito, Semaphore s,int productores,int max_Drive) {
        this.drive_Credito=drive_Credito;
        this.s=s;
        this.productores =productores;
        this.max_Drive =max_Drive;
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
                    this.drive_Credito.acquire();
                    if(Pro_per_Day <max_Drive){
                        Thread.sleep(1000);
                        if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                            Pro_per_Day=Pro_per_Day+productores*(4);
                        }
                        else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){
                            Pro_per_Day=Pro_per_Day+productores*(2);
                        }
                        else{
                            Pro_per_Day=Pro_per_Day+3;
                        }
                        if(Pro_per_Day >max_Drive){
                            Pro_per_Day =max_Drive;
                        }
                    }
                    System.out.println("Se hicieron "+Pro_per_Day+" Creditos");
                    this.drive_Credito.release();

                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }  
}
