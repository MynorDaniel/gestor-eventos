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
        InscripcionServicio is = new InscripcionServicio();
        //EventoServicio es = new EventoServicio();
        //ActividadServicio as = new ActividadServicio();
        AsistenciaServicio as = new AsistenciaServicio();
        
        String codigoActividad = "ACT-001";
        String correoImpartidor = "mynordma@gmail.com";
        
        System.out.println("Confirmando asistencia");
        Resultado r2 = is.confirmarInscripcion("EVT-100", correoImpartidor);
        System.out.println(r2.getMensaje());

        System.out.println("Asignando a evento");
        Resultado r = as.crearAsistencia(codigoActividad, correoImpartidor);
        System.out.println(r.getMensaje());
        
        
        
    }
}