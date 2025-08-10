/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.MetodoPago;

/**
 *
 * @author mynordma
 */
public class Pago {
    
    private String codigoEvento;
    private String correoParticipante;
    private double monto;
    private MetodoPago metodoPago;

    public Pago(String codigoEvento, String correoParticipante, double monto, MetodoPago metodoPago) {
        this.codigoEvento = codigoEvento;
        this.correoParticipante = correoParticipante;
        this.monto = monto;
        this.metodoPago = metodoPago;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public boolean isValid(){
        return true;
    }
}
