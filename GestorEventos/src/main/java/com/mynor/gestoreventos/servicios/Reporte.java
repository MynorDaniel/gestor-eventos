/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.Resultado;
import com.mynor.gestoreventos.modelos.enums.TipoReporte;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
public class Reporte {
    
    public Resultado generarReporte(String url, ResultSet rs, TipoReporte tipo){
        
        try {
            StringBuilder html = new StringBuilder();
            html.append("<table border='1'>\n");
            
            // Cabecera
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();
            html.append("<tr>");
            for (int i = 1; i <= columnas; i++) {
                html.append("<th>").append(meta.getColumnLabel(i)).append("</th>");
            }
            html.append("</tr>\n");
            
            // Filas
            while (rs.next()) {
                html.append("<tr>");
                for (int i = 1; i <= columnas; i++) {
                    html.append("<td>").append(rs.getString(i)).append("</td>");
                }
                html.append("</tr>\n");
            }
            
            html.append("</table>");
            
            try {
                generarHTML(html.toString(), url, "Reporte_" + tipo.name() + ".html");
                return new Resultado<>("Reporte creado en la ruta " + url, "");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return new Resultado<>("Error al crear el reporte", "");
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return new Resultado<>("Error al crear el reporte html", ""); 
        }
        
        
    }
    
    public void generarHTML(String html, String ruta, String nombreArchivo) throws IOException {
        File archivo = Paths.get(ruta, nombreArchivo).toFile();
        File carpeta = archivo.getParentFile();

        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }
        
        int contador = 1;
        String nombreBase = archivo.getName();
        while (archivo.exists()) {
            String nuevoNombre = nombreBase.replace(".html", "_" + contador + ".html");
            archivo = new File(carpeta, nuevoNombre);
            contador++;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(html);
        }
    }
}
