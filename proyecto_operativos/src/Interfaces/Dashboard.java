/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Director;
import Classes.Ensamblador;
import Classes.Pago;
import Classes.Paso_el_dia;
import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
import Classes.Project_manager;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author Andy
 */
public class Dashboard extends javax.swing.JFrame {
    private Timer t;
    public ActionListener ac;
    public Pago pagohilo;
    
//    Final cédula de Andy 
    public int ci_Andy = Proyecto_operativos.ci_Andy;
    public static float comparacion;
    
    //    Tamaños diferentes en el drive
    public static int tamanio_Intro = JSONReaderWriter.parte_intro_max;
    public static int tamanio_credito = JSONReaderWriter.parte_creditos_max;
    public static int tamanio_Inicio = JSONReaderWriter.parte_inicio_max;
    public static int tamanio_Cierre = JSONReaderWriter.parte_cierre_max;
    public static int tamanio_Plot_Twist = JSONReaderWriter.parte_plot_twist_max;
    
//    Semaforos para cada tamaño diferente en el drive
    public static Semaphore drive_Intro = new Semaphore(tamanio_Intro);
    public static Semaphore drive_credito = new Semaphore(tamanio_credito);
    public static Semaphore drive_Inicio = new Semaphore(tamanio_Inicio);
    public static Semaphore drive_Cierre = new Semaphore(tamanio_Cierre);
    public static Semaphore drive_Plot_Twist = new Semaphore(tamanio_Plot_Twist);
    
    public static Semaphore semaforo_s = new Semaphore(1);
    public static Semaphore semaforo_com = new Semaphore(1);
    public static Semaphore semaforo_ini = new Semaphore(1);
    public static Semaphore semaforo_con = new Semaphore(1);
    public static Semaphore semaforo_PT = new Semaphore(1);
    public static Semaphore semaforo_cie = new Semaphore(1);
    public static Semaphore semaforo_intro = new Semaphore(1);
    public static Semaphore semaforo_final = new Semaphore(0);
    
    public static Semaphore semaforo_empty_intro = new Semaphore(0);
    public static Semaphore semaforo_empty_credito = new Semaphore(0);
    public static Semaphore semaforo_empty_inicio = new Semaphore(0);
    public static Semaphore semaforo_empty_plot_twist = new Semaphore(0);
    public static Semaphore semaforo_empty_cierre = new Semaphore(0);
    
//    Semaforos para los JtextosFields
    public static Semaphore Jtext_Productores_Intro = new Semaphore(1);
    public static Semaphore Jtext_Productores_Credito = new Semaphore(1);
    public static Semaphore Jtext_Productores_Ensamblado = new Semaphore(1);
    public static Semaphore Jtext_Productores_Inicio = new Semaphore(1);
    public static Semaphore Jtext_Productores_Cierre = new Semaphore(1);
    public static Semaphore Jtext_Productores_Plot_Twist = new Semaphore(1);
    
    public static Productores_Intro hilo1 = new Productores_Intro(drive_Intro,semaforo_empty_intro, 
            semaforo_intro,1,tamanio_Intro,2);
    public static Productor_Cierre hilo2 = new Productor_Cierre(drive_Cierre,semaforo_empty_cierre ,
            semaforo_cie,1,tamanio_Cierre,1);
    public static Productor_Inicio hilo3 = new Productor_Inicio(drive_Inicio,semaforo_empty_inicio, 
            semaforo_ini,1,tamanio_Inicio,1);
    public static Productor_Credito hilo4 = new Productor_Credito(drive_credito,
            semaforo_empty_credito, semaforo_con,1,tamanio_credito,2);
    public static Productor_Plot_Twist hilo5 = new Productor_Plot_Twist(drive_Plot_Twist,
            semaforo_empty_plot_twist, semaforo_PT,1,tamanio_Plot_Twist,1);
    public static Ensamblador hilo6 = new Ensamblador(hilo1,hilo2,hilo3,hilo4,hilo5,
            semaforo_intro,semaforo_cie,semaforo_ini,semaforo_con,semaforo_PT,950);
    
////    Aqui tengo el project manager trabajando con la cedula de andy
//    Project_manager pm_andy = new Project_manager(Proyecto_operativos.ci_Andy, "andy", this.Contador);
////    Aqui le indico al director de andy a que productor vigilar, y además, le indico que es el director de andy
//    Director dir_andy = new Director(this.pm_andy, "andy", this.Contador);
    public void set_comparacion(float beneficio){
        this.comparacion =beneficio;
    }
    
    public Director dir_andy1;
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        this.Despedido1.setForeground(Color.white);
        this.BeneficiosReal.setForeground(Color.white);
        this.es_el_mejor.setForeground(Color.white);
        this.text1.setForeground(Color.white);
        this.text2.setForeground(Color.white);
        this.text3.setForeground(Color.white);
        this.series_entregadas.setForeground(Color.white);
        this.costos_generales_reales.setForeground(Color.white);
//        Se pone la cantidad inicial de ensambladores de andy
        Cant_Productores_Ensamblado.setText(String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_andy));
        
//        Se evalua si será capacidad INTRO infinita o no
        if(JSONReaderWriter.Capacidad_infinita_intro){
            
            progresoIntroBar.setMaximum(9999);            
        }else{
            
            progresoIntroBar.setMaximum(tamanio_Intro);            
        }
        
//        Se evalua si será capacidad CREDITOS infinita o no
        if(JSONReaderWriter.Capacidad_infinita_creditos){
            
            progresoCreditoBar.setMaximum(9999);
        }else{
            
            progresoCreditoBar.setMaximum(tamanio_credito);
        }
        
//        Se evalua si será capacidad CIERRE infinita o no
        if(JSONReaderWriter.Capacidad_infinita_cierre){
            
            progresoCierreBar.setMaximum(9999);
        }else{
            
            progresoCierreBar.setMaximum(tamanio_Cierre);
        }
        
//        Se evalua si será capacidad INICIO infinita o no
        if(JSONReaderWriter.Capacidad_infinita_inicio){
            
            progresoInicioBar.setMaximum(9999);
        }else{
            
            progresoInicioBar.setMaximum(tamanio_Inicio);
        }
        
//        Se evalua si será capacidad infinita o no
        if(JSONReaderWriter.Capacidad_infinita_plot_twist){
            
            progresoPlotTwistBar.setMaximum(9999);
        }else{
            
            progresoPlotTwistBar.setMaximum(tamanio_Plot_Twist);
        }
        
        
                
        Cant_Productores_Inicio.setText(String.valueOf(JSONReaderWriter.Productor_Inicio_andy));
        
        Cant_Productores_Intro.setText(String.valueOf(JSONReaderWriter.Productor_Intros_andy));
        
        Cant_Productores_Cierre.setText(String.valueOf(JSONReaderWriter.Productor_cierre_andy));
        
        Cant_Productores_Credito.setText(String.valueOf(JSONReaderWriter.Productor_Creditos_andy));
        
        Cant_Productores_PT.setText(String.valueOf(JSONReaderWriter.Productor_Plot_Twist_andy));
        
        Contador.setText(String.valueOf(JSONReaderWriter.dias_entre_despachos));
        
    //    Aqui tengo el project manager trabajando con la cedula de andy
        Project_manager pm_andy = new Project_manager(Proyecto_operativos.ci_Andy, "andy", this.Contador,this.ProjectManagerHaciendo);
    //    Aqui le indico al director de andy a que productor vigilar, y además, le indico que es el director de andy
        Director dir_andy = new Director(pm_andy, "andy", this.Contador, this.Veces_PM_atrapado,this.BeneficiosReal,this.Costos_Totales_PD,this.es_el_mejor,this.text1,this.text2,this.text3,this.series_entregadas,this.Ganancia_Capitulo,this.costos_generales_reales,1, this.DirectorHaciendo, this.LoteAntCapsJlabel, this.EnsambladoTxt, this.SueldoPorHoraPMJlabel);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        pm_andy.start();
        dir_andy.start();
        
        Pago hilo7= new Pago(pm_andy, dir_andy);
        hilo7.start();
        pagohilo=hilo7;
        Paso_el_dia pel_andy = new Paso_el_dia();
        
        pel_andy.start();
    
        
        
        
            ac = new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e){
                    
                   
                    try {
                        
                            semaforo_s.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo1.set_Productores(Integer.parseInt(Cant_Productores_Intro.getText().toString()));
                            }
                            semaforo_s.release();

                            semaforo_cie.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                            }
                            semaforo_cie.release();

                            semaforo_ini.acquire();
                            if(Proyecto_operativos.keep != false){
                            hilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                            }
                            semaforo_ini.release();

                            semaforo_con.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                            }
                            semaforo_con.release();

                            semaforo_PT.acquire();
                            if(Proyecto_operativos.keep != false){
                            hilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                            }
                            semaforo_PT.release();
                            if(Proyecto_operativos.keep != false){
                                hilo6.set_Productores(Integer.parseInt(Cant_Productores_Ensamblado.getText().toString()));
                            }
                            semaforo_s.acquire();
                            if(Proyecto_operativos.keep != false){
                                progresoIntroBar.setValue(hilo1.get_Pro_per_Day());
                                intro_Quantity.setText(String.valueOf(hilo1.get_Pro_per_Day()));
                                intro_ganancia.setText(String.valueOf(hilo1.get_ganancia()));
                                hilo6.set_intro_Prod(hilo1.get_Pro_per_Day());
                            }
                            semaforo_s.release();

                            semaforo_cie.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                                progresoCierreBar.setValue(hilo2.get_Pro_per_Day());
                                Cierre_Quantity.setText(String.valueOf(hilo2.get_Pro_per_Day()));
                                cierre_ganancia.setText(String.valueOf(hilo2.get_ganancia()));
                                hilo6.set_cierre_Prod(hilo2.get_Pro_per_Day());
                            }
                            semaforo_cie.release();

                            semaforo_ini.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                                progresoInicioBar.setValue(hilo3.get_Pro_per_Day());
                                Inicio_Quantity.setText(String.valueOf(hilo3.get_Pro_per_Day()));
                                inicio_ganancia.setText(String.valueOf(hilo3.get_ganancia()));
                                hilo6.set_inicio_Prod(hilo3.get_Pro_per_Day());
                            }
                            semaforo_ini.release();

                            semaforo_con.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                                progresoCreditoBar.setValue(hilo4.get_Pro_per_Day());
                                Credito_Quantity.setText(String.valueOf(hilo4.get_Pro_per_Day()));
                                credito_ganancia.setText(String.valueOf(hilo4.get_ganancia()));
                                hilo6.set_Credito_Prod(hilo4.get_Pro_per_Day());
                            }
                            semaforo_con.release();

                            semaforo_PT.acquire();
                            if(Proyecto_operativos.keep != false){
                                hilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                                progresoPlotTwistBar.setValue(hilo5.get_Pro_per_Day());
                                Plot_Twist_Quantity.setText(String.valueOf(hilo5.get_Pro_per_Day()));
                                Plot_Twist_ganancia.setText(String.valueOf(hilo5.get_ganancia()));
                                hilo6.set_Plot_Twist_Prod(hilo5.get_Pro_per_Day());
                            }
                            semaforo_PT.release();

                            if(Proyecto_operativos.keep != false){
                                EnsambladoTxt.setText(String.valueOf(hilo6.get_capitulo()));
                            }
                            if(Proyecto_operativos.keep != false){
                               Ensamblado_Ganancia.setText(String.valueOf(hilo6.get_ganancia()));
                            }
                            if(Proyecto_operativos.keep != false){
                               Ganancia_Capitulo.setText(String.valueOf(hilo6.get_ganancia_velma()));
                            }
                            if(Proyecto_operativos.keep != false){
                                sueldo_Director.setText(String.valueOf(dir_andy.ganancia));
                            }
                            if(Proyecto_operativos.keep != false){
                                sueldo_Manager.setText(String.valueOf(pm_andy.ganancia));
                            }
                            if(Proyecto_operativos.keep != false){
                                Costos_Totales_PD.setText(String.valueOf(hilo1.ganancia+hilo2.ganancia+hilo3.ganancia+hilo4.ganancia+hilo5.ganancia+hilo6.ganancia+pm_andy.ganancia+dir_andy.ganancia));
                            }
                        
                        
                        
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                   
                }
            };
        t =new Timer(0,ac);
        t.start();
        
        
        
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
        text1 = new javax.swing.JLabel();
        EnsambladoTxt = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cant_Productores_Ensamblado = new javax.swing.JTextField();
        Cant_Productores_Credito = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        intro_Quantity = new javax.swing.JLabel();
        Credito_Quantity = new javax.swing.JLabel();
        Cierre_Quantity = new javax.swing.JLabel();
        Inicio_Quantity = new javax.swing.JLabel();
        Plot_Twist_Quantity = new javax.swing.JLabel();
        progresoPlotTwistBar = new javax.swing.JProgressBar();
        progresoInicioBar = new javax.swing.JProgressBar();
        progresoCierreBar = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        progresoCreditoBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        progresoIntroBar = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        intro_ganancia = new javax.swing.JLabel();
        credito_ganancia = new javax.swing.JLabel();
        Plot_Twist_ganancia = new javax.swing.JLabel();
        cierre_ganancia = new javax.swing.JLabel();
        inicio_ganancia = new javax.swing.JLabel();
        intro_ganancia1 = new javax.swing.JLabel();
        intro_ganancia2 = new javax.swing.JLabel();
        intro_ganancia3 = new javax.swing.JLabel();
        intro_ganancia4 = new javax.swing.JLabel();
        intro_ganancia5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Contador = new javax.swing.JTextField();
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
        Ensamble_to_Intro = new javax.swing.JButton();
        Intro_to_Ensamble = new javax.swing.JButton();
        Ensamblado_Ganancia = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Ganancia_Capitulo = new javax.swing.JLabel();
        Veces_PM_atrapado = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        DirectorHaciendo = new javax.swing.JLabel();
        ProjectManagerHaciendo = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sueldo_Director = new javax.swing.JLabel();
        sueldo_Manager = new javax.swing.JLabel();
        es_el_mejor = new javax.swing.JLabel();
        text2 = new javax.swing.JLabel();
        Costos_Totales_PD = new javax.swing.JLabel();
        BeneficiosReal = new javax.swing.JLabel();
        series_entregadas = new javax.swing.JLabel();
        text3 = new javax.swing.JLabel();
        costos_generales_reales = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Despedido1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LoteAntCapsJlabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SueldoPorHoraPMJlabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text1.setBackground(new java.awt.Color(0, 0, 0));
        text1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        text1.setForeground(new java.awt.Color(0, 0, 0));
        text1.setText("Beneficios Totales:");
        jPanel1.add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, -1, -1));

        EnsambladoTxt.setBackground(new java.awt.Color(0, 0, 0));
        EnsambladoTxt.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        EnsambladoTxt.setText("0");
        jPanel1.add(EnsambladoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel11.setText("Costos:  -");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Ensamblado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        Cant_Productores_Ensamblado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Ensamblado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Ensamblado.setText("0");
        Cant_Productores_Ensamblado.setEnabled(false);
        Cant_Productores_Ensamblado.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Ensamblado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_EnsambladoActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Ensamblado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 130, -1));

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

        intro_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        intro_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_Quantity.setText("0");
        jPanel2.add(intro_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        Credito_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Credito_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Credito_Quantity.setText("0");
        jPanel2.add(Credito_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        Cierre_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Cierre_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Cierre_Quantity.setText("0");
        jPanel2.add(Cierre_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        Inicio_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Inicio_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Inicio_Quantity.setText("0");
        jPanel2.add(Inicio_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        Plot_Twist_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Plot_Twist_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Plot_Twist_Quantity.setText("0");
        jPanel2.add(Plot_Twist_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        progresoPlotTwistBar.setMaximum(30);
        jPanel2.add(progresoPlotTwistBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 220, 30));

        progresoInicioBar.setMaximum(30);
        jPanel2.add(progresoInicioBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 220, 30));

        progresoCierreBar.setMaximum(30);
        jPanel2.add(progresoCierreBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 220, 30));

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

        progresoCreditoBar.setMaximum(30);
        jPanel2.add(progresoCreditoBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 220, 30));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Credito:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, -1, -1));

        progresoIntroBar.setMaximum(30);
        jPanel2.add(progresoIntroBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, 30));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("Costos:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel10.setText("Intro:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        intro_ganancia.setBackground(new java.awt.Color(0, 0, 0));
        intro_ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_ganancia.setText("0");
        jPanel2.add(intro_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        credito_ganancia.setBackground(new java.awt.Color(0, 0, 0));
        credito_ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        credito_ganancia.setText("0");
        jPanel2.add(credito_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        Plot_Twist_ganancia.setBackground(new java.awt.Color(0, 0, 0));
        Plot_Twist_ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Plot_Twist_ganancia.setText("0");
        jPanel2.add(Plot_Twist_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        cierre_ganancia.setBackground(new java.awt.Color(0, 0, 0));
        cierre_ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cierre_ganancia.setText("0");
        jPanel2.add(cierre_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        inicio_ganancia.setBackground(new java.awt.Color(0, 0, 0));
        inicio_ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        inicio_ganancia.setText("0");
        jPanel2.add(inicio_ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

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

        Contador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Contador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Contador.setText("0");
        Contador.setEnabled(false);
        Contador.setVerifyInputWhenFocusTarget(false);
        Contador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContadorActionPerformed(evt);
            }
        });
        jPanel1.add(Contador, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 40, 130, -1));

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

        Ensamble_to_Intro.setText("V");
        Ensamble_to_Intro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ensamble_to_IntroActionPerformed(evt);
            }
        });

        Intro_to_Ensamble.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Intro_to_Ensamble.setText("^");
        Intro_to_Ensamble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_to_EnsambleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Intro_a_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Credito_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Ensamble_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Intro_to_Ensamble, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ensamble_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Intro_to_Ensamble, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Intro_a_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credito_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(368, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 150, 520));

        Ensamblado_Ganancia.setBackground(new java.awt.Color(0, 0, 0));
        Ensamblado_Ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ensamblado_Ganancia.setText("0");
        jPanel1.add(Ensamblado_Ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel12.setText("Costos:  -");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Ganancia por capítulo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, -1, -1));

        Ganancia_Capitulo.setBackground(new java.awt.Color(0, 0, 0));
        Ganancia_Capitulo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ganancia_Capitulo.setText("0");
        jPanel1.add(Ganancia_Capitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, -1, -1));

        Veces_PM_atrapado.setBackground(new java.awt.Color(0, 0, 0));
        Veces_PM_atrapado.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Veces_PM_atrapado.setText("0");
        jPanel1.add(Veces_PM_atrapado, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 190, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel18.setText("Costos totales por Dia: ");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        jLabel21.setBackground(new java.awt.Color(0, 0, 0));
        jLabel21.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel21.setText("Project Manager:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, -1, -1));

        DirectorHaciendo.setBackground(new java.awt.Color(0, 0, 0));
        DirectorHaciendo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        DirectorHaciendo.setText("-");
        jPanel1.add(DirectorHaciendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 280, -1));

        ProjectManagerHaciendo.setBackground(new java.awt.Color(0, 0, 0));
        ProjectManagerHaciendo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ProjectManagerHaciendo.setText("-");
        jPanel1.add(ProjectManagerHaciendo, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 210, -1));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel24.setText("Director:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, -1, -1));

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

        sueldo_Director.setBackground(new java.awt.Color(0, 0, 0));
        sueldo_Director.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sueldo_Director.setText("0");
        jPanel1.add(sueldo_Director, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, -1, -1));

        sueldo_Manager.setBackground(new java.awt.Color(0, 0, 0));
        sueldo_Manager.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        sueldo_Manager.setText("0");
        jPanel1.add(sueldo_Manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, -1, -1));

        es_el_mejor.setBackground(new java.awt.Color(0, 0, 0));
        es_el_mejor.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        es_el_mejor.setForeground(new java.awt.Color(255, 0, 0));
        es_el_mejor.setText("Esta Opción es Mejor!!!");
        jPanel1.add(es_el_mejor, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 460, -1, -1));

        text2.setBackground(new java.awt.Color(255, 255, 255));
        text2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        text2.setForeground(new java.awt.Color(0, 0, 0));
        text2.setText("Series Despachadas:");
        jPanel1.add(text2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, -1, -1));

        Costos_Totales_PD.setBackground(new java.awt.Color(0, 0, 0));
        Costos_Totales_PD.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Costos_Totales_PD.setText("0");
        jPanel1.add(Costos_Totales_PD, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, -1, -1));

        BeneficiosReal.setBackground(new java.awt.Color(0, 0, 0));
        BeneficiosReal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        BeneficiosReal.setForeground(new java.awt.Color(0, 0, 0));
        BeneficiosReal.setText("00");
        jPanel1.add(BeneficiosReal, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, -1, -1));

        series_entregadas.setBackground(new java.awt.Color(0, 0, 0));
        series_entregadas.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        series_entregadas.setForeground(new java.awt.Color(0, 0, 0));
        series_entregadas.setText("00");
        jPanel1.add(series_entregadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 380, -1, -1));

        text3.setBackground(new java.awt.Color(0, 0, 0));
        text3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        text3.setForeground(new java.awt.Color(0, 0, 0));
        text3.setText("Costos Totales:");
        jPanel1.add(text3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, -1, -1));

        costos_generales_reales.setBackground(new java.awt.Color(0, 0, 0));
        costos_generales_reales.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        costos_generales_reales.setForeground(new java.awt.Color(0, 0, 0));
        costos_generales_reales.setText("00");
        jPanel1.add(costos_generales_reales, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 420, -1, -1));

        jLabel19.setBackground(new java.awt.Color(0, 0, 0));
        jLabel19.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel19.setText("Veces PM atrapado: ");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/green-and-blue-investment-building.jpg"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, -1));

        Despedido1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Despedido1.setForeground(new java.awt.Color(255, 0, 0));
        Despedido1.setText("-Despedido-");
        jPanel1.add(Despedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 105, -1, -1));

        jLabel20.setText("Rodaje Andy");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jLabel6.setText("Lote ant caps:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        LoteAntCapsJlabel.setText("0");
        jPanel1.add(LoteAntCapsJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 60, -1));

        jLabel17.setText("Sueldo por hora PM");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));

        SueldoPorHoraPMJlabel.setText("0");
        jPanel1.add(SueldoPorHoraPMJlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 160, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cant_Productores_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_CreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_CreditoActionPerformed

    private void Cant_Productores_IntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_IntroActionPerformed
        
    }//GEN-LAST:event_Cant_Productores_IntroActionPerformed

    private void Inicio_to_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio_to_CierreActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Cierre.acquire();
                this.Jtext_Productores_Inicio.acquire();
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) + 1));
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) - 1));
                
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Inicio.release();
                this.Jtext_Productores_Cierre.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
        }
    }//GEN-LAST:event_Inicio_to_CierreActionPerformed

    private void Inicio_to_Plot_TwistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inicio_to_Plot_TwistActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Inicio.acquire();
                this.Jtext_Productores_Plot_Twist.acquire();
               
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) - 1));
                this.Cant_Productores_PT.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_PT.getText()) + 1));
               
//                Liberamos las secciones criticas
                this.Jtext_Productores_Plot_Twist.release();
                this.Jtext_Productores_Inicio.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Inicio.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
        }
    }//GEN-LAST:event_Inicio_to_Plot_TwistActionPerformed

    private void Cant_Productores_EnsambladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_EnsambladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_EnsambladoActionPerformed

    private void credit_to_cierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credit_to_cierreActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Credito.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Credito.acquire();
                this.Jtext_Productores_Cierre.acquire();
                
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) - 1));
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) + 1));
               
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Cierre.release();
                this.Jtext_Productores_Credito.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Credito.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
        }
    }//GEN-LAST:event_credit_to_cierreActionPerformed

    private void Cant_Productores_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_CierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_CierreActionPerformed

    private void cierre_to_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cierre_to_InicioActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Cierre.acquire();
                this.Jtext_Productores_Inicio.acquire();
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) - 1));
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) + 1));
                                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Inicio.release();
                this.Jtext_Productores_Cierre.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
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
                Dashboard.Jtext_Productores_Intro.acquire();
                Dashboard.Jtext_Productores_Credito.acquire();
                
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) + 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) - 1));
                
                
//                Liberamos las secciones criticas
                Dashboard.Jtext_Productores_Credito.release();
                Dashboard.Jtext_Productores_Intro.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Credito.getText())==0){
            this.Despedido1.setForeground(Color.red);
            
            this.pagohilo.ganancia_canadiense=0;
            
        }
    }//GEN-LAST:event_Credito_to_IntroActionPerformed

    private void Cierre_to_CreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cierre_to_CreditoActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText()) > 0){
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Credito.acquire();
                this.Jtext_Productores_Cierre.acquire();
                
                
                this.Cant_Productores_Cierre.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Cierre.getText()) - 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) + 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Cierre.release();
                this.Jtext_Productores_Credito.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_Cierre.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
            
        }
    }//GEN-LAST:event_Cierre_to_CreditoActionPerformed

    private void Plot_Twist_To_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plot_Twist_To_InicioActionPerformed
        if(Integer.parseInt(this.Cant_Productores_PT.getText()) >0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Inicio.acquire();
                this.Jtext_Productores_Plot_Twist.acquire();
                
                this.Cant_Productores_Inicio.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Inicio.getText()) + 1));
                this.Cant_Productores_PT.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_PT.getText()) - 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Plot_Twist.release();
                this.Jtext_Productores_Inicio.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(Integer.parseInt(this.Cant_Productores_PT.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
        }
    }//GEN-LAST:event_Plot_Twist_To_InicioActionPerformed

    private void Intro_a_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_creditoActionPerformed
        
        
        if(Integer.parseInt(this.Cant_Productores_Intro.getText()) > 0 ){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Intro.acquire();
                this.Jtext_Productores_Credito.acquire();
                
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) - 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.valueOf(this.Cant_Productores_Credito.getText()) + 1));
                
                this.Jtext_Productores_Credito.release();
//                Liberamos las secciones criticas
                this.Jtext_Productores_Intro.release();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(Integer.parseInt(this.Cant_Productores_Intro.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
            
            
        }
        
    }//GEN-LAST:event_Intro_a_creditoActionPerformed

    private void subir_EnsambladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_EnsambladoresActionPerformed
         this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) + 1));
    }//GEN-LAST:event_subir_EnsambladoresActionPerformed

    private void bajar_EnsabladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajar_EnsabladoresActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) > 0){
            
            this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) - 1));
            
           
        }
        if(Integer.parseInt(this.Cant_Productores_Ensamblado.getText())==0){
            this.Despedido1.setForeground(Color.red);
            this.pagohilo.ganancia_canadiense=0;
            
        }
    }//GEN-LAST:event_bajar_EnsabladoresActionPerformed

    private void ContadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContadorActionPerformed

    }//GEN-LAST:event_ContadorActionPerformed

    private void Ensamble_to_IntroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ensamble_to_IntroActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) > 0 && (Integer.parseInt(this.Cant_Productores_Cierre.getText())+Integer.parseInt(this.Cant_Productores_Intro.getText())+Integer.parseInt(this.Cant_Productores_Inicio.getText())+Integer.parseInt(this.Cant_Productores_PT.getText())+Integer.parseInt(this.Cant_Productores_Credito.getText()))<=17){
            try {
                this.Jtext_Productores_Intro.acquire();
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) + 1));
                this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.valueOf(this.Cant_Productores_Ensamblado.getText()) - 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Intro.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_Ensamble_to_IntroActionPerformed

    private void Intro_to_EnsambleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_to_EnsambleActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Intro.getText()) > 0 ){
            try {
                this.Jtext_Productores_Intro.acquire();
                this.Cant_Productores_Intro.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro.getText()) - 1));
                this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.valueOf(this.Cant_Productores_Ensamblado.getText()) + 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Intro.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }//GEN-LAST:event_Intro_to_EnsambleActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeneficiosReal;
    private javax.swing.JTextField Cant_Productores_Cierre;
    private javax.swing.JTextField Cant_Productores_Credito;
    private javax.swing.JTextField Cant_Productores_Ensamblado;
    private javax.swing.JTextField Cant_Productores_Inicio;
    private javax.swing.JTextField Cant_Productores_Intro;
    private javax.swing.JTextField Cant_Productores_PT;
    private javax.swing.JLabel Cierre_Quantity;
    private javax.swing.JButton Cierre_to_Credito;
    private javax.swing.JTextField Contador;
    private javax.swing.JLabel Costos_Totales_PD;
    private javax.swing.JLabel Credito_Quantity;
    private javax.swing.JButton Credito_to_Intro;
    private javax.swing.JLabel Despedido1;
    private javax.swing.JLabel DirectorHaciendo;
    private javax.swing.JLabel EnsambladoTxt;
    private javax.swing.JLabel Ensamblado_Ganancia;
    private javax.swing.JButton Ensamble_to_Intro;
    private javax.swing.JLabel Ganancia_Capitulo;
    private javax.swing.JLabel Inicio_Quantity;
    private javax.swing.JButton Inicio_to_Cierre;
    private javax.swing.JButton Inicio_to_Plot_Twist;
    private javax.swing.JButton Intro_a_credito;
    private javax.swing.JButton Intro_to_Ensamble;
    private javax.swing.JLabel LoteAntCapsJlabel;
    private javax.swing.JLabel Plot_Twist_Quantity;
    private javax.swing.JButton Plot_Twist_To_Inicio;
    private javax.swing.JLabel Plot_Twist_ganancia;
    private javax.swing.JLabel ProjectManagerHaciendo;
    private javax.swing.JLabel SueldoPorHoraPMJlabel;
    private javax.swing.JLabel Veces_PM_atrapado;
    private javax.swing.JButton bajar_Ensabladores;
    private javax.swing.JLabel cierre_ganancia;
    private javax.swing.JButton cierre_to_Inicio;
    private javax.swing.JLabel costos_generales_reales;
    private javax.swing.JButton credit_to_cierre;
    private javax.swing.JLabel credito_ganancia;
    private javax.swing.JLabel es_el_mejor;
    private javax.swing.JLabel inicio_ganancia;
    private javax.swing.JLabel intro_Quantity;
    private javax.swing.JLabel intro_ganancia;
    private javax.swing.JLabel intro_ganancia1;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JProgressBar progresoCierreBar;
    private javax.swing.JProgressBar progresoCreditoBar;
    private javax.swing.JProgressBar progresoInicioBar;
    private javax.swing.JProgressBar progresoIntroBar;
    private javax.swing.JProgressBar progresoPlotTwistBar;
    private javax.swing.JLabel series_entregadas;
    private javax.swing.JButton subir_Ensambladores;
    private javax.swing.JLabel sueldo_Director;
    private javax.swing.JLabel sueldo_Manager;
    private javax.swing.JLabel text1;
    private javax.swing.JLabel text2;
    private javax.swing.JLabel text3;
    // End of variables declaration//GEN-END:variables
}
