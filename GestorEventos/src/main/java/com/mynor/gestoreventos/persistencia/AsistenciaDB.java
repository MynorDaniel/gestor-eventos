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
public class AsistenciaDB {
    
    public Resultado crearAsistencia(Asistencia asistencia){
        return new Resultado<>("", "");
    }
    
    public boolean existeAsistencia(Inscripcion inscripcion){
        return true;
    }
}
