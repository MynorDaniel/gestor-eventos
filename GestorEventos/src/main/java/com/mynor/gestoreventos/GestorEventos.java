/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.Resultado;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import com.mynor.gestoreventos.servicios.EventoServicio;
import com.mynor.gestoreventos.servicios.ParticipanteServicio;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        EventoServicio es = new EventoServicio();
        
        String codigo = "EVT-100";
        String ubicacion = "Quetgo";
        String cupoMaximo = "10";
        String titulo = "Hola";
        String tipo = "CHARLA";
        String fecha = "10/10/2013";

        Resultado r = es.crearEvento(codigo, ubicacion, cupoMaximo, titulo, tipo, fecha);
        System.out.println(r.getMensaje());
        
    }
}