/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.servicios.*;
import com.mynor.gestoreventos.vista.Ventana;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        //PagoServicio is = new PagoServicio();
        //InscripcionServicio is = new InscripcionServicio();
        //EventoServicio es = new EventoServicio();
        //ActividadServicio as = new ActividadServicio();
        //AsistenciaServicio as = new AsistenciaServicio();
        //ParticipanteServicio ps = new ParticipanteServicio();
        /*ArchivoServicio as = new ArchivoServicio("prueba.txt");
        LinkedList<Instruccion> instrucciones = as.obtenerInstrucciones();
        
        
        Ejecutor ejecutor = new Ejecutor();
        
        
        if(instrucciones != null && !instrucciones.isEmpty()){
        instrucciones.stream().filter(obj -> Objects.nonNull(obj)) .forEach(i -> {
        System.out.println("Ejecutando instrucción " + i.toString());
        ejecutor.ejecutar("test", i, 0, log -> {
        System.out.println(log + " " + i.toString());
        });
        });
        }*/
        
        Ventana v = new Ventana();
        v.setVisible(true);
        
    }
}