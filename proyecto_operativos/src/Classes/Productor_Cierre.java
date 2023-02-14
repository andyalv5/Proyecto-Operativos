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
public class Productor_Cierre extends Thread{
    public int Pro_per_Day;
    private int productores;
    Semaphore drive_Cierre;
    Semaphore s;
    
    public Productor_Cierre(Semaphore drive_Cierre, Semaphore s, int productores) {
        this.drive_Cierre=drive_Cierre;
        this.s=s;
        this.productores=productores;
    }
    @Override
    public void run(){
        while(true){
                try {
                    this.drive_Cierre.acquire();
                    
                    if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                        if(Pro_per_Day <55){
                            Thread.sleep(4000);
                            Pro_per_Day = Pro_per_Day+productores*(1);}
                    }
                    else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){
                        if(Pro_per_Day <55){
                            Thread.sleep(2000);
                            Pro_per_Day=Pro_per_Day+productores*(1);}
                    }
                    else{
                        if(Pro_per_Day <55){
                            Thread.sleep(3000);
                            Pro_per_Day=Pro_per_Day+productores*(1);}
                    }
                    if(Pro_per_Day >55){
                        Pro_per_Day =55;
                    }
                    System.out.println("Se hicieron "+Pro_per_Day+" Cierres");


                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.s.release();
            
        }
    }
   
}
