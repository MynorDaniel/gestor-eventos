/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.servicios.*;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        PagoServicio is = new PagoServicio();
        //InscripcionServicio is = new InscripcionServicio();
        
        String codigo = "EVT-100";
        String correo = "mynordma@gmail.com";

        Resultado r = is.crearPago(codigo, correo, "100", "tarjeta");
        System.out.println(r.getMensaje());
        
    }
}