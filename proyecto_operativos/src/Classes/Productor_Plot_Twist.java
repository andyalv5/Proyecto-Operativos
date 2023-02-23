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
public class Productor_Plot_Twist extends Thread{
    public int ganancia;
    public int productores;
    private int max_Drive;
    private int num;
    public int Pro_per_Day;
    Semaphore drive_Plot_Twist;
    Semaphore s;
    Semaphore empty;
    
    public Productor_Plot_Twist(Semaphore drive_Plot_Twist,Semaphore empty,
            Semaphore s, int productores,int max_Drive,int num) {
        this.drive_Plot_Twist=drive_Plot_Twist;
        this.s=s;
        this.productores = productores;
        this.max_Drive= max_Drive;
        this.num=num;
        this.empty=empty;
    }
    
    public int get_Pro_per_Day(){
        return this.Pro_per_Day;
    }
    
    public void set_Pro_per_Day(int Pro_per_Day){
        this.Pro_per_Day = Pro_per_Day;
    }
    
    public void free_space(int num){        
        this.drive_Plot_Twist.release(num);
    }
    
    public int get_ganancia(){
        return this.ganancia;
    }
    
    public void set_ganancia(int ganancia){
        this.ganancia = ganancia;
    }
    
    /*
    
    */
    
    public void set_Productores(int productores){
        this.productores=productores;
    }
    
     @Override
    public void run(){
        while(Proyecto_operativos.keep){
                try {
                    this.drive_Plot_Twist.acquire(num);
                    Thread.sleep(Proyecto_operativos.dia_en_ms);
                    
                    
                        if(Pro_per_Day <max_Drive){
                            if(Proyecto_operativos.ci_Andy>=0 && Proyecto_operativos.ci_Andy<5){
                                
                                Thread.sleep((Proyecto_operativos.dia_en_ms));
                                
                                s.acquire();
                                if(Proyecto_operativos.keep != false){
                                    Pro_per_Day=Pro_per_Day+productores*(1);
                                }
                                s.release();
                                
                            }
                            else{
                                
                                Thread.sleep(2*Proyecto_operativos.dia_en_ms);
                                
                                Dashboard.Jtext_Productores_Plot_Twist.release();
                                s.acquire();
                                if(Proyecto_operativos.keep != false){
                                    Pro_per_Day=Pro_per_Day+productores*(1);
                                }
                                s.release();
                             
                            }
                        if(Pro_per_Day >max_Drive){
                            s.acquire();
                            if(Proyecto_operativos.keep != false){
                                Pro_per_Day =max_Drive;
                            }
                            s.release();
                        }
                        
                        if(Pro_per_Day <0){
                            s.acquire();
                            if(Proyecto_operativos.keep != false){
                                Pro_per_Day =0;
                            }
                            s.release();
                        }
                    System.out.println("Se hicieron "+Pro_per_Day+" plot twist");
                    empty.release(Pro_per_Day);
                    
                        
                    }
                        
                    

                } catch (InterruptedException ex) {
                    Logger.getLogger(Productores_Intro.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }  
}
