/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoInscripcion;

/**
 *
 * @author mynordma
 */
public class Inscripcion {
    
    private String codigoEvento;
    private String correoParticipante;
    private TipoInscripcion tipo;
    private boolean confirmada;

    public Inscripcion(String codigoEvento, String correoParticipante, TipoInscripcion tipo, boolean confirmada) {
        this.codigoEvento = codigoEvento;
        this.correoParticipante = correoParticipante;
        this.tipo = tipo;
        this.confirmada = confirmada;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getCorreoParticipante() {
        return correoParticipante;
    }

    public void setCorreoParticipante(String correoParticipante) {
        this.correoParticipante = correoParticipante;
    }

    public TipoInscripcion getTipo() {
        return tipo;
    }

    public void setTipo(TipoInscripcion tipo) {
        this.tipo = tipo;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
}
