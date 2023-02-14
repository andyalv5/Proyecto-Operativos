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
public class Productor_Credito extends Thread{
    Semaphore drive_Credito;
    Semaphore s;
    
    public Productor_Credito(Semaphore drive_Credito, Semaphore s) {
        this.drive_Credito=drive_Credito;
        this.s=s;
    }
     @Override
    public void run(){
        while(true){
            
        }
    }  
}
