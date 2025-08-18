/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoEvento;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author mynordma
 */
public class Evento {
    
    private String codigo;
    private String ubicacion;
    private int cupoMaximo;
    private String titulo;
    private TipoEvento tipo;
    private LocalDate fecha;
    private double precio;
    private LinkedList<Participante> participantes;
    private double montoTotal;
    private int participantesValidos;
    private int participantesInvalidos;

    public Evento(String codigo, String ubicacion, int cupoMaximo, String titulo, TipoEvento tipo, LocalDate fecha, double precio) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.cupoMaximo = cupoMaximo;
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
    }

    public Evento() {
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public int getParticipantesValidos() {
        return participantesValidos;
    }

    public void setParticipantesValidos(int participantesValidos) {
        this.participantesValidos = participantesValidos;
    }

    public int getParticipantesInvalidos() {
        return participantesInvalidos;
    }

    public void setParticipantesInvalidos(int participantesInvalidos) {
        this.participantesInvalidos = participantesInvalidos;
    }

    public LinkedList<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(LinkedList<Participante> participantes) {
        this.participantes = participantes;
    }
    
    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
