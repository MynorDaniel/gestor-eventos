/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
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
    
    public Resultado crearPago(Pago pago){
        return new Resultado<>("", "");
    }
    
    public boolean existePago(Pago pago){
        return true;
    }
}
