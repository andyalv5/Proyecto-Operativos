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
public class Productores_Intro extends Thread{
    Semaphore drive_Intro;
    Semaphore s;
    
    public Productores_Intro(Semaphore drive_Intro, Semaphore s) {
        this.drive_Intro=drive_Intro;
        this.s=s;
    }
    
    @Override
    public void run(){
        while(true){
            
        }
    }  
}
