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
        //EventoServicio es = new EventoServicio();
        ActividadServicio as = new ActividadServicio();
        //AsistenciaServicio as = new AsistenciaServicio();
        //ParticipanteServicio ps = new ParticipanteServicio();
        
        String codigoEvento = "EVT-100";
        String correo = "mynordma@gmail.com";
        
        System.out.println("Obteniendo actividades...");
        Resultado r = as.obtenerActividades("EVT-100", "TALLER", "mynorma@gmail.com", "test");
        System.out.println(r.getMensaje());
        
    }
}