/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mynor.gestoreventos.vista;

import com.mynor.gestoreventos.modelos.enums.TipoInstruccion;
import java.awt.Color;

/**
 *
 * @author mynordma
 */
public class ReporteActividadesForm extends javax.swing.JInternalFrame {

    private final Ventana ventana;

    public ReporteActividadesForm(Ventana ventana) {
        initComponents();
        this.ventana = ventana;
        setTitle("Generar Reporte De Actividades");
        setBackground(new Color(255, 243, 224));
        setClosable(true);
        setResizable(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigoTextField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        correoTextField = new javax.swing.JTextField();
        generar = new javax.swing.JButton();

        jLabel1.setText("Codigo del evento (obligatorio)");

        jLabel2.setText("Tipo de actividad (opcional)");

        jLabel3.setText("Correo del encargado (opcional)");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "CHARLA", "TALLER", "DEBATE", "OTRA" }));

        generar.setText("Generar HTML");
        generar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                generarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoTextField)
                            .addComponent(jComboBox1, 0, 135, Short.MAX_VALUE)
                            .addComponent(correoTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(generar)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(correoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(generar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarMouseClicked
        String[] parametros;
        parametros = new String[]{codigoTextField.getText(), jComboBox1.getSelectedItem().toString(), correoTextField.getText()};
        ventana.procesarParametros(parametros, TipoInstruccion.REPORTE_ACTIVIDADES);
    }//GEN-LAST:event_generarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JTextField correoTextField;
    private javax.swing.JButton generar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
