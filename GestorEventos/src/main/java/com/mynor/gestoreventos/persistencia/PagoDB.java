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
public class PagoDB {
    
    private final Conexion conexion;

    public PagoDB() {
        conexion = new Conexion();
    }
    
    public Resultado crearPago(Pago pago){
        return new Resultado<>("", "");
    }
    
    public boolean existePago(Pago pago){
        return true;
    }
}
