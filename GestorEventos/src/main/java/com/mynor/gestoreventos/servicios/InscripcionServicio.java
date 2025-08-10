/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.persistencia.InscripcionDB;

/**
 *
 * @author mynordma
 */
public class InscripcionServicio {
    
    private final InscripcionDB inscripcionDB;
    private final EventoServicio eventoServicio;
    private final PagoServicio pagoServicio;
    
    public InscripcionServicio(){
        inscripcionDB = new InscripcionDB();
        eventoServicio = new EventoServicio();
        pagoServicio = new PagoServicio();
    }
    
    public Resultado crearInscripcion(Inscripcion inscripcion){
        return null;
    }
    
    public Resultado confirmarInscripcion(Inscripcion inscripcion){
        return new Resultado<>("", "");
    }
}
