/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.MetodoPago;
import com.mynor.gestoreventos.persistencia.InscripcionDB;
import com.mynor.gestoreventos.persistencia.PagoDB;

/**
 *
 * @author mynordma
 */
public class PagoServicio {
    
    private final PagoDB pagoDB;
    
    public PagoServicio(){
        pagoDB = new PagoDB();
    }
    
    public Resultado crearPago(String codigoEvento, String correoParticipante, String monto, String metodoPagoParam){
        
        boolean correoValido = correoParticipante.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        boolean montoValido = monto.matches("^(?!0+(\\.0+)?$)\\d+(\\.\\d{1,2})?$");
        
        
        if(!correoValido){
            return new Resultado<>("Correo del participante invalido", "");
        }else if(!montoValido){
            return new Resultado<>("Monto invalido", "");
        }else if(!(new InscripcionDB().existeInscripcion(codigoEvento, correoParticipante))){
            return new Resultado<>("No existe la inscripcion", "");
        }
        
        try {
            MetodoPago metodoPago = MetodoPago.valueOf(metodoPagoParam.toUpperCase());
            Pago pago = new Pago(codigoEvento, correoParticipante, Double.parseDouble(monto), metodoPago);
            return pagoDB.crearPago(pago);
        } catch (IllegalArgumentException e) {
            return new Resultado<>("Metodo de pago invalido", "");
        }
    }
    
    public boolean existePago(String codigoEvento, String correoParticipante){
        return pagoDB.existePago(codigoEvento, correoParticipante);
    }
}
