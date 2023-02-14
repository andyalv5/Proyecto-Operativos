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
public class Productor_Cierre extends Thread{
    Semaphore drive_Cierre;
    Semaphore s;
    
    public Productor_Cierre(Semaphore drive_Cierre, Semaphore s) {
        this.drive_Cierre=drive_Cierre;
        this.s=s;
    }
    @Override
    public void run(){
        while(true){
            
        }
    }
   
}
