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
    public int Pro_per_Day;
    Semaphore drive_Inicio;
    Semaphore s;
    
    public Productor_Inicio(Semaphore drive_Inicio, Semaphore s, int productores) {
        this.drive_Inicio=drive_Inicio;
        this.s=s;
        this.productores=productores;
    }
     @Override
    public void run(){
        while(true){
                try {
                    this.drive_Inicio.acquire();
                    if(Pro_per_Day <50){
                        if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<3){
                            Thread.sleep(2000);
                            Pro_per_Day=Pro_per_Day+productores*(1);
                        }
                        else if(Proyecto_operativos.ci_Andy>=3 && Proyecto_operativos.ci_Andy<6){
                            Thread.sleep(3000);
                            Pro_per_Day=Pro_per_Day+productores*(1);
                        }
                        else{
                            Thread.sleep(4000);
                            Pro_per_Day=Pro_per_Day+productores*(1);
                        }
                    if(Pro_per_Day >50){
                            Pro_per_Day =50;
                        }
                        System.out.println("Se hicieron "+Pro_per_Day+"inicios");
                    }


                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
    }  
    
}
