/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Interfaces.Dashboard;
import Interfaces.Dashboard1;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.awt.Color;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto_operativos.Proyecto_operativos;


/**
 *
 * @author Hallo
 */
public class Director extends Thread{
//    Estas variables random las pienso usar para calculos futuros
    public static boolean vigila_andy;
    public static boolean vigila_jose;
    int random;
    int random2;
    float com;
    public int ganancia;
    public int sueldo_al_payaso =(7*24);
    private int  ingresos_generales_num;
    private float costos_generales_num;
    private float beneficios_generales_num;
    javax.swing.JLabel  ingresos_generales;
    javax.swing.JLabel costos_generales_reales;
    private int es_el_mejor;
    private int cap_entregados;
    javax.swing.JLabel costos_text;
    javax.swing.JLabel beneficios_text;
    javax.swing.JLabel text1;
    javax.swing.JLabel text2;
    javax.swing.JLabel text3;
    javax.swing.JLabel es_elmejor;
    javax.swing.JLabel capitulos_entregados;
    private int id;
    
    private static Semaphore LlegoJose = new Semaphore(0);
    private static Semaphore LlegoAndy = new Semaphore(0);
    
    
    
//    Variable que indica si el director está en un nuevo dia
//    public static volatile boolean Director_nuevo_dia = false;
    public static volatile boolean Director_nuevo_dia_andy = false;
    public static volatile boolean Director_nuevo_dia_jose = false;
    
    Project_manager pm;
    
//    Solo puede o ser "jose" o "andy"
    String rodaje;
//    boolean keep = true;
    
//    El Project Manager que el director vigila
    
    public javax.swing.JTextField Contador_inter;
    
//    Variable de la interfaz que el director cambiará
    javax.swing.JLabel Veces_PM_atrapado;
    
    public static volatile int NroSeries_Andy;
    public static volatile int NroSeries_Jose;
    
    javax.swing.JLabel DirectorHaciendo;
    
    public Director(Project_manager pm, String rodaje, javax.swing.JTextField Contador_inter, javax.swing.JLabel Veces_PM_atrapado, javax.swing.JLabel beneficios_text, javax.swing.JLabel costos_text, javax.swing.JLabel Es_el_mejor, javax.swing.JLabel texto1, javax.swing.JLabel texto2, javax.swing.JLabel texto3, javax.swing.JLabel series_Entregadas, javax.swing.JLabel ingresos_generales ,javax.swing.JLabel costos_generales_reales,int id, javax.swing.JLabel DirectorHaciendo){
        this.pm = pm;
        this.rodaje = rodaje;
        this.Contador_inter = Contador_inter;
        this.Veces_PM_atrapado = Veces_PM_atrapado;
      
        this.text1= texto1;
        this.text2= texto2;
        this.text3 = texto3;
        this.beneficios_text= beneficios_text;
        this.costos_text= costos_text;
        this.capitulos_entregados = series_Entregadas;
        this.es_elmejor = Es_el_mejor;
        this.ingresos_generales= ingresos_generales;
        this.costos_generales_reales= costos_generales_reales;
        this.id=id;
        
        this.DirectorHaciendo = DirectorHaciendo;
        
    }
    
     private void SincronizarRodajes() throws InterruptedException{
        
        if(this.rodaje.equalsIgnoreCase("andy")){
//            Avisa al rodaje de jose que llegó al punto
            Director.LlegoAndy.release();
//            Espera a que José ya halla llegado
//            System.out.println("Voy a esperar a José ----------------");
            Director.LlegoJose.acquire();
            
        }else{
//            Avisa al rodaje de jose que llegó al punto
            Director.LlegoJose.release();
//            Esperando a que Andy ya halla llegado
//            System.out.println("Voy a esperar a Andy --------------------");
            Director.LlegoAndy.acquire();
        }
    }
    
    
    
    /**
     * Hace un acquire del semaforo de su respectivo rodaje
     * @throws InterruptedException 
     */
    public void Semaforo_RM_acquire() throws InterruptedException{
        if(this.rodaje.equalsIgnoreCase("andy")){
            
            Proyecto_operativos.Director_PM_Semaphore_andy.acquire();
            
        }else{
            
            Proyecto_operativos.Director_PM_Semaphore_jose.acquire();
        }
    }
    
    /**
     * Hace un release del semaforo de su respectivo rodaje
     * @throws InterruptedException 
     */
    public void Semaforo_RM_release() throws InterruptedException{
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            Proyecto_operativos.Director_PM_Semaphore_andy.release();
        }else{
            Proyecto_operativos.Director_PM_Semaphore_jose.release();
        }
    }
    
    /**
     * Resetea el contador de dias restantes para el respectivo rodaje
     */
    public void resetear_contador_dias_restantes_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
//            System.out.println("Toca el reseteo a andy");
//            System.out.println("");
//            Proyecto_operativos.contador_dias_restantes_andy = Proyecto_operativos.dias_entre_despachos;
//            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));

            this.cap_entregados=this.cap_entregados+1;
            Proyecto_operativos.contador_dias_restantes_andy = JSONReaderWriter.dias_entre_despachos;
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));
        }else{
            this.cap_entregados=this.cap_entregados+1;
            Proyecto_operativos.contador_dias_restantes_jose = JSONReaderWriter.dias_entre_despachos;
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_jose));
        }
    }
        
    
    /**
     * 
     * @return el valor de si paso un nuevo dia en su respectivo rodaje
     */
    public boolean Director_nuevo_dia_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            
            return Director.Director_nuevo_dia_andy;
            
        }else{
            
            return Director.Director_nuevo_dia_jose;
            
        }
    }
    
    
    /**
     * Vuelve falso a que pasó un nuevo en su rodaje respectivo
     */
    public void Falsear_Director_nuevo_dia_rodaje(){
        if(this.rodaje.equalsIgnoreCase("andy")){
            
            Director.Director_nuevo_dia_andy = false;
            
        }else{
            
            Director.Director_nuevo_dia_jose = false;
            
        }        
    }
    
    /**
     * Para el proceso si ya se hicieron el NroSeries_Rodaje, de lo contrario, le resta en 1
     */
    public void StopIfNroSeries_Rodaje_Es0() throws InterruptedException{
        if(this.rodaje.equalsIgnoreCase("andy")){
            
             Director.NroSeries_Andy = this.Restar_NroSeries_Rodaje(Director.NroSeries_Andy);
            
             System.out.println("Hola broski, este el nro de series actuales: de andy" + Director.NroSeries_Andy);
             
        }else{
            
             Director.NroSeries_Jose = this.Restar_NroSeries_Rodaje(Director.NroSeries_Jose);
             
             System.out.println("Hola broski, este el nro de series actuales: de jose" + Director.NroSeries_Andy);
        }
        
        if(Director.NroSeries_Andy == 0 || Director.NroSeries_Jose == 0){
            
//            Proyecto_operativos.contador_dias_restantes = Proyecto_operativos.dias_entre_despachos;
            this.ingresos_generales_num=Integer.parseInt(String.valueOf(this.ingresos_generales.getText()));

            this.costos_generales_num=costos_generales_num+Float.parseFloat(String.valueOf(this.costos_text.getText()));
            this.beneficios_generales_num= beneficios_generales_num+this.ingresos_generales_num-costos_generales_num;
            this.costos_generales_reales.setText(String.valueOf(this.costos_generales_num));
            this.beneficios_text.setText(String.valueOf(this.beneficios_generales_num));
            this.capitulos_entregados.setText(String.valueOf(this.cap_entregados));
            this.text1.setForeground(Color.black);
            this.text2.setForeground(Color.black);
            this.text3.setForeground(Color.black);
            this.costos_generales_reales.setForeground(Color.black);
            this.capitulos_entregados.setForeground(Color.black);
            this.beneficios_text.setForeground(Color.black);


            if (id ==0){
               Dashboard1.semaforo_final.release();
               Dashboard.comparacion =beneficios_generales_num;
               com = Dashboard.comparacion;
               Dashboard.semaforo_final.acquire();


            }
            else if(id==1){
                Dashboard.semaforo_final.release();
                Dashboard1.comparacion =beneficios_generales_num;
                com = Dashboard1.comparacion;
                Dashboard1.semaforo_final.acquire();

            }
            if (id ==0 && com < Dashboard1.comparacion){
                this.es_elmejor.setText("No es la mejor >:(");
            }

            if (id ==1 && com < Dashboard.comparacion){

                this.es_elmejor.setText("No es la mejor >:(");
            }
            this.es_elmejor.setForeground(Color.red);
            
            
            
            
            Proyecto_operativos.keep = false;
        }
        
        
    }
    
    /**
     * Resta en uno el valor entero que se le otorgue si se cumple que es > 0
     * @param NroSeries_rodaje
     * @return El valor recibido -1 SI ESE VALOR es > 0, de lo contrario, retorna el mismo valor 
     */
    private int Restar_NroSeries_Rodaje(int NroSeries_rodaje){
        
        if(NroSeries_rodaje > 0){
//            System.out.println("Hola broski, este el nro de series actuales: " + NroSeries_rodaje);
//            System.out.println("Hola broski, este el nro de series actuales: " + NroSeries_rodaje);
                NroSeries_rodaje = NroSeries_rodaje  - 1;                                
            return NroSeries_rodaje;
        }else{
            return NroSeries_rodaje;
        }
    }
    
    @Override
    public void run(){
        
        
        while(Proyecto_operativos.keep){
            try {
                
//                Proyecto_operativos.Contador.acquire();
                pm.Semaforo_Contador_acquire();
                
                if(pm.Contador_dias_restantes_rodaje() != 0 && this.Director_nuevo_dia_rodaje()){
                    
//                    Proyecto_operativos.Contador.release();
                    pm.Semaforo_Contador_release();
                    
//                    Director.Director_nuevo_dia = false;
                    Falsear_Director_nuevo_dia_rodaje();
                    
//                    genera un numero random de 30 a 90 min en base al día establecido
                   int random = (int)(Math.random()*((double)(Proyecto_operativos.dia_en_ms)/24 + (double)(Proyecto_operativos.dia_en_ms)/24/60) + (double)(Proyecto_operativos.dia_en_ms)/24/2);
                    
//                    Se prepara para ver en el periodo aleatorio calculado de tiempo
                    this.DirectorHaciendo.setText("va a vigilar PM");
                    
 //                   Thread.sleep(random);
                    
    //                Agregamos semaforo a la sección critica
//                    Proyecto_operativos.Director_PM_Semaphore.acquire();
    //                Llamamos al metodo "cachado"
                    
    
                    
                    if(rodaje.equalsIgnoreCase("andy")){
                        Director.vigila_andy = true;
                        VigilandoAndy vandy = new VigilandoAndy(random);
                    }else if(this.rodaje.equalsIgnoreCase("jose") && Director.NroSeries_Jose != 0){
                        
                    }else{
                        
//    //                    Proyecto_operativos.contador_dias_restantes = Proyecto_operativos.dias_entre_despachos;
//                        this.ingresos_generales_num=Integer.parseInt(String.valueOf(this.ingresos_generales.getText()));
//
//                        this.costos_generales_num=costos_generales_num+Float.parseFloat(String.valueOf(this.costos_text.getText()));
//                        this.beneficios_generales_num= beneficios_generales_num+this.ingresos_generales_num-costos_generales_num;
//                        this.costos_generales_reales.setText(String.valueOf(this.costos_generales_num));
//                        this.beneficios_text.setText(String.valueOf(this.beneficios_generales_num));
//                        this.cap_entregados=this.cap_entregados+1;
//                        this.capitulos_entregados.setText(String.valueOf(this.cap_entregados));
//                        this.text1.setForeground(Color.black);
//                        this.text2.setForeground(Color.black);
//                        this.text3.setForeground(Color.black);
//                        this.costos_generales_reales.setForeground(Color.black);
//                        this.capitulos_entregados.setForeground(Color.black);
//                        this.beneficios_text.setForeground(Color.black);
//
//
//                        if (id ==0){
//                           Dashboard1.semaforo_final.release();
//                           Dashboard.comparacion =beneficios_generales_num;
//                           com = Dashboard.comparacion;
//                           Dashboard.semaforo_final.acquire();
//
//
//                        }
//                        else if(id==1){
//                            Dashboard.semaforo_final.release();
//                            Dashboard1.comparacion =beneficios_generales_num;
//                            com = Dashboard1.comparacion;
//                            Dashboard1.semaforo_final.acquire();
//
//                        }
//                        if (id ==0 && com < Dashboard1.comparacion){
//                            this.es_elmejor.setText("No es la mejor >:(");
//                        }
//
//                        if (id ==1 && com < Dashboard.comparacion){
//
//                            this.es_elmejor.setText("No es la mejor >:(");
//                        }
//                        this.es_elmejor.setForeground(Color.red);
                    }
                    
                    
                    
                   
                    this.DirectorHaciendo.setText("Entregando serie");
                    this.resetear_contador_dias_restantes_rodaje();
                    this.DirectorHaciendo.setText("Series entregadas");
                    
                    
                    
//                    --------------------------------------------

//                    Proyecto_operativos.Contador.release();
                    pm.Semaforo_Contador_release();
                    
                    this.Falsear_Director_nuevo_dia_rodaje();
                    
//                    Revisa cuantas series faltan por hacer, si ya se hicieron todas, para la simulación
                    this.StopIfNroSeries_Rodaje_Es0();
//                    Proyecto_operativos.keep=false;
                                        
                }else{
                    
                    pm.Semaforo_Contador_release();
                }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
   
    /*
    Revisa si el PM está viendo RyM
    */
    public void cachado() throws InterruptedException{
        
        if(this.pm.Rick_y_Morty == true){
            
            this.DirectorHaciendo.setText("pilló al PM y está restandole el sueldo");
            
            System.out.println("Director: Te vi menooor");
            
//            Medimos las horas que tarda el Director 12-18 horas aleatoriamente
            int random2 = (int)(Math.random()*Proyecto_operativos.dia_en_ms*6/24 + Proyecto_operativos.dia_en_ms*12/24);
            
            Thread.sleep(random2);
            
            this.sueldo_al_payaso = sueldo_al_payaso-1;
            
            //Se agrega +1 a las veces que fue descubierto flojeando al Project_manager
//            Project_manager.Veces_descubierto_flojeando++;
            this.Sumar_veces_descubierto_flojeando_rodaje();
            
            
        }else{
            
            this.DirectorHaciendo.setText("Dejó de vigilar al PM");
            System.out.println("Director: A la proxima te veo >.>");

        }
    }
    
    /**
     * Le suma las veces que fue descubierto al PM del rodaje respectivo
     */
    public void Sumar_veces_descubierto_flojeando_rodaje(){
        
        if(this.rodaje.equalsIgnoreCase("andy")){
            Project_manager.Veces_descubierto_flojeando_andy++;
            this.Veces_PM_atrapado.setText(String.valueOf(Project_manager.Veces_descubierto_flojeando_andy));
        }else{
            Project_manager.Veces_descubierto_flojeando_jose++;
            this.Veces_PM_atrapado.setText(String.valueOf(Project_manager.Veces_descubierto_flojeando_jose));
        }
    }
}
