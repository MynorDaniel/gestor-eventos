/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.persistencia.ActividadDB;

/**
 *
 * @author mynordma
 */
public class ActividadServicio {
    
    private final ActividadDB actividadDB;
    
    public ActividadServicio(){
        actividadDB = new ActividadDB();
    }
    
    public Resultado crearActividad(Actividad actividad){
        return null;
    }
    
    public boolean hayCupo(Actividad actividad){
        return true;
    }
    
    public boolean participanteAceptado(Asistencia asistencia){
        return true;
    }
    
    public Resultado obtenerActividades(String evento, String tipoActividad, String correoEncargado){
        return null;
    }
}
