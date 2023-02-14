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
public class Productor_Plot_Twist extends Thread{
    Semaphore drive_Plot_Twist;
    Semaphore s;
    
    public Productor_Plot_Twist(Semaphore drive_Plot_Twist, Semaphore s) {
        this.drive_Plot_Twist=drive_Plot_Twist;
        this.s=s;
    }
     @Override
    public void run(){
        while(true){
            
        }
    }  
}
