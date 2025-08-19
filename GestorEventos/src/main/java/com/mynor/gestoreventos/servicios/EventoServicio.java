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
import java.time.format.DateTimeParseException;
import java.util.LinkedList;

/**
 * Clase que recibe parametros sin procesar desde el usuario, los valida y arma los modelos para
 * realizar peticiones a EventoDB
 * @author mynordma
 */
public class EventoServicio {
    
    private final EventoDB eventoDB;
    
    public EventoServicio(){
        eventoDB = new EventoDB();
    }
    
    public Resultado crearEvento(String codigo, String ubicacion, String cupoMaximo, String titulo, String tipo, String fecha, String precio){
        boolean fechaValida = fecha.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$");
        boolean ubicacionValida = ubicacion.length() <= 150;
        boolean tituloValido = titulo.length() <= 200;
        
        if(!fechaValida){
            return new Resultado<>("Fecha del evento invalida", "");
        }else if(!ubicacionValida){
            return new Resultado<>("Nombre de la ubicacion del evento demasiado grande", "");
        }else if(!tituloValido){
            return new Resultado<>("Titulo demasiado grande", "");
        }else if(codigo.trim().isEmpty()){
            return new Resultado<>("Codigo invalido", "");
        }
        
        try {
            int cupo = Integer.parseInt(cupoMaximo);
            
            if(cupo < 0){
                return new Resultado<>("Cupo invalido", "");
            }
            
            TipoEvento tipoEvento = TipoEvento.valueOf(tipo.toUpperCase());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaEvento = LocalDate.parse(fecha, formato);
            Evento evento = new Evento(codigo, ubicacion, cupo, titulo, tipoEvento, fechaEvento, Double.parseDouble(precio));
            
            return eventoDB.crearEvento(evento);
            
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println(e.getMessage());
            return new Resultado<>("Fecha o tipo invalido", "");
        }
    }
    
    public boolean hayCupo(String codigo){
        return eventoDB.hayCupo(codigo);
    }
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo, String url){
        
        try {
            
            if(tipoEvento != null && !tipoEvento.trim().isEmpty()){
                TipoEvento.valueOf(tipoEvento.toUpperCase());
            }
            
            if(fechaInicial != null && !fechaInicial.trim().isEmpty()){
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(fechaInicial, formato);
            }else if(fechaFinal != null && !fechaFinal.trim().isEmpty()){
                return new Resultado<>("Se debe ingresar fecha inicial y final", "");
            }
            
            if(fechaFinal != null && !fechaFinal.trim().isEmpty()){
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(fechaFinal, formato);
            }else if(fechaInicial != null && !fechaInicial.trim().isEmpty()){
                return new Resultado<>("Se debe ingresar fecha inicial y final", "");
            }
            
            if(cupoMinimo != null && !cupoMinimo.trim().isEmpty()){
                Integer.valueOf(cupoMinimo);
            }else if(cupoMaximo != null && !cupoMaximo.trim().isEmpty()){
                return new Resultado<>("Se debe ingresar cupo minimo y maximo", "");
            }
            
            if(cupoMaximo != null && !cupoMaximo.trim().isEmpty()){
                Integer.valueOf(cupoMaximo);
            }else if(cupoMinimo != null && !cupoMinimo.trim().isEmpty()){
                return new Resultado<>("Se debe ingresar cupo minimo y maximo", "");
            }
            
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println(e.getMessage());
            return new Resultado<>("Error, verifica que el tipo, fecha y cupo sean validos", "");
        }
        
        LinkedList<Evento> eventos = eventoDB.obtenerEventos(tipoEvento, fechaInicial, fechaFinal, cupoMinimo, cupoMaximo);
        
        if(eventos == null){
            return new Resultado<>("Error al obtener los eventos", "");
        }else if(eventos.isEmpty()){
            return new Resultado<>("Sin coincidencias", "");
        }
        
        Reporte reporte = new Reporte();
        
        return reporte.generarReporteEventos(url, eventos, tipoEvento, fechaInicial, fechaFinal,
            cupoMinimo, cupoMaximo);
    }

    public Evento obtenerEvento(String codigoEvento) {
        return eventoDB.obtenerEvento(codigoEvento);
    }
    
    public double obtenerPrecio(String codigoEvento){
        return eventoDB.obtenerPrecio(codigoEvento);
    }
}

