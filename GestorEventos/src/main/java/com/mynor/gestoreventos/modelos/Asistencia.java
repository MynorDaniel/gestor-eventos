/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

/**
 *
 * @author mynordma
 */
public class Asistencia {
    
    private String codigoActividad;
    private String correoParticipante;

    public Asistencia(String codigoActividad, String correoParticipante) {
        this.codigoActividad = codigoActividad;
        this.correoParticipante = correoParticipante;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }
}
