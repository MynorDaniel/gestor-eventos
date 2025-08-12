/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoInscripcion;
import com.mynor.gestoreventos.persistencia.EventoDB;
import com.mynor.gestoreventos.persistencia.InscripcionDB;
import com.mynor.gestoreventos.persistencia.PagoDB;

/**
 *
 * @author mynordma
 */
public class InscripcionServicio {
    
    private final InscripcionDB inscripcionDB;
    
    public InscripcionServicio(){
        inscripcionDB = new InscripcionDB();
    }
    
    public Resultado crearInscripcion(String codigoEvento, String correoParticipante, String tipo){
        boolean correoValido = correoParticipante.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        
        EventoDB eventoDB = new EventoDB();
        boolean hayCupoEnEvento = eventoDB.hayCupo(codigoEvento);
        
        if(!(correoValido && hayCupoEnEvento)){
            return new Resultado<>("Correo del participante invalido", "");
        }
        
        try {
            TipoInscripcion tipoInscripcion = TipoInscripcion.valueOf(tipo.toUpperCase());
            Inscripcion inscripcion = new Inscripcion(codigoEvento, correoParticipante, tipoInscripcion);
            return inscripcionDB.crearInscripcion(inscripcion);
        } catch (IllegalArgumentException e) {
            return new Resultado<>("Tipo de inscripcion invalido", "");
        }
    }
    
    public Resultado confirmarInscripcion(String codigoEvento, String correoParticipante){
        boolean correoValido = correoParticipante.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        
        if(!correoValido){
            return new Resultado<>("Correo del participante invalido", "");
        }
        
        PagoDB pagoDB = new PagoDB();
        boolean existePago = pagoDB.existePago(codigoEvento, correoParticipante);
        
        if(!existePago){
            return new Resultado<>("No se ha pagado la inscripcion de " + correoParticipante + " a " + codigoEvento, "");
        }
        
        return inscripcionDB.confirmarInscripcion(codigoEvento, correoParticipante);
    }
}
