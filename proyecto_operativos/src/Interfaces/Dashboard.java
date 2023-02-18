/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Ensamblador;
import Classes.Pago;
import Classes.Productor_Cierre;
import Classes.Productor_Credito;
import Classes.Productor_Inicio;
import Classes.Productor_Plot_Twist;
import Classes.Productores_Intro;
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
public class Dashboard extends javax.swing.JFrame {
    private Timer t;
    public ActionListener ac;
    
//    Final cédula de Andy 
    public int ci_Andy = 8;
    
    //    Tamaños diferentes en el drive
    public static int tamanio_Intro = 30;
    public static int tamanio_credito = 25;
    public static int tamanio_Inicio = 50;
    public static int tamanio_Cierre = 55;
    public static int tamanio_Plot_Twist = 40;
    
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
    
//    Semaforos para los JtextosFields
    public static Semaphore Jtext_Productores_Intro = new Semaphore(1);
    public static Semaphore Jtext_Productores_Credito = new Semaphore(1);
    public static Semaphore Jtext_Productores_Ensamblado = new Semaphore(1);
    public static Semaphore Jtext_Productores_Inicio = new Semaphore(1);
    public static Semaphore Jtext_Productores_Cierre = new Semaphore(1);
    public static Semaphore Jtext_Productores_Plot_Twist = new Semaphore(1);
    
    public static Productores_Intro hilo1= new Productores_Intro(drive_Intro, semaforo_intro,1,tamanio_Intro);
    public static Productor_Cierre hilo2 = new Productor_Cierre(drive_Cierre, semaforo_cie,1,tamanio_Cierre);
    public static Productor_Inicio hilo3 = new Productor_Inicio(drive_Inicio, semaforo_ini,1,tamanio_Inicio);
    public static Productor_Credito hilo4 = new Productor_Credito(drive_credito, semaforo_con,1,tamanio_credito);
    public static Productor_Plot_Twist hilo5 = new Productor_Plot_Twist(drive_Plot_Twist, semaforo_PT,1,tamanio_Plot_Twist);
    public static Ensamblador hilo6 = new Ensamblador(hilo1,hilo2,hilo3,hilo4,hilo5,semaforo_intro,semaforo_cie,semaforo_ini,semaforo_con,semaforo_PT);
    public static Pago hilo7 = new Pago();
    
    
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        Cant_Productores_Ensamblado.setText(String.valueOf(0));
        progresoIntroBar.setMaximum(tamanio_Intro);
        progresoCreditoBar.setMaximum(tamanio_credito);
        progresoCierreBar.setMaximum(tamanio_Cierre);
        progresoInicioBar.setMaximum(tamanio_Inicio);
        progresoPlotTwistBar.setMaximum(tamanio_Plot_Twist);
        Cant_Productores_Inicio.setText(String.valueOf(3));
        Cant_Productores_Intro.setText(String.valueOf(ci_Andy));
        Cant_Productores_Cierre.setText(String.valueOf(2));
        Cant_Productores_Credito.setText(String.valueOf(3));
        Cant_Productores_PT.setText(String.valueOf(2));
         
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        
        
        this.setLocationRelativeTo(null);
            ac = new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e){
                    
                    
                    
                    
                    
                    hilo1.set_Productores(Integer.parseInt(Cant_Productores_Intro.getText().toString()));
                    hilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                    hilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                    hilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                    hilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                    hilo6.set_Productores(Integer.parseInt(Cant_Productores_Ensamblado.getText().toString()));
                    
                    progresoIntroBar.setValue(hilo1.get_Pro_per_Day());
                    intro_Quantity.setText(String.valueOf(hilo1.get_Pro_per_Day()));
                    intro_ganancia.setText(String.valueOf(hilo1.get_ganancia()));
                    hilo6.set_intro_Prod(hilo1.get_Pro_per_Day());
                    
                   
                    hilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                    progresoCierreBar.setValue(hilo2.get_Pro_per_Day());
                    Cierre_Quantity.setText(String.valueOf(hilo2.get_Pro_per_Day()));
                    cierre_ganancia.setText(String.valueOf(hilo2.get_ganancia()));
                    hilo6.set_cierre_Prod(hilo2.get_Pro_per_Day());
                    
                    hilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                    progresoInicioBar.setValue(hilo3.get_Pro_per_Day());
                    Inicio_Quantity.setText(String.valueOf(hilo3.get_Pro_per_Day()));
                    inicio_ganancia.setText(String.valueOf(hilo3.get_ganancia()));
                    hilo6.set_inicio_Prod(hilo3.get_Pro_per_Day());
                    
                    hilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                    progresoCreditoBar.setValue(hilo4.get_Pro_per_Day());
                    Credito_Quantity.setText(String.valueOf(hilo4.get_Pro_per_Day()));
                    credito_ganancia.setText(String.valueOf(hilo4.get_ganancia()));
                    hilo6.set_Credito_Prod(hilo4.get_Pro_per_Day());
                    
                    hilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                    progresoPlotTwistBar.setValue(hilo5.get_Pro_per_Day());
                    Plot_Twist_Quantity.setText(String.valueOf(hilo5.get_Pro_per_Day()));
                    Plot_Twist_ganancia.setText(String.valueOf(hilo5.get_ganancia()));
                    hilo6.set_Plot_Twist_Prod(hilo5.get_Pro_per_Day());
                    
                    EnsambladoTxt.setText(String.valueOf(hilo6.get_capitulo()));
                    Ensamblado_Ganancia.setText(String.valueOf(hilo6.get_ganancia()));
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
        Ensamblado_Ganancia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Intro_a_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Credito_to_Intro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(370, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 150, 520));

        Ensamblado_Ganancia.setBackground(new java.awt.Color(0, 0, 0));
        Ensamblado_Ganancia.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Ensamblado_Ganancia.setText("0");
        jPanel1.add(Ensamblado_Ganancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
    }//GEN-LAST:event_Intro_a_creditoActionPerformed

    private void subir_EnsambladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subir_EnsambladoresActionPerformed
         this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) + 1));
    }//GEN-LAST:event_subir_EnsambladoresActionPerformed

    private void bajar_EnsabladoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajar_EnsabladoresActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) > 0){
            
            this.Cant_Productores_Ensamblado.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Ensamblado.getText()) - 1));
            
           
        }
    }//GEN-LAST:event_bajar_EnsabladoresActionPerformed

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
    private javax.swing.JTextField Cant_Productores_Cierre;
    private javax.swing.JTextField Cant_Productores_Credito;
    private javax.swing.JTextField Cant_Productores_Ensamblado;
    private javax.swing.JTextField Cant_Productores_Inicio;
    private javax.swing.JTextField Cant_Productores_Intro;
    private javax.swing.JTextField Cant_Productores_PT;
    private javax.swing.JLabel Cierre_Quantity;
    private javax.swing.JButton Cierre_to_Credito;
    private javax.swing.JLabel Credito_Quantity;
    private javax.swing.JButton Credito_to_Intro;
    private javax.swing.JLabel EnsambladoTxt;
    private javax.swing.JLabel Ensamblado_Ganancia;
    private javax.swing.JLabel Inicio_Quantity;
    private javax.swing.JButton Inicio_to_Cierre;
    private javax.swing.JButton Inicio_to_Plot_Twist;
    private javax.swing.JButton Intro_a_credito;
    private javax.swing.JLabel Plot_Twist_Quantity;
    private javax.swing.JButton Plot_Twist_To_Inicio;
    private javax.swing.JLabel Plot_Twist_ganancia;
    private javax.swing.JButton bajar_Ensabladores;
    private javax.swing.JLabel cierre_ganancia;
    private javax.swing.JButton cierre_to_Inicio;
    private javax.swing.JButton credit_to_cierre;
    private javax.swing.JLabel credito_ganancia;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JButton subir_Ensambladores;
    // End of variables declaration//GEN-END:variables
}
