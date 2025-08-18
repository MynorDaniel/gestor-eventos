/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoInstruccion;
import com.mynor.gestoreventos.servicios.*;

/**
 *
 * @author mynordma
 */
public class Instruccion {
    
    private TipoInstruccion tipo;
    private String[] parametros;
    
    public Resultado ejecutar(String url){
        switch (tipo) {
            case REGISTRO_EVENTO -> {
                EventoServicio servicio = new EventoServicio();
                return servicio.crearEvento(parametros[0], parametros[4], parametros[5], parametros[3], parametros[2], parametros[1], parametros[6]);
            }
            case REGISTRO_PARTICIPANTE -> {
                ParticipanteServicio servicio = new ParticipanteServicio();
                return servicio.crearParticipante(parametros[3], parametros[0], parametros[1], parametros[2]);
            }
            case INSCRIPCION -> {
                InscripcionServicio servicio = new InscripcionServicio();
                return servicio.crearInscripcion(parametros[1], parametros[0], parametros[2]);
            }
            case PAGO -> {
                PagoServicio servicio = new PagoServicio();
                return servicio.crearPago(parametros[1], parametros[0], parametros[3], parametros[2]);
            }
            case VALIDACION_INSCRIPCION -> {
                InscripcionServicio servicio = new InscripcionServicio();
                return servicio.confirmarInscripcion(parametros[1], parametros[0]);
            }
            case REGISTRO_ACTIVIDAD -> {
                ActividadServicio servicio = new ActividadServicio();
                return servicio.crearActividad(parametros[0], parametros[4], parametros[1], parametros[5], parametros[6], parametros[7], parametros[2], parametros[3]);
            }
            case REGISTRO_ASISTENCIA -> {
                AsistenciaServicio servicio = new AsistenciaServicio();
                return servicio.crearAsistencia(parametros[1], parametros[0]);
            }
            case CERTIFICADO -> {
                ParticipanteServicio servicio = new ParticipanteServicio();
                return servicio.generarCertificado(parametros[1], parametros[0], url);
            }
            case REPORTE_PARTICIPANTES -> {
                ParticipanteServicio servicio = new ParticipanteServicio();
                return servicio.obtenerParticipantes(parametros[0], parametros[1], parametros[2], url);
            }
            case REPORTE_ACTIVIDADES -> {
                ActividadServicio servicio = new ActividadServicio();
                return servicio.obtenerActividades(parametros[0], parametros[1], parametros[2], url);
            }
            case REPORTE_EVENTOS -> {
                EventoServicio servicio = new EventoServicio();
                return servicio.obtenerEventos(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], url);
            }
            default -> {
                return new Resultado<>("Error al ejecutar la instrucción", "");
            }
        }


    }

    public TipoInstruccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoInstruccion tipo) {
        this.tipo = tipo;
    }

    public String[] getParametros() {
        return parametros;
    }

    public void setParametros(String[] parametros) {
        this.parametros = parametros;
    }
    
    @Override
    public String toString(){
        return tipo.name() + " " + String.join(", ", parametros);
    }
}
