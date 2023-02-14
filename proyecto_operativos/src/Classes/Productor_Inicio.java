/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Andy
 */
public class Productor_Inicio extends Thread{
    Semaphore drive_Inicio;
    Semaphore s;
    
    public Productor_Inicio(Semaphore drive_Inicio, Semaphore s) {
        this.drive_Inicio=drive_Inicio;
        this.s=s;
    }
     @Override
    public void run(){
        while(true){
            
        }
    }  
    
}
