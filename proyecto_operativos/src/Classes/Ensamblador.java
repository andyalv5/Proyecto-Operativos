/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Ensamblador extends Thread{

    public int capitulo;
    public int intro_Prod;
    public int cierre_Prod;
    public int Credito_Prod;
    public int inicio_Prod;
    public int Plot_Twist_Prod;
    Productores_Intro hilo1;
    Productor_Cierre hilo2;
    Productor_Inicio hilo3;
    Productor_Credito hilo4;
    Productor_Plot_Twist hilo5;
    
    
    Semaphore s;
    
    public Ensamblador(Productores_Intro hilo1,Productor_Cierre hilo2,Productor_Inicio hilo3,Productor_Credito hilo4,Productor_Plot_Twist hilo5) {
     this.hilo1= hilo1;
     this.hilo2= hilo2;
     this.hilo3= hilo3;
     this.hilo4= hilo4;
     this.hilo5= hilo5;
     
    }
    
    public int get_capitulo(){
        return this.capitulo;
    }
    
    public void set_cierre_Prod(int Pro_per_Day){
        this.cierre_Prod = Pro_per_Day;
    }
    
    public void set_Credito_Prod(int Pro_per_Day){
        this.Credito_Prod = Pro_per_Day;
    }
    
    public void set_inicio_Prod(int Pro_per_Day){
        this.intro_Prod = Pro_per_Day;
    }
    
    public void set_intro_Prod(int Pro_per_Day){
        this.inicio_Prod = Pro_per_Day;
    }
    
    public void set_Plot_Twist_Prod(int Pro_per_Day){
        this.Plot_Twist_Prod = Pro_per_Day;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(2000);
                if(intro_Prod>0 && inicio_Prod>0 && cierre_Prod>0 && Plot_Twist_Prod>0 && Credito_Prod>0){
                    capitulo = capitulo+1;
                    
                    hilo1.set_Pro_per_Day(hilo1.Pro_per_Day-1);                    
                    hilo1.free_space();
                    
                    hilo2.set_Pro_per_Day(hilo2.Pro_per_Day-1);
                    hilo2.free_space();
                    hilo3.set_Pro_per_Day(hilo3.Pro_per_Day-1);
                    hilo3.free_space();
                    hilo4.set_Pro_per_Day(hilo4.Pro_per_Day-1);
                    hilo4.free_space();
                    hilo5.set_Pro_per_Day(hilo5.Pro_per_Day-1);
                    hilo5.free_space();
                    
                    System.out.println("Se ensamblo "+capitulo+" capitulos");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
        }
    }
}
