/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.modelos;

import com.mynor.gestoreventos.modelos.enums.TipoInstruccion;

/**
 *
 * @author mynordma
 */
public class Instruccion {
    
    private TipoInstruccion tipo;
    private String[] parametros;

    public Instruccion(TipoInstruccion tipo, String[] parametros) {
        this.tipo = tipo;
        this.parametros = parametros;
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
}
