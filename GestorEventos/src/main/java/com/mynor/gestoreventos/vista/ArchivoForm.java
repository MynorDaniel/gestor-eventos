/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mynor.gestoreventos.vista;

import com.mynor.gestoreventos.modelos.Instruccion;
import com.mynor.gestoreventos.servicios.ArchivoServicio;
import com.mynor.gestoreventos.servicios.Ejecutor;
import java.awt.Color;
import java.io.File;
import java.util.LinkedList;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mynordma
 */
public class ArchivoForm extends javax.swing.JInternalFrame {
    
    private String URL = "";
    private final Ventana ventana;

    public ArchivoForm(Ventana ventana) {
        initComponents();
        this.ventana = ventana;
        setTitle("Abrir Archivo");
        setBackground(new Color(255, 243, 224));
        setClosable(true);
        setResizable(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abrir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        velocidadTextField = new javax.swing.JTextField();
        urlLabel = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();

        abrir.setText("Abrir");
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirMouseClicked(evt);
            }
        });

        jLabel1.setText("Velocidad (milisegundos)");

        jLabel2.setText("Ruta del archivo");

        velocidadTextField.setText("0");
        velocidadTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velocidadTextFieldActionPerformed(evt);
            }
        });

        urlLabel.setText("/...");

        aceptar.setText("Aceptar");
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(abrir)
                                    .addComponent(velocidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(aceptar)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(velocidadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(abrir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(urlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void velocidadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velocidadTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_velocidadTextFieldActionPerformed

    private void abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseClicked
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.FILES_ONLY); // solo archivos
        jf.setDialogTitle("Seleccionar archivo .txt");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        jf.setFileFilter(filter);

        int result = jf.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File archivo = jf.getSelectedFile();

            if (archivo.getName().toLowerCase().endsWith(".txt")) {
                URL = archivo.getAbsolutePath();
                urlLabel.setText(URL);
            } else {
                JOptionPane.showMessageDialog(this, "Solo se permiten archivos .txt", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_abrirMouseClicked

    private void aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseClicked
        String urlReporte = ventana.getUrlReportes();
        
        ArchivoServicio as = new ArchivoServicio(URL);
        LinkedList<Instruccion> instrucciones = as.obtenerInstrucciones();
        
        Ejecutor ejecutor = new Ejecutor();
        
        if(instrucciones != null && !instrucciones.isEmpty()){
            
            new Thread(() -> {
                instrucciones.stream().filter(obj -> Objects.nonNull(obj)) .forEach(i -> {
                    System.out.println("Ejecutando instrucción " + i.toString());
                    
                    SwingUtilities.invokeLater(() -> {
                        ventana.getConsola().append("\n");
                        ventana.getConsola().append("Ejecutando instrucción " + i.toString());
                    });
                    ejecutor.ejecutar(urlReporte, i, velocidadTextField.getText().trim(), log -> {
                        System.out.println(log + " " + i.toString());
                        SwingUtilities.invokeLater(() -> {
                            ventana.getConsola().append("\n");
                            ventana.getConsola().append(log + " " + i.toString());
                            ventana.getConsola().setCaretPosition(ventana.getConsola().getDocument().getLength());
                        });
                        
                    });
                });
            }).start();
            
        }
    }//GEN-LAST:event_aceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField velocidadTextField;
    // End of variables declaration//GEN-END:variables
}
