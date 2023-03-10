/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


import Interfaces.Dashboard;
import Interfaces.Dashboard1;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
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
    public static volatile boolean keepDir = true;
    
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
    
//    Indica que está haciendo el director en el jlabel específico de la interfaz que se le pase
    javax.swing.JLabel DirectorHaciendo;
    
    
//    Indica la cantidad de capitulos despachados en el anterior lote del rodaje/interfaz que se le pase
    javax.swing.JLabel LoteAntCapsJlabel;
    int CapitulosIgnorados = 0;
    int CapitulosDelAnteriorRodaje;
    
//    Jlabel que vamos a leer para poder hacer las operaciones escritas arriba
    javax.swing.JLabel EnsambladoTxt;
    
    
//    Semaforos entre el rodaje de jose y andy
    
//    El semaforo que andy utiliza para avisarle a jose que llegó
    public static Semaphore HolaJoseYaLlegue = new Semaphore(0);
    
//    El semaforo que jose utiliza para avisarle a andy que llegó
    public static Semaphore HolaAndyYaLlegue = new Semaphore(0);
    
    javax.swing.JLabel SueldoPorHoraPMJlabel;
    
//    boolean DirectorEstaDespedido;
    
    public Director(Project_manager pm, String rodaje, javax.swing.JTextField Contador_inter, javax.swing.JLabel Veces_PM_atrapado, javax.swing.JLabel beneficios_text, javax.swing.JLabel costos_text, javax.swing.JLabel Es_el_mejor, javax.swing.JLabel texto1, javax.swing.JLabel texto2, javax.swing.JLabel texto3, javax.swing.JLabel series_Entregadas, javax.swing.JLabel ingresos_generales ,javax.swing.JLabel costos_generales_reales,int id, javax.swing.JLabel DirectorHaciendo, javax.swing.JLabel LoteAntCapsJlabel, javax.swing.JLabel EnsambladoTxt, javax.swing.JLabel SueldoPorHoraPMJlabel){
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
        
        this.LoteAntCapsJlabel = LoteAntCapsJlabel;
        
        this.EnsambladoTxt = EnsambladoTxt;
        
        this.SueldoPorHoraPMJlabel = SueldoPorHoraPMJlabel;
        
//        this.DirectorEstaDespedido = DirectorEstaDespedido;
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
        
        this.cap_entregados = this.cap_entregados + 1;
        if(this.rodaje.equalsIgnoreCase("andy")){
//            System.out.println("Toca el reseteo a andy");
//            System.out.println("");
//            Proyecto_operativos.contador_dias_restantes_andy = Proyecto_operativos.dias_entre_despachos;
//            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));

//            this.cap_entregados=this.cap_entregados+1;
            Proyecto_operativos.contador_dias_restantes_andy = JSONReaderWriter.dias_entre_despachos;
            this.Contador_inter.setText(String.valueOf(Proyecto_operativos.contador_dias_restantes_andy));
        }else{
//            this.cap_entregados=this.cap_entregados+1;
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
     * @throws java.lang.InterruptedException
     * @throws java.io.FileNotFoundException
     */
    public void StopIfNroSeries_Rodaje_Es0() throws InterruptedException, FileNotFoundException{
        if(this.rodaje.equalsIgnoreCase("andy")){
//            Proyecto_operativos.keep = false;
             Director.NroSeries_Andy = this.Restar_NroSeries_Rodaje(Director.NroSeries_Andy);
            
//             System.out.println("Hola broski, este el nro de series actuales: de andy" + Director.NroSeries_Andy);
             
        }else{
            
             Director.NroSeries_Jose = this.Restar_NroSeries_Rodaje(Director.NroSeries_Jose);
             
//             System.out.println("Hola broski, este el nro de series actuales: de jose" + Director.NroSeries_Andy);
        }
        
        if(Director.NroSeries_Andy == 0 || Director.NroSeries_Jose == 0){
            
//            Proyecto_operativos.contador_dias_restantes = Proyecto_operativos.dias_entre_despachos;
            this.ingresos_generales_num=Integer.parseInt(String.valueOf(this.ingresos_generales.getText()));

            this.costos_generales_num=costos_generales_num+Float.parseFloat(String.valueOf(this.costos_text.getText()));
            this.beneficios_generales_num= (beneficios_generales_num+this.ingresos_generales_num-costos_generales_num)/10;
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
            
//            System.out.println("-----------------||||---------||||-------");
            
            
            
            
//            float ingresosOperacion = this.beneficios_generales_num - this.costos_generales_num;
////                int ingresos_string = (int) ingresosOperacion;                                
//            int ingresos = (int) ingresosOperacion;
//            int costos = (int) (this.costos_generales_num);
            
            
//            if(this.rodaje.equalsIgnoreCase("andy")){
//                
////                Verifica si jose llegó a su parte
//                this.HolaAndyYaLlegue.acquire();
//                float ingresosOperacion = this.beneficios_generales_num - this.costos_generales_num;
//    //                int ingresos_string = (int) ingresosOperacion;                                
//                int ingresos = (int) ingresosOperacion;
//                int costos = (int) (this.costos_generales_num);
//                
//                
//                JSONReaderWriter.Ingresos_Rodaje_andy = ingresos;
//                JSONReaderWriter.Costos_Rodaje_andy = costos;
//                
//                JSONReaderWriter jsnrw = new JSONReaderWriter();
//                
//                System.out.println("VOY A ESCRIBIR");
//                jsnrw.Writer(String.valueOf(JSONReaderWriter.dia_en_segundos), String.valueOf(JSONReaderWriter.dias_entre_despachos), String.valueOf(JSONReaderWriter.parte_intro_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_intro), String.valueOf(JSONReaderWriter.parte_creditos_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_creditos), String.valueOf(JSONReaderWriter.parte_inicio_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_inicio), String.valueOf(JSONReaderWriter.parte_cierre_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_cierre), String.valueOf(JSONReaderWriter.parte_plot_twist_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_plot_twist), String.valueOf(JSONReaderWriter.Productor_Intros_jose), String.valueOf(JSONReaderWriter.Productor_Creditos_jose), String.valueOf(JSONReaderWriter.Productor_Inicio_jose), String.valueOf(JSONReaderWriter.Productor_cierre_jose), String.valueOf(JSONReaderWriter.Productor_Plot_Twist_jose), String.valueOf(JSONReaderWriter.Productor_Intros_andy), String.valueOf(JSONReaderWriter.Productor_Creditos_andy), String.valueOf(JSONReaderWriter.Productor_Inicio_andy), String.valueOf(JSONReaderWriter.Productor_cierre_andy), String.valueOf(JSONReaderWriter.Productor_Plot_Twist_andy), String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_jose), String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_andy), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_jose), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_andy), String.valueOf(JSONReaderWriter.Costos_Rodaje_jose), String.valueOf(JSONReaderWriter.Costos_Rodaje_andy));
//                
//                System.out.println("VOY A LEEER ----------------------------");
//                
//                jsnrw.Reader();
//                
//                System.out.println("INTENTANDO PARA ESTA BROMA --------------------------------");
//                Proyecto_operativos.keep = false;
//                Director.keepDir = false;
//                
////                Le avisa a José que ya llegó
//                this.HolaJoseYaLlegue.release();
//                
//                
//            }else{
////                int ingresos = Integer.parseInt(String.valueOf(this.beneficios_generales_num - this.costos_generales_num));
////                int costos = Integer.parseInt(String.valueOf(this.costos_generales_num));
//                float ingresosOperacion = this.beneficios_generales_num - this.costos_generales_num;
//    //                int ingresos_string = (int) ingresosOperacion;                                
//                int ingresos = (int) ingresosOperacion;
//                int costos = (int) (this.costos_generales_num);
//                
//                JSONReaderWriter.Ingresos_Rodaje_jose = ingresos;
//                JSONReaderWriter.Costos_Rodaje_jose = costos;
//                
////                Le avisa a Andy que ya llegó a su parte
//                this.HolaAndyYaLlegue.release();
//                this.HolaJoseYaLlegue.acquire();
//                
//                
//            }
            
//            System.out.println( "> " + JSONReaderWriter.Ingresos_Rodaje_jose + JSONReaderWriter.Ingresos_Rodaje_andy + JSONReaderWriter.Costos_Rodaje_jose + JSONReaderWriter.Costos_Rodaje_andy);

            
            
//            System.out.println("-----------------||||---------||||-------");
            
            
            float ingresosFloat = this.beneficios_generales_num - this.costos_generales_num;
            float costosFloat = this.costos_generales_num;     
            
            int ingresos = (int) ingresosFloat;
            int costos = (int) costosFloat;
            
            if(rodaje.equalsIgnoreCase("andy")){
                
                Director.HolaAndyYaLlegue.acquire();
                
                JSONReaderWriter.Ingresos_Rodaje_andy = ingresos;
                JSONReaderWriter.Costos_Rodaje_andy = costos;
                
                JSONReaderWriter jsrw = new JSONReaderWriter();
                
                jsrw.Writer(String.valueOf(JSONReaderWriter.dia_en_segundos), String.valueOf(JSONReaderWriter.dias_entre_despachos), String.valueOf(JSONReaderWriter.parte_intro_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_intro), String.valueOf(JSONReaderWriter.parte_creditos_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_creditos), String.valueOf(JSONReaderWriter.parte_inicio_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_inicio), String.valueOf(JSONReaderWriter.parte_cierre_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_cierre), String.valueOf(JSONReaderWriter.parte_plot_twist_max), String.valueOf(JSONReaderWriter.Capacidad_infinita_plot_twist), String.valueOf(JSONReaderWriter.Productor_Intros_jose), String.valueOf(JSONReaderWriter.Productor_Creditos_jose), String.valueOf(JSONReaderWriter.Productor_Inicio_jose), String.valueOf(JSONReaderWriter.Productor_cierre_jose), String.valueOf(JSONReaderWriter.Productor_Plot_Twist_jose), String.valueOf(JSONReaderWriter.Productor_Intros_andy), String.valueOf(JSONReaderWriter.Productor_Creditos_andy), String.valueOf(JSONReaderWriter.Productor_Inicio_andy), String.valueOf(JSONReaderWriter.Productor_cierre_andy), String.valueOf(JSONReaderWriter.Productor_Plot_Twist_andy), String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_jose),String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_andy), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_jose), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_andy), String.valueOf(JSONReaderWriter.Costos_Rodaje_jose), String.valueOf(JSONReaderWriter.Costos_Rodaje_andy));
                jsrw.Reader();
                
                Director.HolaJoseYaLlegue.release();
                
                
            }else{
                
                JSONReaderWriter.Ingresos_Rodaje_jose = ingresos;
                JSONReaderWriter.Costos_Rodaje_jose = costos;
                
                Director.HolaAndyYaLlegue.release();
                Director.HolaJoseYaLlegue.acquire();
            }
            
            Proyecto_operativos.keep = false;
            Director.keepDir = false;
            
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
//        Sueldo por hora del PM 2/2
        float temp1 = Float.parseFloat(String.valueOf(this.sueldo_al_payaso)) / 24;            
        this.SueldoPorHoraPMJlabel.setText(String.valueOf(temp1));

        
        while(keepDir){
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
                        vandy.start();

                            do{
                                cachado();                 

                            }while(Director.vigila_andy);

                        }else{
                            Director.vigila_jose = true;
                            VigilandoJose vjose = new VigilandoJose(random);


                            vjose.start();

                            do{                            
                                cachado();                
                            
                            }while(Director.vigila_jose);
                        
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
                    }else if(pm.Contador_dias_restantes_rodaje() == 0 ){
                    
                    
                   
                    this.DirectorHaciendo.setText("Entregando serie");
                    this.resetear_contador_dias_restantes_rodaje();
                    this.DirectorHaciendo.setText("Series entregadas");
                    
                    
                    
//                    --------------------------------------------

//                    Proyecto_operativos.Contador.release();
                    pm.Semaforo_Contador_release();
                    
                    this.Falsear_Director_nuevo_dia_rodaje();
                    
//                    Aqui se pone la cantidad de capitulos hechos en el anterior rodaje 
                    int temp = Integer.parseInt(this.EnsambladoTxt.getText());
                    this.CapitulosDelAnteriorRodaje = temp - this.CapitulosIgnorados;
                    this.CapitulosIgnorados = temp;
//                    Se pone el numero de capitulos despachados de la serie anterior en la respectiva interfaz
                    this.LoteAntCapsJlabel.setText(String.valueOf(this.CapitulosDelAnteriorRodaje));
                     
//                    Revisa cuantas series faltan por hacer, si ya se hicieron todas, para la simulación
                    this.StopIfNroSeries_Rodaje_Es0();
//                    Proyecto_operativos.keep=false;
                                        
                }else{
                    this.DirectorHaciendo.setText("Ya hizo todo por hoy");
                    pm.Semaforo_Contador_release();
                }
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
   
    /*
    Revisa si el PM está viendo RyM
    */
    public void cachado() throws InterruptedException{
        this.Semaforo_RM_acquire();
        if(this.pm.Rick_y_Morty == true){
            this.Semaforo_RM_release();
            this.DirectorHaciendo.setText("pilló al PM y está restandole el sueldo");
            
//            System.out.println("Director: Te vi menooor");
            
//            Medimos las horas que tarda el Director 12-18 horas aleatoriamente
            int random2 = (int)(Math.random()*Proyecto_operativos.dia_en_ms*6/24 + Proyecto_operativos.dia_en_ms*12/24);
            
            Thread.sleep(random2);
            
            this.sueldo_al_payaso = sueldo_al_payaso-1;
            
//            Sueldo por hora del PM 2/2
            float temp = Float.parseFloat(String.valueOf(this.sueldo_al_payaso)) / 24;            
            this.SueldoPorHoraPMJlabel.setText(String.valueOf(temp));
            
            
            //Se agrega +1 a las veces que fue descubierto flojeando al Project_manager
//            Project_manager.Veces_descubierto_flojeando++;
            this.Sumar_veces_descubierto_flojeando_rodaje();
            
            
        }else{
            this.Semaforo_RM_release();
            this.DirectorHaciendo.setText("Dejó de vigilar al PM");
//            System.out.println("Director: A la proxima te veo >.>");

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
                
                    
//                System.out.println(rodaje + " " + !Proyecto_operativos.DirectorEstaDespedido_jose);

                Project_manager.Veces_descubierto_flojeando_jose++;
                this.Veces_PM_atrapado.setText(String.valueOf(Project_manager.Veces_descubierto_flojeando_jose));
                
                
            
        }
        
    }
}
