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
    private final AsistenciaServicio asistenciaServicio;
    
    public ParticipanteServicio(){
        participanteDB = new ParticipanteDB();
        asistenciaServicio = new AsistenciaServicio();
    }
    
    public Resultado crearParticipante(Participante participante){
        return new Resultado<>("", "");
    }
    
    public TipoParticipante obtenerTipo(Participante participante){
        return TipoParticipante.ESTUDIANTE;
    }
    
    public Resultado obtenerParticipantes(String evento, String tipoParticipante, String institucion){
        return new Resultado<>("", "");
    }
    
    public Resultado generarCertificado(Inscripcion inscripcion){
        return null;
    }
}
