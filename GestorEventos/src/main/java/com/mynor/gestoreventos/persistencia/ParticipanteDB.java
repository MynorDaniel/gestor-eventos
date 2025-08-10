/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;

/**
 *
 * @author mynordma
 */
public class ParticipanteDB {
    
    private final Conexion conexion;

    public ParticipanteDB() {
        conexion = new Conexion();
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
}