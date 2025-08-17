/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoActividad;
import java.time.LocalTime;

/**
 *
 * @author mynordma
 */
public class Actividad {
    
    private String codigo;
    private String correoImpartidor;
    private String codigoEvento;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int cupoMaximo;
    private TipoActividad tipo;
    private String titulo;
    private int cantidadParticipantes;
    private String encargado;

    public Actividad(String codigo, String correoImpartidor, String codigoEvento, LocalTime horaInicio, LocalTime horaFin, int cupoMaximo, TipoActividad tipo, String titulo) {
        this.codigo = codigo;
        this.correoImpartidor = correoImpartidor;
        this.codigoEvento = codigoEvento;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cupoMaximo = cupoMaximo;
        this.tipo = tipo;
        this.titulo = titulo;
    }

    public Actividad() {
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCorreoImpartidor() {
        return correoImpartidor;
    }

    public void setCorreoImpartidor(String correoImpartidor) {
        this.correoImpartidor = correoImpartidor;
    }

    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
