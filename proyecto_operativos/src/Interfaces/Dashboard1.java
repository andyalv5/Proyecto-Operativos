/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Director;
import Classes.Ensamblador;
import Classes.Ensamblador1;
import Classes.Pago;
import Classes.Pago1;
import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
import Classes.Project_manager;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Andy
 */
public class Dashboard1 extends javax.swing.JFrame {
    private Timer t1;
    public ActionListener ac1;
    
//    Final cédula de Andy 
    public int ci_jose = Proyecto_operativos.ci_jose;
    
    //    Tamaños diferentes en el drive
    public static int tamanio_Intro1 = JSONReaderWriter.parte_intro_max;
    public static int tamanio_credito1 = JSONReaderWriter.parte_creditos_max;
    public static int tamanio_Inicio1 = JSONReaderWriter.parte_inicio_max;
    public static int tamanio_Cierre1 = JSONReaderWriter.parte_cierre_max;
    public static int tamanio_Plot_Twist1 = JSONReaderWriter.parte_plot_twist_max;
    
//    Semaforos para cada tamaño diferente en el drive
    public static Semaphore drive_Intro1 = new Semaphore(tamanio_Intro1);
    public static Semaphore drive_credito1 = new Semaphore(tamanio_credito1);
    public static Semaphore drive_Inicio1 = new Semaphore(tamanio_Inicio1);
    public static Semaphore drive_Cierre1 = new Semaphore(tamanio_Cierre1);
    public static Semaphore drive_Plot_Twist1 = new Semaphore(tamanio_Plot_Twist1);
    
    public static Semaphore semaforo_s1 = new Semaphore(1);
    public static Semaphore semaforo_com1 = new Semaphore(1);
    public static Semaphore semaforo_ini1 = new Semaphore(1);
    public static Semaphore semaforo_con1 = new Semaphore(1);
    public static Semaphore semaforo_PT1 = new Semaphore(1);
    public static Semaphore semaforo_cie1 = new Semaphore(1);
    public static Semaphore semaforo_intro1 = new Semaphore(1);
    
//    Semaforos para los JtextosFields
    public static Semaphore Jtext_Productores_Intro1 = new Semaphore(1);
    public static Semaphore Jtext_Productores_Credito1 = new Semaphore(1);
    public static Semaphore Jtext_Productores_Ensamblado1 = new Semaphore(1);
    public static Semaphore Jtext_Productores_Inicio1 = new Semaphore(1);
    public static Semaphore Jtext_Productores_Cierre1 = new Semaphore(1);
    public static Semaphore Jtext_Productores_Plot_Twist1 = new Semaphore(1);
    
    public static Productores_Intro Dhilo1 = new Productores_Intro(drive_Intro1, semaforo_intro1,1,tamanio_Intro1,1);
    public static Productor_Cierre Dhilo2 = new Productor_Cierre(drive_Cierre1, semaforo_cie1,1,tamanio_Cierre1,2);
    public static Productor_Inicio Dhilo3 = new Productor_Inicio(drive_Inicio1, semaforo_ini1,1,tamanio_Inicio1,2);
    public static Productor_Credito Dhilo4 = new Productor_Credito(drive_credito1, semaforo_con1,1,tamanio_credito1,1);
    public static Productor_Plot_Twist Dhilo5 = new Productor_Plot_Twist(drive_Plot_Twist1, semaforo_PT1,1,tamanio_Plot_Twist1);
    public static Ensamblador1 Dhilo6 = new Ensamblador1(Dhilo1,Dhilo2,Dhilo3,Dhilo4,Dhilo5,semaforo_intro1,semaforo_cie1,semaforo_ini1,semaforo_con1,semaforo_PT1,1100);
  
    
////    Aqui tengo el project manager trabajando con la cedula de andy
//    Project_manager pm_andy = new Project_manager(Proyecto_operativos.ci_Andy, "andy", this.Contador);
////    Aqui le indico al director de andy a que productor vigilar, y además, le indico que es el director de andy
//    Director dir_andy = new Director(this.pm_andy, "andy", this.Contador);

    
    /**
     * Creates new form Dashboard
     */
    public Dashboard1() {
        initComponents();
        
//        Se pone el valor inicial de la cantidad de productores ensamblados
        Cant_Productores_Ensamblado1.setText(String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_jose));
        
//        Teniendo la opción de capacidad de partes intro "infinita" 
        if(JSONReaderWriter.Capacidad_infinita_intro){
//            Si la capacidad es infinita, se pone el máximo con 9999
            progresoIntroBar1.setMaximum(9999);            
        }else{
//            Si la capacidad NO es infinita, se coloca el máximo establecido en el JSON
            progresoIntroBar1.setMaximum(tamanio_Intro1);            
        }
        
//        Teniendo la opción de capacidad de partes credito "infinita"
        if(JSONReaderWriter.Capacidad_infinita_creditos){
//            Si la capacidad es infinita, se pone el máximo con 9999            
            progresoCreditoBar1.setMaximum(9999);
        }else{
//            Si la capacidad NO es infinita, se coloca el máximo establecido en el JSON            
            progresoCreditoBar1.setMaximum(tamanio_credito1);            
        }
        
        
//        Teniendo la opción de capacidad de partes cierre "infinita"
        if(JSONReaderWriter.Capacidad_infinita_cierre){
//            Si la capacidad es infinita, se pone el máximo con 9999                        
            progresoCierreBar1.setMaximum(9999);
        }else{
//            Si la capacidad NO es infinita, se coloca el máximo establecido en el JSON                        
            progresoCierreBar1.setMaximum(tamanio_Cierre1);
        }
        
//        Teniendo la opción de capacidad de partes inicio "infinita"
        if(JSONReaderWriter.Capacidad_infinita_inicio){            
//            Si la capacidad es infinita, se pone el máximo con 9999                        
            progresoInicioBar1.setMaximum(9999);
        }else{            
//            Si la capacidad NO es infinita, se coloca el máximo establecido en el JSON                        
            progresoInicioBar1.setMaximum(tamanio_Inicio1);
        }
        
        
//        Teniendo la opción de capacidad de partes plot_twist "infinita"
        if(JSONReaderWriter.Capacidad_infinita_plot_twist){
//            Si la capacidad es infinita, se pone el máximo con 9999
            progresoPlotTwistBar1.setMaximum(9999);
        }else{            
//            Si la capacidad NO es infinita, se coloca el máximo establecido en el JSON                        
            progresoPlotTwistBar1.setMaximum(tamanio_Plot_Twist1);
        }
        
//        Ahora se lee de la clase JSONReaderWriter los valores iniciales de productores del rodaje a tratar
        Cant_Productores_Inicio.setText(String.valueOf(JSONReaderWriter.Productor_Inicio_jose));        
        Cant_Productores_Intro.setText(String.valueOf(JSONReaderWriter.Productor_Intros_jose));        
        Cant_Productores_Cierre.setText(String.valueOf(JSONReaderWriter.Productor_cierre_jose));        
        Cant_Productores_Credito.setText(String.valueOf(JSONReaderWriter.Productor_Creditos_jose));        
        Cant_Productores_PT.setText(String.valueOf(JSONReaderWriter.Productor_Plot_Twist_jose));        
        
//        El contador empieza con los dias entre despachos que indique el JSONReaderWriter
        Contador1.setText(String.valueOf(JSONReaderWriter.dias_entre_despachos));
        
    //    Aqui tengo el project manager trabajando con la cedula de jose
        Project_manager pm_jose = new Project_manager(Proyecto_operativos.ci_jose, "jose", this.Contador1);
    //    Aqui le indico al director de jose a que productor vigilar, y además, le indico que es el director de jose
        Director dir_jose = new Director(pm_jose, "jose", this.Contador1);
        
        Dhilo1.start();
        Dhilo2.start();
        Dhilo3.start();
        Dhilo4.start();
        Dhilo5.start();
        Dhilo6.start();
        pm_jose.start();
        dir_jose.start();
        
        Pago1 Dhilo7= new Pago1(pm_jose, dir_jose);
        Dhilo7.start();
        
    
        
        
        
            ac1 = new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e){
                    
                   
                    try {
                        semaforo_s1.acquire();
                        Dhilo1.set_Productores(Integer.parseInt(Cant_Productores_Intro.getText().toString()));
                        semaforo_s1.release();
                        
                        semaforo_cie1.acquire();
                        Dhilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                        semaforo_cie1.release();
                        
                        semaforo_ini1.acquire();
                        Dhilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                        semaforo_ini1.release();
                        
                        semaforo_con1.acquire();
                        Dhilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                        semaforo_con1.release();
                        
                        semaforo_PT1.acquire();
                        Dhilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                        semaforo_PT1.release();
                        
                        Dhilo6.set_Productores(Integer.parseInt(Cant_Productores_Ensamblado1.getText().toString()));
                        
                        semaforo_s1.acquire();
                        progresoIntroBar1.setValue(Dhilo1.get_Pro_per_Day());
                        intro_Quantity1.setText(String.valueOf(Dhilo1.get_Pro_per_Day()));
                        intro_ganancia11.setText(String.valueOf(Dhilo1.get_ganancia()));
                        Dhilo6.set_intro_Prod(Dhilo1.get_Pro_per_Day());
                        semaforo_s1.release();
                        
                        semaforo_cie1.acquire();
                        Dhilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                        progresoCierreBar1.setValue(Dhilo2.get_Pro_per_Day());
                        Cierre_Quantity1.setText(String.valueOf(Dhilo2.get_Pro_per_Day()));
                        cierre_ganancia13.setText(String.valueOf(Dhilo2.get_ganancia()));
                        Dhilo6.set_cierre_Prod(Dhilo2.get_Pro_per_Day());
                        semaforo_cie1.release();
                        
                        semaforo_ini1.acquire();
                        Dhilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                        progresoInicioBar1.setValue(Dhilo3.get_Pro_per_Day());
                        Inicio_Quantity1.setText(String.valueOf(Dhilo3.get_Pro_per_Day()));
                        inicio_ganancia14.setText(String.valueOf(Dhilo3.get_ganancia()));
                        Dhilo6.set_inicio_Prod(Dhilo3.get_Pro_per_Day());
                        semaforo_ini1.release();
                        
                        semaforo_con1.acquire();
                        Dhilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                        progresoCreditoBar1.setValue(Dhilo4.get_Pro_per_Day());
                        Credito_Quantity1.setText(String.valueOf(Dhilo4.get_Pro_per_Day()));
                        credito_ganancia12.setText(String.valueOf(Dhilo4.get_ganancia()));
                        Dhilo6.set_Credito_Prod(Dhilo4.get_Pro_per_Day());
                        semaforo_con1.release();
                        
                        semaforo_PT1.acquire();
                        Dhilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                        progresoPlotTwistBar1.setValue(Dhilo5.get_Pro_per_Day());
                        Plot_Twist_Quantity1.setText(String.valueOf(Dhilo5.get_Pro_per_Day()));
                        Plot_Twist_ganancia15.setText(String.valueOf(Dhilo5.get_ganancia()));
                        Dhilo6.set_Plot_Twist_Prod(Dhilo5.get_Pro_per_Day());
                        semaforo_PT1.release();
                    
                        
                        EnsambladoTxt1.setText(String.valueOf(Dhilo6.get_capitulo()));
                        Ensamblado_Ganancia1.setText(String.valueOf(Dhilo6.get_ganancia()));
                        Ganancia_Capitulo1.setText(String.valueOf(Dhilo6.get_ganancia_velma()));
                        sueldo_Director1.setText(String.valueOf(dir_jose.ganancia));
                        sueldo_Manager1.setText(String.valueOf(pm_jose.ganancia));
                        
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   
                }
            };
        t1 =new Timer(0,ac1);
        t1.start();
        
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        EnsambladoTxt1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cant_Productores_Ensamblado1 = new javax.swing.JTextField();
        Cant_Productores_Credito = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        intro_Quantity1 = new javax.swing.JLabel();
        Credito_Quantity1 = new javax.swing.JLabel();
        Cierre_Quantity1 = new javax.swing.JLabel();
        Inicio_Quantity1 = new javax.swing.JLabel();
        Plot_Twist_Quantity1 = new javax.swing.JLabel();
        progresoPlotTwistBar1 = new javax.swing.JProgressBar();
        progresoInicioBar1 = new javax.swing.JProgressBar();
        progresoCierreBar1 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        progresoCreditoBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        progresoIntroBar1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        intro_ganancia11 = new javax.swing.JLabel();
        credito_ganancia12 = new javax.swing.JLabel();
        Plot_Twist_ganancia15 = new javax.swing.JLabel();
        cierre_ganancia13 = new javax.swing.JLabel();
        inicio_ganancia14 = new javax.swing.JLabel();
        intro_ganancia1 = new javax.swing.JLabel();
        intro_ganancia2 = new javax.swing.JLabel();
        intro_ganancia3 = new javax.swing.JLabel();
        intro_ganancia4 = new javax.swing.JLabel();
        intro_ganancia5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Contador1 = new javax.swing.JTextField();
        Cant_Productores_Intro = new javax.swing.JTextField();
        Inicio_to_Cierre = new javax.swing.JButton();
        Inicio_to_Plot_Twist = new javax.swing.JButton();
        credit_to_cierre = new javax.swing.JButton();
        Cant_Productores_Cierre = new javax.swing.JTextField();
        cierre_to_Inicio = new javax.swing.JButton();
        Cant_Productores_Inicio = new javax.swing.JTextField();
        Cant_Productores_PT = new javax.swing.JTextField();
        Cierre_to_Credito = new javax.swing.JButton();
        Plot_Twist_To_Inicio = new javax.swing.JButton();
        subir_Ensambladores = new javax.swing.JButton();
        bajar_Ensabladores = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Credito_to_Intro = new javax.swing.JButton();
        Intro_a_credito = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Ensamblado_Ganancia1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Ganancia_Capitulo1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sueldo_Director1 = new javax.swing.JLabel();
        sueldo_Manager1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EnsambladoTxt1.setBackground(new java.awt.Color(0, 0, 0));
        EnsambladoTxt1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        EnsambladoTxt1.setText("0");
        jPanel1.add(EnsambladoTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel11.setText("Costos:  -");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Ensamblado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Cant_Productores_Ensamblado1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Ensamblado1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Ensamblado1.setText("0");
        Cant_Productores_Ensamblado1.setEnabled(false);
        Cant_Productores_Ensamblado1.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Ensamblado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_Ensamblado1ActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Ensamblado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 130, -1));

        Cant_Productores_Credito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Credito.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Credito.setText("0");
        Cant_Productores_Credito.setEnabled(false);
        Cant_Productores_Credito.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_CreditoActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 130, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        intro_Quantity1.setBackground(new java.awt.Color(0, 0, 0));
        intro_Quantity1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_Quantity1.setText("0");
        jPanel2.add(intro_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        Credito_Quantity1.setBackground(new java.awt.Color(0, 0, 0));
        Credito_Quantity1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Credito_Quantity1.setText("0");
        jPanel2.add(Credito_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        Cierre_Quantity1.setBackground(new java.awt.Color(0, 0, 0));
        Cierre_Quantity1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Cierre_Quantity1.setText("0");
        jPanel2.add(Cierre_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        Inicio_Quantity1.setBackground(new java.awt.Color(0, 0, 0));
        Inicio_Quantity1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Inicio_Quantity1.setText("0");
        jPanel2.add(Inicio_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        Plot_Twist_Quantity1.setBackground(new java.awt.Color(0, 0, 0));
        Plot_Twist_Quantity1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Plot_Twist_Quantity1.setText("0");
        jPanel2.add(Plot_Twist_Quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        progresoPlotTwistBar1.setMaximum(30);
        jPanel2.add(progresoPlotTwistBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 220, 30));

        progresoInicioBar1.setMaximum(30);
        jPanel2.add(progresoInicioBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 220, 30));

        progresoCierreBar1.setMaximum(30);
        jPanel2.add(progresoCierreBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("PlotTwist:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Inicio:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Cierre:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        progresoCreditoBar1.setMaximum(30);
        jPanel2.add(progresoCreditoBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 220, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Credito:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        progresoIntroBar1.setMaximum(30);
        jPanel2.add(progresoIntroBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("Costos:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setText("Intro:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        intro_ganancia11.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia11.setText("0");
        jPanel2.add(intro_ganancia11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        credito_ganancia12.setBackground(new java.awt.Color(0, 0, 0));
        credito_ganancia12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        credito_ganancia12.setText("0");
        jPanel2.add(credito_ganancia12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        Plot_Twist_ganancia15.setBackground(new java.awt.Color(0, 0, 0));
        Plot_Twist_ganancia15.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Plot_Twist_ganancia15.setText("0");
        jPanel2.add(Plot_Twist_ganancia15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        cierre_ganancia13.setBackground(new java.awt.Color(0, 0, 0));
        cierre_ganancia13.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cierre_ganancia13.setText("0");
        jPanel2.add(cierre_ganancia13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        inicio_ganancia14.setBackground(new java.awt.Color(0, 0, 0));
        inicio_ganancia14.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        inicio_ganancia14.setText("0");
        jPanel2.add(inicio_ganancia14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        intro_ganancia1.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia1.setText("-");
        jPanel2.add(intro_ganancia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        intro_ganancia2.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia2.setText("-");
        jPanel2.add(intro_ganancia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        intro_ganancia3.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia3.setText("-");
        jPanel2.add(intro_ganancia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        intro_ganancia4.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia4.setText("-");
        jPanel2.add(intro_ganancia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        intro_ganancia5.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia5.setText("-");
        jPanel2.add(intro_ganancia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-geometrico_53876-115958.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 470));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 470, 470));

        Contador1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Contador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contador1.setText("0");
        Contador1.setEnabled(false);
        Contador1.setVerifyInputWhenFocusTarget(false);
        Contador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contador1ActionPerformed(evt);
            }
        });
        jPanel1.add(Contador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 130, -1));

        Cant_Productores_Intro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Intro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Intro.setText("0");
        Cant_Productores_Intro.setEnabled(false);
        Cant_Productores_Intro.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Intro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_IntroActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Intro, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 130, -1));

        Inicio_to_Cierre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Inicio_to_Cierre.setText("^");
        Inicio_to_Cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inicio_to_CierreActionPerformed(evt);
            }
        });
        jPanel1.add(Inicio_to_Cierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 50, 40));

        Inicio_to_Plot_Twist.setText("V");
        Inicio_to_Plot_Twist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inicio_to_Plot_TwistActionPerformed(evt);
            }
        });
        jPanel1.add(Inicio_to_Plot_Twist, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 50, 40));

        credit_to_cierre.setText("V");
        credit_to_cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credit_to_cierreActionPerformed(evt);
            }
        });
        jPanel1.add(credit_to_cierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 50, 40));

        Cant_Productores_Cierre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Cierre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Cierre.setText("0");
        Cant_Productores_Cierre.setEnabled(false);
        Cant_Productores_Cierre.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Cierre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_CierreActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Cierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 130, -1));

        cierre_to_Inicio.setText("V");
        cierre_to_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cierre_to_InicioActionPerformed(evt);
            }
        });
        jPanel1.add(cierre_to_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 50, 40));

        Cant_Productores_Inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Inicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Inicio.setText("0");
        Cant_Productores_Inicio.setEnabled(false);
        Cant_Productores_Inicio.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_InicioActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 130, -1));

        Cant_Productores_PT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_PT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_PT.setText("0");
        Cant_Productores_PT.setEnabled(false);
        Cant_Productores_PT.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_PT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_PTActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_PT, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 130, -1));

        Cierre_to_Credito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cierre_to_Credito.setText("^");
        Cierre_to_Credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cierre_to_CreditoActionPerformed(evt);
            }
        });
        jPanel1.add(Cierre_to_Credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 50, 40));

        Plot_Twist_To_Inicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Plot_Twist_To_Inicio.setText("^");
        Plot_Twist_To_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plot_Twist_To_InicioActionPerformed(evt);
            }
        });
        jPanel1.add(Plot_Twist_To_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 50, 40));

        subir_Ensambladores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subir_Ensambladores.setText("^");
        subir_Ensambladores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subir_EnsambladoresActionPerformed(evt);
            }
        });
        jPanel1.add(subir_Ensambladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 50, 40));

        bajar_Ensabladores.setText("V");
        bajar_Ensabladores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajar_EnsabladoresActionPerformed(evt);
            }
        });
        jPanel1.add(bajar_Ensabladores, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 50, 40));

        Credito_to_Intro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Credito_to_Intro.setText("^");
        Credito_to_Intro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Credito_to_IntroActionPerformed(evt);
            }
        });

        Intro_a_credito.setText("V");
        Intro_a_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_creditoActionPerformed(evt);
            }
        });

        jLabel6.setText("Rodaje José");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(Intro_a_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Credito_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Intro_a_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credito_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 150, 520));

        Ensamblado_Ganancia1.setBackground(new java.awt.Color(0, 0, 0));
        Ensamblado_Ganancia1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ensamblado_Ganancia1.setText("0");
        jPanel1.add(Ensamblado_Ganancia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel12.setText("Costos:  -");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Ganancia por capítulo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        Ganancia_Capitulo1.setBackground(new java.awt.Color(0, 0, 0));
        Ganancia_Capitulo1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ganancia_Capitulo1.setText("0");
        jPanel1.add(Ganancia_Capitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel13.setText("Sueldo del Manager:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, -1, -1));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel14.setText("Counter ");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel15.setText("Sueldo del Director:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));

        sueldo_Director1.setBackground(new java.awt.Color(0, 0, 0));
        sueldo_Director1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sueldo_Director1.setText("0");
        jPanel1.add(sueldo_Director1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        sueldo_Manager1.setBackground(new java.awt.Color(0, 0, 0));
        sueldo_Manager1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sueldo_Manager1.setText("0");
        jPanel1.add(sueldo_Manager1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cant_Productores_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_CreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_CreditoActionPerformed

    private void Cant_Productores_IntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_IntroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_IntroActionPerformed

    private void Inicio_to_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio_to_CierreActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Cierre1.acquire();
                this.Jtext_Productores_Inicio1.acquire();
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) + 1));
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) - 1));
                
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Inicio1.release();
                this.Jtext_Productores_Cierre1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Inicio_to_CierreActionPerformed

    private void Inicio_to_Plot_TwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio_to_Plot_TwistActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Inicio1.acquire();
                this.Jtext_Productores_Plot_Twist1.acquire();
               
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) - 1));
                this.Cant_Productores_PT.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_PT.getText()) + 1));
               
//                Liberamos las secciones criticas
                this.Jtext_Productores_Plot_Twist1.release();
                this.Jtext_Productores_Inicio1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Inicio_to_Plot_TwistActionPerformed

    private void Cant_Productores_Ensamblado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_Ensamblado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_Ensamblado1ActionPerformed

    private void credit_to_cierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credit_to_cierreActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Credito.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Credito1.acquire();
                this.Jtext_Productores_Cierre1.acquire();
                
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) - 1));
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) + 1));
               
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Cierre1.release();
                this.Jtext_Productores_Credito1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_credit_to_cierreActionPerformed

    private void Cant_Productores_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_CierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_CierreActionPerformed

    private void cierre_to_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cierre_to_InicioActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Cierre1.acquire();
                this.Jtext_Productores_Inicio1.acquire();
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) - 1));
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) + 1));
                                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Inicio1.release();
                this.Jtext_Productores_Cierre1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cierre_to_InicioActionPerformed

    private void Cant_Productores_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_InicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_InicioActionPerformed

    private void Cant_Productores_PTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_PTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_PTActionPerformed

    private void Credito_to_IntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Credito_to_IntroActionPerformed
        
        if(Integer.parseInt(this.Cant_Productores_Credito.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                Dashboard1.Jtext_Productores_Intro1.acquire();
                Dashboard1.Jtext_Productores_Credito1.acquire();
                
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) + 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) - 1));
                
                
//                Liberamos las secciones criticas
                Dashboard1.Jtext_Productores_Credito1.release();
                Dashboard1.Jtext_Productores_Intro1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Credito_to_IntroActionPerformed

    private void Cierre_to_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cierre_to_CreditoActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText()) > 0){
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Credito1.acquire();
                this.Jtext_Productores_Cierre1.acquire();
                
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) - 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) + 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Cierre1.release();
                this.Jtext_Productores_Credito1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Cierre_to_CreditoActionPerformed

    private void Plot_Twist_To_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plot_Twist_To_InicioActionPerformed
        if(Integer.parseInt(this.Cant_Productores_PT.getText()) >0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Inicio1.acquire();
                this.Jtext_Productores_Plot_Twist1.acquire();
                
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) + 1));
                this.Cant_Productores_PT.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_PT.getText()) - 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Plot_Twist1.release();
                this.Jtext_Productores_Inicio1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Plot_Twist_To_InicioActionPerformed

    private void Intro_a_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_creditoActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Intro.getText()) > 0 ){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Intro1.acquire();
                this.Jtext_Productores_Credito1.acquire();
                
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) - 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.valueOf(this.Cant_Productores_Credito.getText()) + 1));
                
                this.Jtext_Productores_Credito1.release();
//                Liberamos las secciones criticas
                this.Jtext_Productores_Intro1.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_Intro_a_creditoActionPerformed

    private void subir_EnsambladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_EnsambladoresActionPerformed
         this.Cant_Productores_Ensamblado1.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado1.getText()) + 1));
    }//GEN-LAST:event_subir_EnsambladoresActionPerformed

    private void bajar_EnsabladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajar_EnsabladoresActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Ensamblado1.getText()) > 0){
            
            this.Cant_Productores_Ensamblado1.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado1.getText()) - 1));
            
           
        }
    }//GEN-LAST:event_bajar_EnsabladoresActionPerformed

    private void Contador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contador1ActionPerformed

    }//GEN-LAST:event_Contador1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cant_Productores_Cierre;
    private javax.swing.JTextField Cant_Productores_Credito;
    private javax.swing.JTextField Cant_Productores_Ensamblado1;
    private javax.swing.JTextField Cant_Productores_Inicio;
    private javax.swing.JTextField Cant_Productores_Intro;
    private javax.swing.JTextField Cant_Productores_PT;
    private javax.swing.JLabel Cierre_Quantity1;
    private javax.swing.JButton Cierre_to_Credito;
    private javax.swing.JTextField Contador1;
    private javax.swing.JLabel Credito_Quantity1;
    private javax.swing.JButton Credito_to_Intro;
    private javax.swing.JLabel EnsambladoTxt1;
    private javax.swing.JLabel Ensamblado_Ganancia1;
    private javax.swing.JLabel Ganancia_Capitulo1;
    private javax.swing.JLabel Inicio_Quantity1;
    private javax.swing.JButton Inicio_to_Cierre;
    private javax.swing.JButton Inicio_to_Plot_Twist;
    private javax.swing.JButton Intro_a_credito;
    private javax.swing.JLabel Plot_Twist_Quantity1;
    private javax.swing.JButton Plot_Twist_To_Inicio;
    private javax.swing.JLabel Plot_Twist_ganancia15;
    private javax.swing.JButton bajar_Ensabladores;
    private javax.swing.JLabel cierre_ganancia13;
    private javax.swing.JButton cierre_to_Inicio;
    private javax.swing.JButton credit_to_cierre;
    private javax.swing.JLabel credito_ganancia12;
    private javax.swing.JLabel inicio_ganancia14;
    private javax.swing.JLabel intro_Quantity1;
    private javax.swing.JLabel intro_ganancia1;
    private javax.swing.JLabel intro_ganancia11;
    private javax.swing.JLabel intro_ganancia2;
    private javax.swing.JLabel intro_ganancia3;
    private javax.swing.JLabel intro_ganancia4;
    private javax.swing.JLabel intro_ganancia5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar progresoCierreBar1;
    private javax.swing.JProgressBar progresoCreditoBar1;
    private javax.swing.JProgressBar progresoInicioBar1;
    private javax.swing.JProgressBar progresoIntroBar1;
    private javax.swing.JProgressBar progresoPlotTwistBar1;
    private javax.swing.JButton subir_Ensambladores;
    private javax.swing.JLabel sueldo_Director1;
    private javax.swing.JLabel sueldo_Manager1;
    // End of variables declaration//GEN-END:variables
}
