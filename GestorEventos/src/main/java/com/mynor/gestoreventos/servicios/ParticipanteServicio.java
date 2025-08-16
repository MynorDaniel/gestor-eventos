/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import com.mynor.gestoreventos.persistencia.ParticipanteDB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mynordma
 */
public class ParticipanteServicio {
    
    private final ParticipanteDB participanteDB;
    
    public ParticipanteServicio(){
        participanteDB = new ParticipanteDB();
    }
    
    public Resultado crearParticipante(String correo, String nombre, String tipo, String institucion){
        
        if(!correo.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return new Resultado<>("Correo invalido", "");
        }else if(!nombre.matches("^[A-Za-z]+(\\s[A-Za-z]+)*$") || nombre.length() > 45){
            return new Resultado<>("Nombre invalido", "");
        }else if(institucion.length() > 150){
            return new Resultado<>("Nombre de la institucion demasiado grande", "");
        }
        
        try {
            TipoParticipante tipoParticipante = TipoParticipante.valueOf(tipo.toUpperCase());
            Participante participante = new Participante(correo, nombre, tipoParticipante, institucion);
            return participanteDB.crearParticipante(participante);
        } catch (IllegalArgumentException e) {
            return new Resultado<>("Tipo de participante invalido", "");
        }
        
    }
    
    public TipoParticipante obtenerTipo(String correoParticipante){
        return participanteDB.obtenerTipo(correoParticipante);
    }
    
    public Resultado obtenerParticipantes(String evento, String tipoParticipante, String institucion){
        return new Resultado<>("", "");
    }
    
    public Resultado generarCertificado(String codigoEvento, String correoParticipante, String ruta){
        
        if(!correoParticipante.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return new Resultado<>("Correo invalido", "");
        }else if(!(new AsistenciaServicio().existeAsistencia(codigoEvento, correoParticipante))){
            return new Resultado<>("El participante " + correoParticipante + " no ha asistido a ninguna actividad de " + codigoEvento, "");
        }
        
        EventoServicio eventoServicio = new EventoServicio();
        Evento evento = eventoServicio.obtenerEvento(codigoEvento);
        Participante participante = participanteDB.obtenerParticipante(correoParticipante);
        
        if(evento == null || participante == null){
            return new Resultado<>("Error al crear el certificado", "");
        }
        
        String html = String.format("""
                      <!DOCTYPE html>
                      <html lang="es">
                      <head>
                        <meta charset="utf-8" />
                        <title>Certificado de Asistencia</title>
                        <style>
                          body {
                            font-family: Arial, sans-serif;
                            padding: 40px;
                            border: 5px solid #000;
                            margin: 20px;
                            background-color: #ddd;
                          }
                          .contenedor {
                            text-align: center;
                            padding: 40px;
                            background-color: #e6f0fa;
                          }
                          h1 {
                            font-size: 32px;
                            margin-bottom: 40px;
                          }
                          p {
                            font-size: 18px;
                            margin: 10px 0;
                          }
                          .nombre {
                            font-weight: bold;
                            font-size: 24px;
                            margin: 20px 0;
                          }
                          .evento {
                            font-weight: bold;
                            font-size: 20px;
                          }
                          .fecha {
                            margin-top: 20px;
                            font-style: italic;
                          }
                          .ubicacion {
                            margin-top: 40px;
                            font-size: 18px;
                            font-weight: bold;
                          }
                        </style>
                      </head>
                      <body>
                        <div class="contenedor">
                          <h1>Certificado de Asistencia</h1>
                          <p>Se certifica que</p>
                          <p class="nombre">%s</p>
                          <p>ha asistido al evento</p>
                          <p class="evento">%s</p>
                          <p class="fecha">Realizado en la fecha: %s</p>
                          <p class="ubicacion">%s</p>
                        </div>
                      </body>
                      </html>
                      """, participante.getNombre(), evento.getTitulo(), evento.getFecha().toString(), evento.getUbicacion());
        
        try {
            generarHTML(html, ruta, correoParticipante, codigoEvento);
            return new Resultado<>("Certificado generado en la ruta: " + ruta, "");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new Resultado<>("Error al crear el certificado", "");
        }
    }
    
    private void generarHTML(String html, String ruta, String correo, String evt)throws IOException{
        File archivo = new File(ruta + "/Certificado-" + correo + "-" + evt + ".html");
        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))){
            bw.write(html);
        }
    }
}