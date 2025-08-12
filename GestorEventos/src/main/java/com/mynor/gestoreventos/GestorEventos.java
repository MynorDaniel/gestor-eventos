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
        //PagoServicio is = new PagoServicio();
        //InscripcionServicio is = new InscripcionServicio();
        EventoServicio es = new EventoServicio();
        
        String codigo = "EVT-100";
        //String correo = "mynordma@gmail.com";
        
        boolean hayCupo = es.hayCupo(codigo);
        System.out.println(hayCupo);
        
    }
}