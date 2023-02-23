/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Classes.Director;
import Classes.SetLocationRelativeTo;
import Classes.SetLocationRelativeToDashboard;
import Leer_Escribir_JSON.JSONReaderWriter;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import proyecto_operativos.Proyecto_operativos;

/**
 *
 * @author AndyYJosé
 */
public class MainFrame extends javax.swing.JFrame {
    
    public static int NroSeries_Andy;
    
    /**
     * Creates new form MainFrame
     */
    
      /**
     * Pone las variables de la clase JSON que se necesiten en TRUE
     */
    public void CapacidadInfinita(){
//        Revisa si la capacidad de intro es infinita
        if(this.Capacidad_infinita_intro_checkbox.isSelected()){
            JSONReaderWriter.Capacidad_infinita_intro = true;
        }
        
//        Revisa si la capacidad de credito es infinita
        if(this.Capacidad_infinita_creditos_checkbox.isSelected()){
            JSONReaderWriter.Capacidad_infinita_creditos = true;
        }
        
//        Revisa si la capacidad de inicio es infinita
        if(this.Capacidad_infinita_inicio_checkbox.isSelected()){
            JSONReaderWriter.Capacidad_infinita_inicio = true;
        }
        
//        Revisa si la capacidad de cierre es infinita
        if(this.Capacidad_infinita_cierre_checkbox.isSelected()){
            JSONReaderWriter.Capacidad_infinita_cierre = true;
        }
        
//        Revisa si la capacidad de plot twist es infinita
        if(this.Capacidad_infinita_plot_twist_checkbox.isSelected()){
            JSONReaderWriter.Capacidad_infinita_plot_twist = true;
        }
        
    }
    
    public MainFrame() {
        initComponents();
        
            
//        Se abre JSON para poder trabajar
        JSONReaderWriter jsnrw = new JSONReaderWriter();
        
        try{
            jsnrw.Reader();
            
        }catch(FileNotFoundException e){
            this.Mensaje.setText(String.valueOf(e));
        }
        
        
        
        this.parte_intro_max_MainFrame.setText(String.valueOf(JSONReaderWriter.parte_intro_max));
        this.parte_cierre_max_MainFrame.setText(String.valueOf(JSONReaderWriter.parte_cierre_max));
        this.parte_creditos_max_MainFrame.setText(String.valueOf(String.valueOf(JSONReaderWriter.parte_creditos_max)));
        this.parte_plot_twist_max_MainFrame.setText(String.valueOf(JSONReaderWriter.parte_plot_twist_max));
        this.parte_inicio_max_MainFrame.setText(String.valueOf(JSONReaderWriter.parte_inicio_max));
        this.Productor_Intros_TLOU.setText(String.valueOf(JSONReaderWriter.Productor_Intros_jose));
        this.Productor_Intros_VELMA.setText(String.valueOf(JSONReaderWriter.Productor_Intros_andy));
        this.Productor_Cierre_TLOU.setText(String.valueOf(JSONReaderWriter.Productor_cierre_jose));
        this.Productor_Cierre_VELMA.setText(String.valueOf(JSONReaderWriter.Productor_cierre_andy));
        this.Productor_Creditos_TLOU.setText(String.valueOf(JSONReaderWriter.Productor_Creditos_jose));
        this.Productor_Creditos_VELMA.setText(String.valueOf(JSONReaderWriter.Productor_Creditos_andy));
        this.Productor_Plot_Twist_TLOU.setText(String.valueOf(JSONReaderWriter.Productor_Plot_Twist_jose));
        this.Productor_Plot_Twist_VELMA.setText(String.valueOf(JSONReaderWriter.Productor_Plot_Twist_andy));
        this.Productor_Inicio_TLOU.setText(String.valueOf(JSONReaderWriter.Productor_Inicio_jose));
        this.Productor_Inicio_VELMA.setText(String.valueOf(JSONReaderWriter.Productor_Inicio_andy));
        this.Ensamblador_TLOU.setText(String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_jose));
        this.Ensamblador_VELMA.setText(String.valueOf(JSONReaderWriter.Ensamblador_Rodaje_andy));
        this.Dia_en_segundos_MainFrame_text.setText(String.valueOf(JSONReaderWriter.dia_en_segundos));
        this.Dias_entre_despachos_MainFrame_text.setText(String.valueOf(JSONReaderWriter.dias_entre_despachos));
        
        this.setLocationRelativeTo(null);
        
        try{
            jsnrw.Reader();
            
        }catch(FileNotFoundException e){
            this.Mensaje.setText(String.valueOf(e));
        }
        
//        Valores para hacer operaciones
        int ingreso_anterior_andy = JSONReaderWriter.Ingresos_Rodaje_andy;
        int ingreso_anterior_jose = JSONReaderWriter.Ingresos_Rodaje_jose;
        
        int costos_anterior_andy = JSONReaderWriter.Costos_Rodaje_andy;
        int costos_anterior_jose = JSONReaderWriter.Costos_Rodaje_jose;
        
//        El resultado de las operaciones
        int ganancias_anterior_andy =  ingreso_anterior_andy - costos_anterior_andy;
        int ganancias_anterior_jose =  ingreso_anterior_jose - costos_anterior_jose;
        
//        Se pone en la interfaz las ganancias de la simulación pasada
        this.ganancias_anterior_VELMA.setText(String.valueOf(ganancias_anterior_andy));
        this.gananias_anterior_TLOU.setText(String.valueOf(ganancias_anterior_jose));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Productor_Intros_VELMA = new javax.swing.JTextField();
        Mensaje = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Nro_series = new javax.swing.JTextField();
        Productor_Creditos_VELMA = new javax.swing.JTextField();
        Productor_Inicio_VELMA = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Productor_Cierre_VELMA = new javax.swing.JTextField();
        Productor_Plot_Twist_VELMA = new javax.swing.JTextField();
        Dias_entre_despachos_MainFrame_text = new javax.swing.JTextField();
        parte_intro_max_MainFrame = new javax.swing.JTextField();
        Dia_en_segundos_MainFrame_text = new javax.swing.JTextField();
        parte_cierre_max_MainFrame = new javax.swing.JTextField();
        parte_creditos_max_MainFrame = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        parte_inicio_max_MainFrame = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Productor_Intros_TLOU = new javax.swing.JTextField();
        Productor_Creditos_TLOU = new javax.swing.JTextField();
        Productor_Inicio_TLOU = new javax.swing.JTextField();
        Productor_Cierre_TLOU = new javax.swing.JTextField();
        Ensamblador_VELMA = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        parte_plot_twist_max_MainFrame = new javax.swing.JTextField();
        Capacidad_infinita_plot_twist_checkbox = new javax.swing.JCheckBox();
        Capacidad_infinita_cierre_checkbox = new javax.swing.JCheckBox();
        Capacidad_infinita_inicio_checkbox = new javax.swing.JCheckBox();
        Capacidad_infinita_creditos_checkbox = new javax.swing.JCheckBox();
        gananias_anterior_TLOU = new javax.swing.JLabel();
        ganancias_anterior_VELMA = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Capacidad_infinita_intro_checkbox = new javax.swing.JCheckBox();
        Productor_Plot_Twist_TLOU = new javax.swing.JTextField();
        Ensamblador_TLOU = new javax.swing.JTextField();
        ReseteoHard = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnAggUsuario = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Productor_Intros_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Intros_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Intros_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Intros_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Intros_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Intros_VELMAActionPerformed(evt);
            }
        });
        Background.add(Productor_Intros_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, 160, 40));

        Mensaje.setBackground(new java.awt.Color(0, 0, 0));
        Mensaje.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Mensaje.setForeground(new java.awt.Color(255, 255, 255));
        Mensaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Mensaje.setText("-");
        Mensaje.setFocusable(false);
        Mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MensajeActionPerformed(evt);
            }
        });
        Background.add(Mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 310, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Productores iniciales VELMA");
        Background.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 300, -1, -1));

        Nro_series.setBackground(new java.awt.Color(0, 0, 0));
        Nro_series.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Nro_series.setForeground(new java.awt.Color(255, 255, 255));
        Nro_series.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Nro_series.setText("1");
        Nro_series.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nro_seriesActionPerformed(evt);
            }
        });
        Background.add(Nro_series, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 160, 40));

        Productor_Creditos_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Creditos_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Creditos_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Creditos_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Creditos_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Creditos_VELMAActionPerformed(evt);
            }
        });
        Background.add(Productor_Creditos_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 160, 40));

        Productor_Inicio_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Inicio_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Inicio_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Inicio_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Inicio_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Inicio_VELMAActionPerformed(evt);
            }
        });
        Background.add(Productor_Inicio_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 450, 160, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Productor Intros");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Productor Creditos");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Productor Cierre");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Productor Inicio");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Productor Plot Twist");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Ensamblador");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel36)
                            .addComponent(jLabel30)
                            .addComponent(jLabel35))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel31)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(45, 45, 45))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel30)
                .addGap(26, 26, 26)
                .addComponent(jLabel36)
                .addGap(27, 27, 27)
                .addComponent(jLabel33)
                .addGap(27, 27, 27)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(18, 18, 18))
        );

        Background.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 310));

        Productor_Cierre_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Cierre_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Cierre_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Cierre_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Cierre_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Cierre_VELMAActionPerformed(evt);
            }
        });
        Background.add(Productor_Cierre_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 160, 40));

        Productor_Plot_Twist_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Plot_Twist_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Plot_Twist_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Plot_Twist_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Plot_Twist_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Plot_Twist_VELMAActionPerformed(evt);
            }
        });
        Background.add(Productor_Plot_Twist_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 550, 160, 40));

        Dias_entre_despachos_MainFrame_text.setBackground(new java.awt.Color(0, 0, 0));
        Dias_entre_despachos_MainFrame_text.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Dias_entre_despachos_MainFrame_text.setForeground(new java.awt.Color(255, 255, 255));
        Dias_entre_despachos_MainFrame_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dias_entre_despachos_MainFrame_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dias_entre_despachos_MainFrame_textActionPerformed(evt);
            }
        });
        Background.add(Dias_entre_despachos_MainFrame_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 160, 40));

        parte_intro_max_MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        parte_intro_max_MainFrame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        parte_intro_max_MainFrame.setForeground(new java.awt.Color(255, 255, 255));
        parte_intro_max_MainFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        parte_intro_max_MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parte_intro_max_MainFrameActionPerformed(evt);
            }
        });
        Background.add(parte_intro_max_MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 160, 40));

        Dia_en_segundos_MainFrame_text.setBackground(new java.awt.Color(0, 0, 0));
        Dia_en_segundos_MainFrame_text.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Dia_en_segundos_MainFrame_text.setForeground(new java.awt.Color(255, 255, 255));
        Dia_en_segundos_MainFrame_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Dia_en_segundos_MainFrame_text.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Dia_en_segundos_MainFrame_textInputMethodTextChanged(evt);
            }
        });
        Dia_en_segundos_MainFrame_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Dia_en_segundos_MainFrame_textActionPerformed(evt);
            }
        });
        Background.add(Dia_en_segundos_MainFrame_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 160, 40));

        parte_cierre_max_MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        parte_cierre_max_MainFrame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        parte_cierre_max_MainFrame.setForeground(new java.awt.Color(255, 255, 255));
        parte_cierre_max_MainFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        parte_cierre_max_MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parte_cierre_max_MainFrameActionPerformed(evt);
            }
        });
        Background.add(parte_cierre_max_MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 160, 40));

        parte_creditos_max_MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        parte_creditos_max_MainFrame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        parte_creditos_max_MainFrame.setForeground(new java.awt.Color(255, 255, 255));
        parte_creditos_max_MainFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        parte_creditos_max_MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parte_creditos_max_MainFrameActionPerformed(evt);
            }
        });
        Background.add(parte_creditos_max_MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 160, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Nro de series");
        Background.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Productores iniciales TLOU");
        Background.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO");
        jLabel2.setOpaque(true);
        Background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 350, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ganancias simulación anterior VELMA:");
        Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, -1));

        parte_inicio_max_MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        parte_inicio_max_MainFrame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        parte_inicio_max_MainFrame.setForeground(new java.awt.Color(255, 255, 255));
        parte_inicio_max_MainFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        parte_inicio_max_MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parte_inicio_max_MainFrameActionPerformed(evt);
            }
        });
        Background.add(parte_inicio_max_MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 160, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Drive:");
        Background.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, -1, -1));

        Productor_Intros_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Intros_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Intros_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Intros_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Intros_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Intros_TLOUActionPerformed(evt);
            }
        });
        Background.add(Productor_Intros_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 160, 40));

        Productor_Creditos_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Creditos_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Creditos_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Creditos_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Creditos_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Creditos_TLOUActionPerformed(evt);
            }
        });
        Background.add(Productor_Creditos_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 160, 40));

        Productor_Inicio_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Inicio_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Inicio_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Inicio_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Inicio_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Inicio_TLOUActionPerformed(evt);
            }
        });
        Background.add(Productor_Inicio_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 160, 40));

        Productor_Cierre_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Cierre_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Cierre_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Cierre_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Cierre_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Cierre_TLOUActionPerformed(evt);
            }
        });
        Background.add(Productor_Cierre_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, 160, 40));

        Ensamblador_VELMA.setBackground(new java.awt.Color(0, 0, 0));
        Ensamblador_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Ensamblador_VELMA.setForeground(new java.awt.Color(255, 255, 255));
        Ensamblador_VELMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ensamblador_VELMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ensamblador_VELMAActionPerformed(evt);
            }
        });
        Background.add(Ensamblador_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 600, 160, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Ganancias simulación anterior TLOU:");
        Background.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, -1, -1));

        parte_plot_twist_max_MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        parte_plot_twist_max_MainFrame.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        parte_plot_twist_max_MainFrame.setForeground(new java.awt.Color(255, 255, 255));
        parte_plot_twist_max_MainFrame.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        parte_plot_twist_max_MainFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parte_plot_twist_max_MainFrameActionPerformed(evt);
            }
        });
        Background.add(parte_plot_twist_max_MainFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 160, 40));

        Capacidad_infinita_plot_twist_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        Capacidad_infinita_plot_twist_checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Capacidad_infinita_plot_twist_checkbox.setForeground(new java.awt.Color(0, 0, 0));
        Capacidad_infinita_plot_twist_checkbox.setText("Capacidad Infinita");
        Capacidad_infinita_plot_twist_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capacidad_infinita_plot_twist_checkboxActionPerformed(evt);
            }
        });
        Background.add(Capacidad_infinita_plot_twist_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, -1, -1));

        Capacidad_infinita_cierre_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        Capacidad_infinita_cierre_checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Capacidad_infinita_cierre_checkbox.setForeground(new java.awt.Color(0, 0, 0));
        Capacidad_infinita_cierre_checkbox.setText("Capacidad Infinita");
        Capacidad_infinita_cierre_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capacidad_infinita_cierre_checkboxActionPerformed(evt);
            }
        });
        Background.add(Capacidad_infinita_cierre_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, -1, -1));

        Capacidad_infinita_inicio_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        Capacidad_infinita_inicio_checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Capacidad_infinita_inicio_checkbox.setForeground(new java.awt.Color(0, 0, 0));
        Capacidad_infinita_inicio_checkbox.setText("Capacidad Infinita");
        Capacidad_infinita_inicio_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capacidad_infinita_inicio_checkboxActionPerformed(evt);
            }
        });
        Background.add(Capacidad_infinita_inicio_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, -1, -1));

        Capacidad_infinita_creditos_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        Capacidad_infinita_creditos_checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Capacidad_infinita_creditos_checkbox.setForeground(new java.awt.Color(0, 0, 0));
        Capacidad_infinita_creditos_checkbox.setText("Capacidad Infinita");
        Capacidad_infinita_creditos_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capacidad_infinita_creditos_checkboxActionPerformed(evt);
            }
        });
        Background.add(Capacidad_infinita_creditos_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 100, -1, -1));

        gananias_anterior_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gananias_anterior_TLOU.setForeground(new java.awt.Color(0, 0, 0));
        gananias_anterior_TLOU.setText("0");
        Background.add(gananias_anterior_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 330, 70, -1));

        ganancias_anterior_VELMA.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ganancias_anterior_VELMA.setForeground(new java.awt.Color(0, 0, 0));
        ganancias_anterior_VELMA.setText("0");
        Background.add(ganancias_anterior_VELMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 360, 60, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Dias entre despachos");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dia en segundos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        Background.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 200, -1));

        Capacidad_infinita_intro_checkbox.setBackground(new java.awt.Color(255, 255, 255));
        Capacidad_infinita_intro_checkbox.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Capacidad_infinita_intro_checkbox.setForeground(new java.awt.Color(0, 0, 0));
        Capacidad_infinita_intro_checkbox.setText("Capacidad Infinita");
        Capacidad_infinita_intro_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Capacidad_infinita_intro_checkboxActionPerformed(evt);
            }
        });
        Background.add(Capacidad_infinita_intro_checkbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, -1, -1));

        Productor_Plot_Twist_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Productor_Plot_Twist_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Productor_Plot_Twist_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Productor_Plot_Twist_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Productor_Plot_Twist_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Productor_Plot_Twist_TLOUActionPerformed(evt);
            }
        });
        Background.add(Productor_Plot_Twist_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 160, 40));

        Ensamblador_TLOU.setBackground(new java.awt.Color(0, 0, 0));
        Ensamblador_TLOU.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Ensamblador_TLOU.setForeground(new java.awt.Color(255, 255, 255));
        Ensamblador_TLOU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ensamblador_TLOU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ensamblador_TLOUActionPerformed(evt);
            }
        });
        Background.add(Ensamblador_TLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 610, 160, 40));

        ReseteoHard.setBackground(new java.awt.Color(0, 0, 0));
        ReseteoHard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ReseteoHard.setForeground(new java.awt.Color(255, 255, 255));
        ReseteoHard.setText("Usar datos por defecto (RESETEO HARD)");
        ReseteoHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReseteoHardActionPerformed(evt);
            }
        });
        Background.add(ReseteoHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Productor Intros");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Productor Creditos");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Productor Inicio");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Productor Cierre");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Productor Plot Twist");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Ensamblador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(37, 37, 37))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addGap(26, 26, 26)
                .addComponent(jLabel21)
                .addGap(30, 30, 30)
                .addComponent(jLabel22)
                .addGap(27, 27, 27)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(24, 24, 24))
        );

        Background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, 310));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("parte intro max");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("parte inicio max");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("parte cierre max");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("parte plot twist max");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("parte creditos max");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(24, 24, 24)
                .addComponent(jLabel11)
                .addGap(28, 28, 28)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(15, 15, 15))
        );

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 200, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngegg.png"))); // NOI18N
        jLabel1.setText("1030");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 540, 630));

        btnAggUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnAggUsuario.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnAggUsuario.setForeground(new java.awt.Color(255, 102, 102));
        btnAggUsuario.setText("PULSE AQUÍ");
        btnAggUsuario.setDefaultCapable(false);
        btnAggUsuario.setFocusable(false);
        btnAggUsuario.setRequestFocusEnabled(false);
        btnAggUsuario.setRolloverEnabled(false);
        btnAggUsuario.setSelected(true);
        btnAggUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggUsuarioActionPerformed(evt);
            }
        });
        Background.add(btnAggUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 310, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0-creative-business-model-canvas___media_library_original_1600_900.jpg"))); // NOI18N
        Background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 860));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 1095, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Le da paso a los Dashboards
     */
    private void PasarSiguienteInterfaz(){
        
//        Director.NroSeries_Andy = Integer.parseInt(this.Nro_series.getText());
        Director.NroSeries_Jose = Integer.parseInt(this.Nro_series.getText());
        
        Director.NroSeries_Andy = Integer.parseInt(this.Nro_series.getText());
        
//        System.out.println(this.Nro_series.getText());
//        System.out.println("NroSeries_Andy" + Director.NroSeries_Andy);
//        System.out.println("NroSeries_Jose" + Director.NroSeries_Jose);

//        Llama a la otra interfaz


        SetLocationRelativeToDashboard.SetLocationRelativeToDashboard();

        SetLocationRelativeTo.SetLocationRelativeTo();

//        Cierra la interfaz actual
        this.setVisible(false);
    }
    
    private void btnAggUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggUsuarioActionPerformed
        
            
        try{
            
            
            JSONReaderWriter jsnrw = new JSONReaderWriter();
            
            if(this.ReseteoHard.isSelected()){
//                Si la casilla "ReseteoHard" está marcada, aquí se reseteará todo el codigo por defecto impuesto en el metodo "ArreglarJSONporDefecto" ubicado en la clase JSONReaderWriter
                
                jsnrw.ArreglarJSONporDefecto();
                
//                Se lee para que el programa cargue los nuevos datos
                jsnrw.Reader();
                
//                Ahora se pasa a la siguiente interfaz con los datos por defecto
                this.PasarSiguienteInterfaz();
            }
                
            else if(JSONReaderWriter.isPositiveNumeric2(this.Dia_en_segundos_MainFrame_text.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Dias_entre_despachos_MainFrame_text.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Intros_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Creditos_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Inicio_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Cierre_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Plot_Twist_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Ensamblador_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Intros_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Creditos_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Inicio_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Cierre_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Productor_Plot_Twist_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Ensamblador_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric2(this.parte_intro_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric2(this.parte_creditos_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric2(this.parte_inicio_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric2(this.parte_cierre_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric2(this.parte_plot_twist_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric2(this.Nro_series.getText())){
//                Valida si todos los campos son valores numericos mayores que cero
//                Si se entra aquí, se debe escribir en el JSON los valores escritos en la interfaz
                if(Integer.parseInt(this.Productor_Intros_TLOU.getText()) + Integer.parseInt(this.Productor_Plot_Twist_TLOU.getText())+Integer.parseInt(this.Productor_Cierre_TLOU.getText())+Integer.parseInt(this.Productor_Creditos_TLOU.getText()) + Integer.parseInt(this.Productor_Inicio_TLOU.getText()) > 19){
                    this.Mensaje.setText("Revise los productores");
                    JOptionPane.showMessageDialog(null,"La cantidad total de productores se encuentra por encima de 19","ERROR",JOptionPane.ERROR_MESSAGE);
                    
                    
                }else if(Integer.parseInt(this.Productor_Intros_VELMA.getText()) + Integer.parseInt(this.Productor_Plot_Twist_VELMA.getText())+Integer.parseInt(this.Productor_Cierre_VELMA.getText())+Integer.parseInt(this.Productor_Creditos_VELMA.getText()) +Integer.parseInt(this.Productor_Inicio_VELMA.getText()) > 18){
                    this.Mensaje.setText("Revise los productores");
                    JOptionPane.showMessageDialog(null,"La cantidad total de productores se encuentra por encima de 19","ERROR",JOptionPane.ERROR_MESSAGE);
                    
                    
                }else if(Integer.parseInt(this.Productor_Intros_VELMA.getText()) ==0|| Integer.parseInt(this.Productor_Plot_Twist_VELMA.getText())==0||Integer.parseInt(this.Productor_Cierre_VELMA.getText())==0||Integer.parseInt(this.Productor_Creditos_VELMA.getText()) ==0||Integer.parseInt(this.Productor_Inicio_VELMA.getText()) ==0|| 
                        Integer.parseInt(this.parte_cierre_max_MainFrame.getText())==0||Integer.parseInt(this.parte_creditos_max_MainFrame.getText())==0||Integer.parseInt(this.parte_inicio_max_MainFrame.getText())==0||Integer.parseInt(this.parte_plot_twist_max_MainFrame.getText())==0||Integer.parseInt(this.parte_intro_max_MainFrame.getText())==0|| Integer.parseInt(this.Dia_en_segundos_MainFrame_text.getText()) ==0||Integer.parseInt(this.Dias_entre_despachos_MainFrame_text.getText()) == 0 ||Integer.parseInt(this.Nro_series.getText()) == 0 ){
                    this.Mensaje.setText("Debe ingresar un numero > 0");
                    JOptionPane.showMessageDialog(null,"Debe ingresar un numero > 0","ERROR",JOptionPane.ERROR_MESSAGE);
                    
                
                }    
            else if(JSONReaderWriter.isPositiveNumeric(this.Dia_en_segundos_MainFrame_text.getText()) && JSONReaderWriter.isPositiveNumeric(this.Dias_entre_despachos_MainFrame_text.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Intros_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Creditos_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Inicio_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Cierre_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Plot_Twist_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Ensamblador_TLOU.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Intros_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Creditos_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Inicio_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Cierre_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.Productor_Plot_Twist_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.Ensamblador_VELMA.getText()) && JSONReaderWriter.isPositiveNumeric(this.parte_intro_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.parte_creditos_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.parte_inicio_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.parte_cierre_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.parte_plot_twist_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.Nro_series.getText())){
//                Valida si todos los campos son valores numericos mayores que cero
//                Si se entra aquí, se debe escribir en el JSON los valores escritos en la interfaz
                
    //                Casteamos las cajitas de checkbox a String
                    String Capacidad_infinita_intro = String.valueOf(this.Capacidad_infinita_intro_checkbox.isSelected());
                    String Capacidad_infinita_credito = String.valueOf(this.Capacidad_infinita_creditos_checkbox.isSelected());
                    String Capacidad_infinita_inicio = String.valueOf(this.Capacidad_infinita_inicio_checkbox.isSelected());
                    String Capacidad_infinita_cierre = String.valueOf(this.Capacidad_infinita_cierre_checkbox.isSelected());
                    String Capacidad_infinita_plot_twist = String.valueOf(this.Capacidad_infinita_plot_twist_checkbox.isSelected());
                    
                    


    //                Se escribe en el JSON todos los datos recopilados
                    jsnrw.Writer(this.Dia_en_segundos_MainFrame_text.getText(), this.Dias_entre_despachos_MainFrame_text.getText(), this.parte_intro_max_MainFrame.getText(), Capacidad_infinita_intro, this.parte_creditos_max_MainFrame.getText(), Capacidad_infinita_credito, this.parte_inicio_max_MainFrame.getText(), Capacidad_infinita_inicio, this.parte_cierre_max_MainFrame.getText(), Capacidad_infinita_cierre, this.parte_plot_twist_max_MainFrame.getText(), Capacidad_infinita_plot_twist, this.Productor_Intros_TLOU.getText(), this.Productor_Creditos_TLOU.getText(), this.Productor_Inicio_TLOU.getText(), this.Productor_Cierre_TLOU.getText(), this.Productor_Plot_Twist_TLOU.getText(), this.Productor_Intros_VELMA.getText(), this.Productor_Creditos_VELMA.getText(), this.Productor_Inicio_VELMA.getText(), this.Productor_Cierre_VELMA.getText(), this.Productor_Plot_Twist_VELMA.getText(), this.Ensamblador_TLOU.getText(), this.Ensamblador_VELMA.getText(), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_jose), String.valueOf(JSONReaderWriter.Ingresos_Rodaje_andy), String.valueOf(JSONReaderWriter.Costos_Rodaje_jose), String.valueOf(JSONReaderWriter.Costos_Rodaje_andy));
    //                Se lee el JSON para que se carguen los datos en el programa
                    jsnrw.Reader();                
    //                Ahora se pasa a la siguiente interfaz
                    this.PasarSiguienteInterfaz();
                }
            }
            
            else if(JSONReaderWriter.isEmpty(this.Dia_en_segundos_MainFrame_text.getText()) && JSONReaderWriter.isEmpty(this.Dias_entre_despachos_MainFrame_text.getText()) && JSONReaderWriter.isEmpty(this.Productor_Intros_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Productor_Creditos_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Productor_Inicio_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Productor_Cierre_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Productor_Plot_Twist_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Ensamblador_TLOU.getText()) && JSONReaderWriter.isEmpty(this.Productor_Intros_VELMA.getText()) && JSONReaderWriter.isEmpty(this.Productor_Creditos_VELMA.getText()) && JSONReaderWriter.isEmpty(this.Productor_Inicio_VELMA.getText()) && JSONReaderWriter.isEmpty(this.Productor_Cierre_VELMA.getText()) && JSONReaderWriter.isEmpty(this.Productor_Plot_Twist_VELMA.getText()) && JSONReaderWriter.isEmpty(this.Ensamblador_VELMA.getText()) && JSONReaderWriter.isEmpty(this.parte_intro_max_MainFrame.getText()) && JSONReaderWriter.isEmpty(this.parte_creditos_max_MainFrame.getText()) && JSONReaderWriter.isEmpty(this.parte_inicio_max_MainFrame.getText()) && JSONReaderWriter.isEmpty(this.parte_cierre_max_MainFrame.getText()) && JSONReaderWriter.isEmpty(this.parte_plot_twist_max_MainFrame.getText()) && JSONReaderWriter.isPositiveNumeric(this.Nro_series.getText())){
//                Si entra aqui, significa que está todo vacío, por lo tanto, tomamos el JSON por defecto

                this.Mensaje.setText("Introduzca los datos menor");
                JOptionPane.showMessageDialog(null,"Introduzca los datos menor","ERROR",JOptionPane.ERROR_MESSAGE);
                
                
                
            }else if(JSONReaderWriter.isEmpty(this.Dia_en_segundos_MainFrame_text.getText()) || JSONReaderWriter.isEmpty(this.Dias_entre_despachos_MainFrame_text.getText()) || JSONReaderWriter.isEmpty(this.Productor_Intros_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Productor_Creditos_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Productor_Inicio_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Productor_Cierre_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Productor_Plot_Twist_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Ensamblador_TLOU.getText()) || JSONReaderWriter.isEmpty(this.Productor_Intros_VELMA.getText()) || JSONReaderWriter.isEmpty(this.Productor_Creditos_VELMA.getText()) || JSONReaderWriter.isEmpty(this.Productor_Inicio_VELMA.getText()) || JSONReaderWriter.isEmpty(this.Productor_Cierre_VELMA.getText()) || JSONReaderWriter.isEmpty(this.Productor_Plot_Twist_VELMA.getText()) || JSONReaderWriter.isEmpty(this.Ensamblador_VELMA.getText()) || JSONReaderWriter.isEmpty(this.parte_intro_max_MainFrame.getText()) || JSONReaderWriter.isEmpty(this.parte_creditos_max_MainFrame.getText()) || JSONReaderWriter.isEmpty(this.parte_inicio_max_MainFrame.getText()) || JSONReaderWriter.isEmpty(this.parte_cierre_max_MainFrame.getText()) || JSONReaderWriter.isEmpty(this.parte_plot_twist_max_MainFrame.getText()) || JSONReaderWriter.isEmpty(this.Nro_series.getText())){
                this.Mensaje.setText("Debe ingresar un numero > 0");
                JOptionPane.showMessageDialog(null,"Debe ingresar un numero > 0","ERROR",JOptionPane.ERROR_MESSAGE);
            
                
                
            }else{
                this.Mensaje.setText("Dato invalido");
                JOptionPane.showMessageDialog(null,"Tipo de dato invalido","ERROR",JOptionPane.ERROR_MESSAGE);
            
                
            }
            
        }catch(FileNotFoundException e){
            
            this.Mensaje.setText(String.valueOf(e));
//            System.out.println(e);
        }
        
        
        
    }//GEN-LAST:event_btnAggUsuarioActionPerformed

    private void parte_intro_max_MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parte_intro_max_MainFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parte_intro_max_MainFrameActionPerformed

    private void Dias_entre_despachos_MainFrame_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dias_entre_despachos_MainFrame_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Dias_entre_despachos_MainFrame_textActionPerformed

    private void Dia_en_segundos_MainFrame_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dia_en_segundos_MainFrame_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Dia_en_segundos_MainFrame_textActionPerformed

    private void parte_creditos_max_MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parte_creditos_max_MainFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parte_creditos_max_MainFrameActionPerformed

    private void parte_cierre_max_MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parte_cierre_max_MainFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parte_cierre_max_MainFrameActionPerformed

    private void parte_inicio_max_MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parte_inicio_max_MainFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parte_inicio_max_MainFrameActionPerformed

    private void parte_plot_twist_max_MainFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parte_plot_twist_max_MainFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_parte_plot_twist_max_MainFrameActionPerformed

    private void Capacidad_infinita_intro_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capacidad_infinita_intro_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Capacidad_infinita_intro_checkboxActionPerformed

    private void Capacidad_infinita_creditos_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capacidad_infinita_creditos_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Capacidad_infinita_creditos_checkboxActionPerformed

    private void Capacidad_infinita_inicio_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capacidad_infinita_inicio_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Capacidad_infinita_inicio_checkboxActionPerformed

    private void Capacidad_infinita_cierre_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capacidad_infinita_cierre_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Capacidad_infinita_cierre_checkboxActionPerformed

    private void Capacidad_infinita_plot_twist_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Capacidad_infinita_plot_twist_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Capacidad_infinita_plot_twist_checkboxActionPerformed

    private void Productor_Intros_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Intros_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Intros_TLOUActionPerformed

    private void Productor_Creditos_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Creditos_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Creditos_TLOUActionPerformed

    private void Productor_Inicio_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Inicio_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Inicio_TLOUActionPerformed

    private void Productor_Cierre_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Cierre_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Cierre_TLOUActionPerformed

    private void Ensamblador_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ensamblador_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ensamblador_VELMAActionPerformed

    private void Productor_Intros_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Intros_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Intros_VELMAActionPerformed

    private void Productor_Creditos_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Creditos_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Creditos_VELMAActionPerformed

    private void Productor_Inicio_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Inicio_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Inicio_VELMAActionPerformed

    private void Productor_Cierre_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Cierre_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Cierre_VELMAActionPerformed

    private void Productor_Plot_Twist_VELMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Plot_Twist_VELMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Plot_Twist_VELMAActionPerformed

    private void Productor_Plot_Twist_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Productor_Plot_Twist_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Productor_Plot_Twist_TLOUActionPerformed

    private void Ensamblador_TLOUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ensamblador_TLOUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ensamblador_TLOUActionPerformed

    private void ReseteoHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReseteoHardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReseteoHardActionPerformed

    private void Nro_seriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nro_seriesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nro_seriesActionPerformed

    private void MensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MensajeActionPerformed

    private void Dia_en_segundos_MainFrame_textInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Dia_en_segundos_MainFrame_textInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_Dia_en_segundos_MainFrame_textInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JCheckBox Capacidad_infinita_cierre_checkbox;
    private javax.swing.JCheckBox Capacidad_infinita_creditos_checkbox;
    private javax.swing.JCheckBox Capacidad_infinita_inicio_checkbox;
    private javax.swing.JCheckBox Capacidad_infinita_intro_checkbox;
    private javax.swing.JCheckBox Capacidad_infinita_plot_twist_checkbox;
    private javax.swing.JTextField Dia_en_segundos_MainFrame_text;
    private javax.swing.JTextField Dias_entre_despachos_MainFrame_text;
    private javax.swing.JTextField Ensamblador_TLOU;
    private javax.swing.JTextField Ensamblador_VELMA;
    private javax.swing.JTextField Mensaje;
    private javax.swing.JTextField Nro_series;
    private javax.swing.JTextField Productor_Cierre_TLOU;
    private javax.swing.JTextField Productor_Cierre_VELMA;
    private javax.swing.JTextField Productor_Creditos_TLOU;
    private javax.swing.JTextField Productor_Creditos_VELMA;
    private javax.swing.JTextField Productor_Inicio_TLOU;
    private javax.swing.JTextField Productor_Inicio_VELMA;
    private javax.swing.JTextField Productor_Intros_TLOU;
    private javax.swing.JTextField Productor_Intros_VELMA;
    private javax.swing.JTextField Productor_Plot_Twist_TLOU;
    private javax.swing.JTextField Productor_Plot_Twist_VELMA;
    private javax.swing.JCheckBox ReseteoHard;
    private javax.swing.JButton btnAggUsuario;
    private javax.swing.JLabel ganancias_anterior_VELMA;
    private javax.swing.JLabel gananias_anterior_TLOU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField parte_cierre_max_MainFrame;
    private javax.swing.JTextField parte_creditos_max_MainFrame;
    private javax.swing.JTextField parte_inicio_max_MainFrame;
    private javax.swing.JTextField parte_intro_max_MainFrame;
    private javax.swing.JTextField parte_plot_twist_max_MainFrame;
    // End of variables declaration//GEN-END:variables
}
