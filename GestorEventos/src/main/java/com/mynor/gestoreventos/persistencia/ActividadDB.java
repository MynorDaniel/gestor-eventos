/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;

/**
 *
 * @author mynordma
 */
public class ActividadDB {
    
    private final Conexion conexion;

    public ActividadDB() {
        conexion = new Conexion();
    }
    
    public Resultado crearActividad(Actividad actividad){
        return new Resultado<>("", "");
    }
    
    public boolean hayCupo(Actividad actividad){
        return true;
    }
    
    public boolean participanteAceptado(Asistencia asistencia){
        return true;
    }
    
    public Resultado obtenerActividades(String evento, String tipoActividad, String correoEncargado){
        return new Resultado<>("", "");
    }
}
