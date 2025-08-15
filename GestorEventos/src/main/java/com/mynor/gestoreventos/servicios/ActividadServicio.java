/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoActividad;
import com.mynor.gestoreventos.modelos.enums.TipoInscripcion;
import com.mynor.gestoreventos.persistencia.ActividadDB;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author mynordma
 */
public class ActividadServicio {
    
    private final ActividadDB actividadDB;
    
    public ActividadServicio(){
        actividadDB = new ActividadDB();
    }
    
    public Resultado crearActividad(String codigo, String correoImpartidor, String codigoEvento, 
            String horaInicioParam, String horaFinParam, String cupoMaximo, String tipo, String titulo){
        
        boolean correoValido = correoImpartidor.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        boolean tituloValido = titulo.length() <= 200;
        
        if(!correoValido){
            return new Resultado<>("Correo invalido", "");
        }else if(!tituloValido){
            return new Resultado<>("Titulo demasiado grande", "");
        }
        
        InscripcionServicio inscripcionServicio = new InscripcionServicio();
        TipoInscripcion tipoInscripcion = inscripcionServicio.obtenerTipo(correoImpartidor, codigoEvento);
        if(tipoInscripcion == null || tipoInscripcion == TipoInscripcion.ASISTENTE){
            return new Resultado<>("Inscripcion invalida, verifica que el participante no sea de tipo asistente", "");
        }

        try {
            int cupo = Integer.parseInt(cupoMaximo);
            
            if(cupo < 0){
                return new Resultado<>("Cupo invalido", "");
            }
            
            TipoActividad tipoActividad = TipoActividad.valueOf(tipo.toUpperCase());
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime horaInicio = LocalTime.parse(horaInicioParam, dtf);
            LocalTime horaFin = LocalTime.parse(horaFinParam, dtf);
            
            Actividad actividad = new Actividad(codigo, correoImpartidor, codigoEvento, horaInicio, horaFin, cupo, tipoActividad, titulo);
            
            return actividadDB.crearActividad(actividad);
            
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println(e.getMessage());
            return new Resultado<>("Datos del evento invalidos", "");
        }
        
    }
    
    public boolean hayCupo(String codigoActividad){
        return actividadDB.hayCupo(codigoActividad);
    }
    
    public Resultado obtenerActividades(String evento, String tipoActividad, String correoEncargado){
        return null;
    }

    public boolean participanteAceptable(String codigoActividad, String correoParticipante) {
        return actividadDB.participanteAceptable(codigoActividad, correoParticipante);
    }
}
