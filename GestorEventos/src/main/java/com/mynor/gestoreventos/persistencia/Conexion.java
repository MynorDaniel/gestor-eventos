/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mynordma
 */
public class Conexion {
    
    private static String url;
    private static String usuario;
    private static String clave;
    
    static {
        obtenerCredenciales();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(url, usuario, clave);
    }
    
    private static void obtenerCredenciales(){
        Properties properties = new Properties();
        String urlArchivo = "config.properties";
        
        try(FileReader fr = new FileReader(urlArchivo)){
            properties.load(fr);
            url = properties.getProperty("db.url");
            usuario = properties.getProperty("db.usuario");
            clave = properties.getProperty("db.clave");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
