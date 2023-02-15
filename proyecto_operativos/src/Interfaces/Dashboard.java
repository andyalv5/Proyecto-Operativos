/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Ensamblador;
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

/**
 *
 * @author Andy
 */
public class Dashboard extends javax.swing.JFrame {
    private Timer t;
    public ActionListener ac;
    
//    Final cédula de Andy 
    public int ci_Andy = 9;
    
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
    
//    Semaforos para los JtextosFields
    public static Semaphore Jtext_Productores_Intro = new Semaphore(1);
    public static Semaphore Jtext_Productores_Credito = new Semaphore(1);
    
    public static Productores_Intro hilo1= new Productores_Intro(drive_Intro, semaforo_s,1,tamanio_Intro);
    public static Productor_Cierre hilo2 = new Productor_Cierre(drive_Cierre, semaforo_s,1,tamanio_Cierre);
    public static Productor_Inicio hilo3 = new Productor_Inicio(drive_Inicio, semaforo_s,1,tamanio_Inicio);
    public static Productor_Credito hilo4 = new Productor_Credito(drive_credito, semaforo_s,1,tamanio_credito);
    public static Productor_Plot_Twist hilo5 = new Productor_Plot_Twist(drive_Plot_Twist, semaforo_s,1,tamanio_Plot_Twist);
    public Ensamblador hilo6 = new Ensamblador(hilo1,hilo2,hilo3,hilo4,hilo5);
    
    
    
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        Cant_Productores_Intro1.setText(String.valueOf(10+ci_Andy));
        progresoIntroBar.setMaximum(tamanio_Intro);
        progresoCreditoBar.setMaximum(tamanio_credito);
        progresoCierreBar.setMaximum(tamanio_Cierre);
        progresoInicioBar.setMaximum(tamanio_Inicio);
        progresoPlotTwistBar.setMaximum(tamanio_Plot_Twist);
        
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        
        
        this.setLocationRelativeTo(null);
            ac = new ActionListener(){
            
                @Override
                public void actionPerformed(ActionEvent e){
                    hilo1.set_Productores(Integer.parseInt(Cant_Productores_Intro1.getText().toString()));
                    progresoIntroBar.setValue(hilo1.get_Pro_per_Day());
                    intro_Quantity.setText(String.valueOf(hilo1.get_Pro_per_Day()));
                    hilo6.set_intro_Prod(hilo1.get_Pro_per_Day());
                    
                    hilo2.set_Productores(Integer.parseInt(Cant_Productores_Cierre.getText().toString()));
                    progresoCierreBar.setValue(hilo2.get_Pro_per_Day());
                    Cierre_Quantity.setText(String.valueOf(hilo2.get_Pro_per_Day()));
                    hilo6.set_cierre_Prod(hilo2.get_Pro_per_Day());
                    
                    hilo3.set_Productores(Integer.parseInt(Cant_Productores_Inicio.getText().toString()));
                    progresoInicioBar.setValue(hilo3.get_Pro_per_Day());
                    Inicio_Quantity.setText(String.valueOf(hilo3.get_Pro_per_Day()));
                    hilo6.set_inicio_Prod(hilo3.get_Pro_per_Day());
                    
                    hilo4.set_Productores(Integer.parseInt(Cant_Productores_Credito.getText().toString()));
                    progresoCreditoBar.setValue(hilo4.get_Pro_per_Day());
                    Credito_Quantity.setText(String.valueOf(hilo4.get_Pro_per_Day()));
                    hilo6.set_Credito_Prod(hilo4.get_Pro_per_Day());
                    
                    hilo5.set_Productores(Integer.parseInt(Cant_Productores_PT.getText().toString()));
                    progresoPlotTwistBar.setValue(hilo5.get_Pro_per_Day());
                    Plot_Twist_Quantity.setText(String.valueOf(hilo5.get_Pro_per_Day()));
                    hilo6.set_Plot_Twist_Prod(hilo5.get_Pro_per_Day());
                    
                    EnsambladoTxt.setText(String.valueOf(hilo6.get_capitulo()));
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
        progresoCreditoBar = new javax.swing.JProgressBar();
        progresoIntroBar = new javax.swing.JProgressBar();
        progresoInicioBar = new javax.swing.JProgressBar();
        progresoCierreBar = new javax.swing.JProgressBar();
        progresoPlotTwistBar = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        intro_Quantity = new javax.swing.JLabel();
        Credito_Quantity = new javax.swing.JLabel();
        Cierre_Quantity = new javax.swing.JLabel();
        Inicio_Quantity = new javax.swing.JLabel();
        Plot_Twist_Quantity = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        EnsambladoTxt = new javax.swing.JLabel();
        Cant_Productores_Credito = new javax.swing.JTextField();
        Cant_Productores_Intro1 = new javax.swing.JTextField();
        Intro_a_credito = new javax.swing.JButton();
        credito_a_intro = new javax.swing.JButton();
        Intro_a_credito1 = new javax.swing.JButton();
        credito_a_intro1 = new javax.swing.JButton();
        Cant_Productores_PT = new javax.swing.JTextField();
        Intro_a_credito2 = new javax.swing.JButton();
        credito_a_intro2 = new javax.swing.JButton();
        Cant_Productores_Cierre = new javax.swing.JTextField();
        Intro_a_credito3 = new javax.swing.JButton();
        credito_a_intro3 = new javax.swing.JButton();
        Cant_Productores_Inicio = new javax.swing.JTextField();
        Intro_a_credito4 = new javax.swing.JButton();
        credito_a_intro4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progresoCreditoBar.setMaximum(30);
        jPanel1.add(progresoCreditoBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 220, 30));

        progresoIntroBar.setMaximum(30);
        jPanel1.add(progresoIntroBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 220, 30));

        progresoInicioBar.setMaximum(30);
        jPanel1.add(progresoInicioBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 220, 30));

        progresoCierreBar.setMaximum(30);
        jPanel1.add(progresoCierreBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 220, 30));

        progresoPlotTwistBar.setMaximum(30);
        jPanel1.add(progresoPlotTwistBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 220, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Ensamblado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Credito:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("Inicio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("PlotTwist:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel9.setText("Intro:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Cierre:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        intro_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        intro_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        intro_Quantity.setText("0");
        jPanel2.add(intro_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 75, -1, -1));

        Credito_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Credito_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Credito_Quantity.setText("0");
        jPanel2.add(Credito_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 155, -1, -1));

        Cierre_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Cierre_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Cierre_Quantity.setText("0");
        jPanel2.add(Cierre_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 235, -1, -1));

        Inicio_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Inicio_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Inicio_Quantity.setText("0");
        jPanel2.add(Inicio_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 315, -1, -1));

        Plot_Twist_Quantity.setBackground(new java.awt.Color(0, 0, 0));
        Plot_Twist_Quantity.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        Plot_Twist_Quantity.setText("0");
        jPanel2.add(Plot_Twist_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 395, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo-geometrico_53876-115958.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 470));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 470, 470));

        EnsambladoTxt.setBackground(new java.awt.Color(0, 0, 0));
        EnsambladoTxt.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        EnsambladoTxt.setText("0");
        jPanel1.add(EnsambladoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

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

        Cant_Productores_Intro1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Cant_Productores_Intro1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cant_Productores_Intro1.setText("4");
        Cant_Productores_Intro1.setEnabled(false);
        Cant_Productores_Intro1.setVerifyInputWhenFocusTarget(false);
        Cant_Productores_Intro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cant_Productores_Intro1ActionPerformed(evt);
            }
        });
        jPanel1.add(Cant_Productores_Intro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, 130, -1));

        Intro_a_credito.setText("V");
        Intro_a_credito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_creditoActionPerformed(evt);
            }
        });
        jPanel1.add(Intro_a_credito, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 50, 40));

        credito_a_intro.setText("^");
        credito_a_intro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credito_a_introActionPerformed(evt);
            }
        });
        jPanel1.add(credito_a_intro, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 50, 40));

        Intro_a_credito1.setText("V");
        Intro_a_credito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_credito1ActionPerformed(evt);
            }
        });
        jPanel1.add(Intro_a_credito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 50, 40));

        credito_a_intro1.setText("^");
        credito_a_intro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credito_a_intro1ActionPerformed(evt);
            }
        });
        jPanel1.add(credito_a_intro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 50, 40));

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

        Intro_a_credito2.setText("V");
        Intro_a_credito2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_credito2ActionPerformed(evt);
            }
        });
        jPanel1.add(Intro_a_credito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 50, 40));

        credito_a_intro2.setText("^");
        credito_a_intro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credito_a_intro2ActionPerformed(evt);
            }
        });
        jPanel1.add(credito_a_intro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 50, 40));

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

        Intro_a_credito3.setText("V");
        Intro_a_credito3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_credito3ActionPerformed(evt);
            }
        });
        jPanel1.add(Intro_a_credito3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 50, 40));

        credito_a_intro3.setText("^");
        credito_a_intro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credito_a_intro3ActionPerformed(evt);
            }
        });
        jPanel1.add(credito_a_intro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 50, 40));

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

        Intro_a_credito4.setText("to TOP");
        Intro_a_credito4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Intro_a_credito4ActionPerformed(evt);
            }
        });
        jPanel1.add(Intro_a_credito4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 130, 40));

        credito_a_intro4.setText("to BOTTOM");
        credito_a_intro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                credito_a_intro4ActionPerformed(evt);
            }
        });
        jPanel1.add(credito_a_intro4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 130, 40));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 150, 520));

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

    private void Cant_Productores_Intro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_Intro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_Intro1ActionPerformed

    private void Intro_a_creditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_creditoActionPerformed
        if(Integer.parseInt(this.Cant_Productores_Intro1.getText()) > 0){
            
            try {
                
//                Intentamos acceder a las secciones criticas
                this.Jtext_Productores_Intro.acquire();
                this.Jtext_Productores_Credito.acquire();
                
                this.Cant_Productores_Intro1.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Intro1.getText()) - 1));
                this.Cant_Productores_Credito.setText(String.valueOf(Integer.parseInt(this.Cant_Productores_Credito.getText()) + 1));
                
//                Liberamos las secciones criticas
                this.Jtext_Productores_Credito.release();
                this.Jtext_Productores_Intro.release();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_Intro_a_creditoActionPerformed

    private void credito_a_introActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credito_a_introActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credito_a_introActionPerformed

    private void Intro_a_credito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_credito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Intro_a_credito1ActionPerformed

    private void credito_a_intro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credito_a_intro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credito_a_intro1ActionPerformed

    private void Cant_Productores_PTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_PTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_PTActionPerformed

    private void Intro_a_credito2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_credito2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Intro_a_credito2ActionPerformed

    private void credito_a_intro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credito_a_intro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credito_a_intro2ActionPerformed

    private void Cant_Productores_CierreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_CierreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_CierreActionPerformed

    private void Intro_a_credito3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_credito3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Intro_a_credito3ActionPerformed

    private void credito_a_intro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credito_a_intro3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credito_a_intro3ActionPerformed

    private void Cant_Productores_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cant_Productores_InicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cant_Productores_InicioActionPerformed

    private void Intro_a_credito4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Intro_a_credito4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Intro_a_credito4ActionPerformed

    private void credito_a_intro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_credito_a_intro4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_credito_a_intro4ActionPerformed

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
    private javax.swing.JTextField Cant_Productores_Inicio;
    private javax.swing.JTextField Cant_Productores_Intro1;
    private javax.swing.JTextField Cant_Productores_PT;
    private javax.swing.JLabel Cierre_Quantity;
    private javax.swing.JLabel Credito_Quantity;
    private javax.swing.JLabel EnsambladoTxt;
    private javax.swing.JLabel Inicio_Quantity;
    private javax.swing.JButton Intro_a_credito;
    private javax.swing.JButton Intro_a_credito1;
    private javax.swing.JButton Intro_a_credito2;
    private javax.swing.JButton Intro_a_credito3;
    private javax.swing.JButton Intro_a_credito4;
    private javax.swing.JLabel Plot_Twist_Quantity;
    private javax.swing.JButton credito_a_intro;
    private javax.swing.JButton credito_a_intro1;
    private javax.swing.JButton credito_a_intro2;
    private javax.swing.JButton credito_a_intro3;
    private javax.swing.JButton credito_a_intro4;
    private javax.swing.JLabel intro_Quantity;
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
