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
import Interfaces.Dashboard;
import static Interfaces.Dashboard.hilo6;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Andy
 */
public class Ensamblador extends Thread{
    private int ganancia_Velma;
    
    public int get_ganancia_velma(){
        return this.ganancia_Velma;
    }
    
    private int dinero;
    public int ganancia;
    private int capitulo_Counter;
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
    public int ensambladores;
    Semaphore s;
    Semaphore o;
    Semaphore p;
    Semaphore q;
    Semaphore r;
    
    
    
    public Ensamblador(Productores_Intro hilo1,Productor_Cierre hilo2,Productor_Inicio hilo3,Productor_Credito hilo4,Productor_Plot_Twist hilo5, Semaphore s,Semaphore o,Semaphore p, Semaphore q,Semaphore r,int dinero) {
     this.hilo1= hilo1;
     this.hilo2= hilo2;
     this.hilo3= hilo3;
     this.hilo4= hilo4;
     this.hilo5= hilo5;
     this.s=s;
     this.o=o;
     this.p=p;
     this.q=q;
     this.r=r;
     this.capitulo_Counter=5;
     this.dinero=dinero;
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
    
    public void set_Productores(int productores){
        this.ensambladores=productores;
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
                
                
                Thread.sleep(Proyecto_operativos.dia_en_ms);
                
                Thread.sleep(Proyecto_operativos.dia_en_ms);
                if(intro_Prod>0 && inicio_Prod>0 && cierre_Prod>0 && Plot_Twist_Prod>0 && Credito_Prod>0 && ensambladores>0){
                    hilo1.empty.acquire(2);
                    hilo2.empty.acquire(1);
                    hilo3.empty.acquire(1);
                    hilo4.empty.acquire(2);
                    hilo5.empty.acquire(1);
                    s.acquire();
                    o.acquire();
                    p.acquire();
                    q.acquire();
                    r.acquire();
                    for (int i = 0;i < Math.min(ensambladores , Math.min(intro_Prod, Math.min(inicio_Prod, Math.min(cierre_Prod, Math.min(Plot_Twist_Prod, Credito_Prod)))));i++){
                        capitulo = capitulo+1;
                        Dashboard.Jtext_Productores_Ensamblado.acquire();
                        this.ganancia_Velma= ganancia_Velma +((dinero*100000)/150);
                        Dashboard.Jtext_Productores_Ensamblado.release();
                        
                        hilo1.free_space(2);
                        hilo1.set_Pro_per_Day(hilo1.Pro_per_Day-1);
                        if (hilo1.get_Pro_per_Day()-1<0){
                            hilo1.set_Pro_per_Day(0);
                        }
                        else{
                            hilo1.set_Pro_per_Day(hilo1.Pro_per_Day-1);
                        }
                        
                        
                        
                        hilo2.free_space(1);
                        hilo2.set_Pro_per_Day(hilo2.Pro_per_Day-1);
                        
                       
                        
                        hilo3.free_space(1);
                        hilo3.set_Pro_per_Day(hilo3.Pro_per_Day-1);
                        
                      
                        
                        hilo4.free_space(2);
                        hilo4.set_Pro_per_Day(hilo4.Pro_per_Day-1);
                        if (hilo4.get_Pro_per_Day()-1<0){
                            hilo4.set_Pro_per_Day(0);
                        }
                        else{
                            hilo4.set_Pro_per_Day(hilo4.Pro_per_Day-1);
                        }
                        
                        
                        
                       capitulo_Counter= capitulo_Counter-1;
                       System.out.println("///////////////////////"+capitulo_Counter);
                        if (this.capitulo_Counter==0){
                            hilo5.free_space(1);
                            hilo5.set_Pro_per_Day(hilo5.Pro_per_Day-1);
                            
                            capitulo_Counter =5;
                        }
                        
                        System.out.println("Se ensamblo "+capitulo+" capitulos");
                        
                    }
                    
                    
                    
                    r.release();
                    q.release();
                    p.release();
                    o.release();    
                    s.release();
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Ensamblador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             
        }
    }
}
