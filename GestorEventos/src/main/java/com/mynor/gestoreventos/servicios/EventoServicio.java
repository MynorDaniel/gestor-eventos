/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.persistencia.EventoDB;

/**
 *
 * @author mynordma
 */
public class EventoServicio {
    
    private final EventoDB eventoDB;
    
    public EventoServicio(){
        eventoDB = new EventoDB();
    }
    
    public Resultado crearEvento(Evento evento){
        return null;
    }
    
    public boolean hayCupo(Evento evento){
        return true;
    }
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo){
        return new Resultado<>("", "");
    }
}
