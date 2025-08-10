/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.persistencia.AsistenciaDB;

/**
 *
 * @author mynordma
 */
public class AsistenciaServicio {
    
    private final AsistenciaDB asistenciaDB;
    private final ActividadServicio actividadServicio;
    
    public AsistenciaServicio(){
        asistenciaDB = new AsistenciaDB();
        actividadServicio = new ActividadServicio();
    }
    
    public Resultado crearAsistencia(Asistencia asistencia){
        return null;
    }
    
    public boolean existeAsistencia(Inscripcion inscripcion){
        return true;
    }
}
