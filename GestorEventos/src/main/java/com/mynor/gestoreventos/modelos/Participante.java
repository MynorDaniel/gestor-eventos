/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoParticipante;

/**
 *
 * @author mynordma
 */
public class Participante {
    
    private String correo;
    private String nombre;
    private TipoParticipante tipo;
    private String institucion;
    private Pago pagoAEvento;
    private String validado;

    public Participante(String correo, String nombre, TipoParticipante tipo, String institucion) {
        this.correo = correo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.institucion = institucion;
    }

    public Participante() {
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

    public Pago getPagoAEvento() {
        return pagoAEvento;
    }

    public void setPagoAEvento(Pago pagoAEvento) {
        this.pagoAEvento = pagoAEvento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoParticipante getTipo() {
        return tipo;
    }

    public void setTipo(TipoParticipante tipo) {
        this.tipo = tipo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
}
