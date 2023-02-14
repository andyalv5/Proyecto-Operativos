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
    public int Pro_per_Day;
    Semaphore drive_Credito;
    Semaphore s;
    
    public Productor_Credito(Semaphore drive_Credito, Semaphore s,int productores) {
        this.drive_Credito=drive_Credito;
        this.s=s;
        this.productores =productores;
    }
     @Override
    public void run(){
        while(true){
            try {
                    this.drive_Credito.acquire();
                    if(Pro_per_Day <25){
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
                        if(Pro_per_Day >25){
                            Pro_per_Day =25;
                        }
                        System.out.println("Se hicieron "+Pro_per_Day+" Creditos");
                    }
                    

                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }  
}
