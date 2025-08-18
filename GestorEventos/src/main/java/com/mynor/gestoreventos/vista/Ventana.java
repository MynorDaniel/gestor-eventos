/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mynor.gestoreventos.vista;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author mynordma
 */
public class Ventana extends javax.swing.JFrame {
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestor de Eventos");

        JDesktopPane jd = new JDesktopPane();
        jd.setBackground(new Color(255, 224, 178));

        JTextArea consola = new JTextArea();
        consola.setBackground(new Color(255, 243, 224));
        consola.setEditable(false);
        JScrollPane js = new JScrollPane(consola);

        jPanel1.setLayout(new GridLayout(2, 1));

        jPanel1.add(jd);
        jPanel1.add(js);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        abrirArchivo = new javax.swing.JMenuItem();
        participantes = new javax.swing.JMenu();
        eventos = new javax.swing.JMenu();
        inscripciones = new javax.swing.JMenu();
        pagos = new javax.swing.JMenu();
        actividades = new javax.swing.JMenu();
        asistencias = new javax.swing.JMenu();
        reportes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 243, 224));
        jMenuBar1.setForeground(new java.awt.Color(11, 46, 51));

        archivo.setText("Archivo");

        abrirArchivo.setText("Abrir archivo");
        archivo.add(abrirArchivo);

        jMenuBar1.add(archivo);

        participantes.setText("Participantes");
        jMenuBar1.add(participantes);

        eventos.setText("Eventos");
        jMenuBar1.add(eventos);

        inscripciones.setText("Inscripciones");
        jMenuBar1.add(inscripciones);

        pagos.setText("Pagos");
        jMenuBar1.add(pagos);

        actividades.setText("Actividades");
        jMenuBar1.add(actividades);

        asistencias.setText("Asistencias");
        jMenuBar1.add(asistencias);

        reportes.setText("Reportes");
        jMenuBar1.add(reportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JMenu actividades;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu asistencias;
    private javax.swing.JMenu eventos;
    private javax.swing.JMenu inscripciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu pagos;
    private javax.swing.JMenu participantes;
    private javax.swing.JMenu reportes;
    // End of variables declaration//GEN-END:variables
}