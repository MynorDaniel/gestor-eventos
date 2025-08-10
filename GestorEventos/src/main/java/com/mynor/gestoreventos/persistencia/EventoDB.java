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
public class EventoDB {
    
    public Resultado crearEvento(Evento evento){
        return new Resultado<>("", "");
    }
    
    public boolean hayCupo(Evento evento){
        return true;
    }
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo){
        return new Resultado<>("", "");
    }
}
