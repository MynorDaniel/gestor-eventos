/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoEvento;
import com.mynor.gestoreventos.persistencia.EventoDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mynordma
 */
public class EventoServicio {
    
    private final EventoDB eventoDB;
    
    public EventoServicio(){
        eventoDB = new EventoDB();
    }
    
    public Resultado crearEvento(String codigo, String ubicacion, String cupoMaximo, String titulo, String tipo, String fecha){
        boolean fechaValida = fecha.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
        boolean ubicacionValida = ubicacion.length() <= 150;
        boolean tituloValido = titulo.length() <= 200;
        
        if(!fechaValida){
            return new Resultado<>("Fecha del evento invalida", "");
        }else if(!ubicacionValida){
            return new Resultado<>("Nombre de la ubicacion del evento demasiado grande", "");
        }else if(!tituloValido){
            return new Resultado<>("Titulo demasiado grande", "");
        }
        
        try {
            int cupo = Integer.parseInt(cupoMaximo);
            
            if(cupo < 0){
                return new Resultado<>("Cupo invalido", "");
            }
            
            TipoEvento tipoEvento = TipoEvento.valueOf(tipo.toUpperCase());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaEvento = LocalDate.parse(fecha, formato);
            
            Evento evento = new Evento(codigo, ubicacion, cupo, titulo, tipoEvento, fechaEvento);
            
            return eventoDB.crearEvento(evento);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return new Resultado<>("Datos del evento invalidos", "");
        }
    }
    
    public boolean hayCupo(String codigo){
        return eventoDB.hayCupo(codigo);
    }
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo){
        return new Resultado<>("", "");
    }
}

