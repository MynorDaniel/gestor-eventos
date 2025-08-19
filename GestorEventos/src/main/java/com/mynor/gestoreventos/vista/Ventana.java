/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mynor.gestoreventos.vista;

import com.mynor.gestoreventos.modelos.Instruccion;
import com.mynor.gestoreventos.modelos.enums.TipoInstruccion;
import com.mynor.gestoreventos.servicios.Ejecutor;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Ventana principal de la aplicacion
 * @author mynordma
 */
public class Ventana extends javax.swing.JFrame {
    
    private final JDesktopPane jd;
    private final JTextArea consola;
    private String urlReportes = "";
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Gestor de Eventos");

        jd = new JDesktopPane();
        jd.setBackground(new Color(255, 224, 178));

        consola = new JTextArea("Logs...");
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
        crearParticipante = new javax.swing.JMenuItem();
        eventos = new javax.swing.JMenu();
        crearEvento = new javax.swing.JMenuItem();
        inscripciones = new javax.swing.JMenu();
        crearInscripcion = new javax.swing.JMenuItem();
        validarInscripcion = new javax.swing.JMenuItem();
        pagos = new javax.swing.JMenu();
        crearPago = new javax.swing.JMenuItem();
        actividades = new javax.swing.JMenu();
        crearActividad = new javax.swing.JMenuItem();
        asistencias = new javax.swing.JMenu();
        crearAsistencia = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        certificado = new javax.swing.JMenuItem();
        reporteParticipantes = new javax.swing.JMenuItem();
        reporteActividades = new javax.swing.JMenuItem();
        reporteEventos = new javax.swing.JMenuItem();
        cambiarRuta = new javax.swing.JMenuItem();

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
        abrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirArchivoActionPerformed(evt);
            }
        });
        archivo.add(abrirArchivo);

        jMenuBar1.add(archivo);

        participantes.setText("Participantes");

        crearParticipante.setText("Crear");
        crearParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearParticipanteActionPerformed(evt);
            }
        });
        participantes.add(crearParticipante);

        jMenuBar1.add(participantes);

        eventos.setText("Eventos");

        crearEvento.setText("Crear");
        crearEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEventoActionPerformed(evt);
            }
        });
        eventos.add(crearEvento);

        jMenuBar1.add(eventos);

        inscripciones.setText("Inscripciones");

        crearInscripcion.setText("Crear");
        crearInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearInscripcionActionPerformed(evt);
            }
        });
        inscripciones.add(crearInscripcion);

        validarInscripcion.setText("Validar");
        validarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarInscripcionActionPerformed(evt);
            }
        });
        inscripciones.add(validarInscripcion);

        jMenuBar1.add(inscripciones);

        pagos.setText("Pagos");

        crearPago.setText("Crear");
        crearPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPagoActionPerformed(evt);
            }
        });
        pagos.add(crearPago);

        jMenuBar1.add(pagos);

        actividades.setText("Actividades");

        crearActividad.setText("Crear");
        crearActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActividadActionPerformed(evt);
            }
        });
        actividades.add(crearActividad);

        jMenuBar1.add(actividades);

        asistencias.setText("Asistencias");

        crearAsistencia.setText("Crear");
        crearAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearAsistenciaActionPerformed(evt);
            }
        });
        asistencias.add(crearAsistencia);

        jMenuBar1.add(asistencias);

        reportes.setText("Reportes");

        certificado.setText("Certificado");
        certificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                certificadoActionPerformed(evt);
            }
        });
        reportes.add(certificado);

        reporteParticipantes.setText("Participantes");
        reporteParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteParticipantesActionPerformed(evt);
            }
        });
        reportes.add(reporteParticipantes);

        reporteActividades.setText("Actividades");
        reporteActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteActividadesActionPerformed(evt);
            }
        });
        reportes.add(reporteActividades);

        reporteEventos.setText("Eventos");
        reporteEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteEventosActionPerformed(evt);
            }
        });
        reportes.add(reporteEventos);

        cambiarRuta.setText("Cambiar ruta de salida");
        cambiarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarRutaActionPerformed(evt);
            }
        });
        reportes.add(cambiarRuta);

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

    /**
     * Arma una instruccion con los datos en seco de los form y la ejecuta
     * @param parametros
     * @param tipo 
     */
    public void procesarParametros(String[] parametros, TipoInstruccion tipo){
        Instruccion instruccion = new Instruccion();
        instruccion.setParametros(parametros);
        instruccion.setTipo(tipo);
        
        Ejecutor ejecutor = new Ejecutor();
        
        System.out.println("Ejecutando instrucción " + instruccion.toString());
        ejecutor.ejecutar(getUrlReportes(), instruccion, "0", log -> {
            System.out.println(log + " " + instruccion.toString());
            consola.append("\n");
            consola.append(log + " " + instruccion.toString());
            consola.setCaretPosition(consola.getDocument().getLength());

        });
    }
    
    private void abrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirArchivoActionPerformed
        ArchivoForm form = new ArchivoForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_abrirArchivoActionPerformed

    private void crearEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEventoActionPerformed
        CrearEventoForm form = new CrearEventoForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearEventoActionPerformed

    private void crearParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearParticipanteActionPerformed
        CrearParticipanteForm form = new CrearParticipanteForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearParticipanteActionPerformed

    private void crearInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearInscripcionActionPerformed
        CrearInscripcionForm form = new CrearInscripcionForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearInscripcionActionPerformed

    private void crearPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPagoActionPerformed
        CrearPagoForm form = new CrearPagoForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearPagoActionPerformed

    private void validarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarInscripcionActionPerformed
        ValidarInscripcionForm form = new ValidarInscripcionForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_validarInscripcionActionPerformed

    private void crearActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActividadActionPerformed
        CrearActividadForm form = new CrearActividadForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearActividadActionPerformed

    private void crearAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearAsistenciaActionPerformed
        CrearAsistenciaForm form = new CrearAsistenciaForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_crearAsistenciaActionPerformed

    private void certificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_certificadoActionPerformed
        CertificadoForm form = new CertificadoForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_certificadoActionPerformed

    private void reporteParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteParticipantesActionPerformed
        ReporteParticipantesForm form = new ReporteParticipantesForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_reporteParticipantesActionPerformed

    private void reporteActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteActividadesActionPerformed
        ReporteActividadesForm form = new ReporteActividadesForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_reporteActividadesActionPerformed

    private void reporteEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteEventosActionPerformed
        ReporteEventosForm form = new ReporteEventosForm(this);
        jd.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_reporteEventosActionPerformed

    private void cambiarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarRutaActionPerformed
        setUrlReportes("");
        getUrlReportes();
    }//GEN-LAST:event_cambiarRutaActionPerformed

    public JDesktopPane getJd() {
        return jd;
    }

    public JTextArea getConsola() {
        return consola;
    }

    /**
     * Pide una url para guardar los reportes,
     * asegura que siempre haya una url para reportes valida y
     * se ejecuta solo una vez siempre que se ingrese un directorio
     * @return
     */
    public String getUrlReportes() {
        if (urlReportes != null && !urlReportes.trim().isEmpty()) {
            return urlReportes;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Seleccionar carpeta de reportes");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File carpeta = chooser.getSelectedFile();
            urlReportes = carpeta.getAbsolutePath().trim();
        }

        return urlReportes;
    }

    public void setUrlReportes(String urlReportes) {
        this.urlReportes = urlReportes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirArchivo;
    private javax.swing.JMenu actividades;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenu asistencias;
    private javax.swing.JMenuItem cambiarRuta;
    private javax.swing.JMenuItem certificado;
    private javax.swing.JMenuItem crearActividad;
    private javax.swing.JMenuItem crearAsistencia;
    private javax.swing.JMenuItem crearEvento;
    private javax.swing.JMenuItem crearInscripcion;
    private javax.swing.JMenuItem crearPago;
    private javax.swing.JMenuItem crearParticipante;
    private javax.swing.JMenu eventos;
    private javax.swing.JMenu inscripciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu pagos;
    private javax.swing.JMenu participantes;
    private javax.swing.JMenuItem reporteActividades;
    private javax.swing.JMenuItem reporteEventos;
    private javax.swing.JMenuItem reporteParticipantes;
    private javax.swing.JMenu reportes;
    private javax.swing.JMenuItem validarInscripcion;
    // End of variables declaration//GEN-END:variables
}