/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import com.mynor.gestoreventos.persistencia.ParticipanteDB;

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
        
        String html = """
                      
                      """;
        return null;
    }
}
