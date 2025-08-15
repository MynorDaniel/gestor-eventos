/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.servicios.*;
import java.util.ArrayList;

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
        
        String codigo = "ACT-001";
        String correoImpartidor = "mynordma@gmail.com";
        String codigoEvento = "EVT-100";
        String horaInicio = "09:00";
        String horaFin = "11:30";
        String cupoMaximo = "50";
        String tipo = "TALLER";
        String titulo = "Introducción a Java";

        Resultado r = as.crearActividad(codigo, correoImpartidor, codigoEvento, horaInicio, horaFin, cupoMaximo, tipo, titulo);
        System.out.println(r.getMensaje());
        
        
        
    }
}