/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import java.sql.Connection;

/**
 *
 * @author mynordma
 */
public class Conexion {
    
    private String host;
    private String puerto;
    private String esquema;
    private String usuario;
    private String clave;
    
    public Conexion(){
        obtenerCredenciales();
    }
    
    public Connection obtenerConexion(){
        return (Connection) new UnsupportedOperationException();
    }
    
    private void obtenerCredenciales(){
        // Archivo /credenciales.txt
    }
}
