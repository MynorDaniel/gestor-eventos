/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.persistencia.AsistenciaDB;

/**
 * Clase que recibe parametros sin procesar desde el usuario, los valida y arma los modelos para
 * realizar peticiones a AsistenciaDB
 * @author mynordma
 */
public class AsistenciaServicio {
    
    private final AsistenciaDB asistenciaDB;
    
    public AsistenciaServicio(){
        asistenciaDB = new AsistenciaDB();
    }
    
    public Resultado crearAsistencia(String codigoActividad, String correoParticipante){
        
        ActividadServicio actividadServicio = new ActividadServicio();
        
        if(!correoParticipante.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
            return new Resultado<>("Correo invalido", "");
        }else if(!actividadServicio.hayCupo(codigoActividad)){
            return new Resultado<>("No hay cupos disponibles", "");
        }else if(!actividadServicio.participanteAceptable(codigoActividad, correoParticipante)){
            return new Resultado<>("El participante no puede asignarse a esta actividad", "");
        }else if(codigoActividad.trim().isEmpty()){
            return new Resultado<>("Codigo invalido", "");
        }
        
        return asistenciaDB.crearAsistencia(new Asistencia(codigoActividad, correoParticipante));
    }
    
    public boolean existeAsistencia(String codigoEvento, String correoParticipante){
        return asistenciaDB.existeAsistencia(codigoEvento, correoParticipante);
    }
}