/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.Evento;
import com.mynor.gestoreventos.modelos.Participante;
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
import java.util.LinkedList;

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

    public Resultado generarReporteEventos(String url, LinkedList<Evento> eventos) {
        StringBuilder html = new StringBuilder();

        html.append("""
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <title>Reporte de Eventos</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 20px; }
                    h1 { text-align: center; margin-bottom: 40px; }
                    table { border-collapse: collapse; width: 100%; margin-bottom: 30px; }
                    th, td { border: 1px solid #000; padding: 6px; text-align: left; }
                    th { background-color: #f2f2f2; }
                    .evento-header { background-color: #d9edf7; font-weight: bold; text-align: center; }
                    .resumen { font-weight: bold; background-color: #f9f9f9; }
                </style>
            </head>
            <body>
            <h1>Reporte de Eventos</h1>
            """);

        for (Evento e : eventos) {
            html.append("<table>\n");
            // Datos del evento
            html.append("<tr class='evento-header'><td colspan='2'>EVENTO: ").append(e.getTitulo())
                .append(" (").append(e.getCodigo()).append(")</td></tr>\n");
            html.append("<tr><td>Código</td><td>").append(e.getCodigo()).append("</td></tr>\n");
            html.append("<tr><td>Fecha</td><td>").append(e.getFecha()).append("</td></tr>\n");
            html.append("<tr><td>Título</td><td>").append(e.getTitulo()).append("</td></tr>\n");
            html.append("<tr><td>Tipo</td><td>").append(e.getTipo()).append("</td></tr>\n");
            html.append("<tr><td>Ubicación</td><td>").append(e.getUbicacion()).append("</td></tr>\n");
            html.append("<tr><td>Cupo máximo</td><td>").append(e.getCupoMaximo()).append("</td></tr>\n");
            html.append("<tr><td>Monto total</td><td>Q.").append(String.format("%.2f", e.getMontoTotal())).append("</td></tr>\n");
            html.append("<tr><td>Participantes validados</td><td>").append(e.getParticipantesValidos()).append("</td></tr>\n");
            html.append("<tr><td>Participantes no validados</td><td>").append(e.getParticipantesInvalidos()).append("</td></tr>\n");
            html.append("</table>\n");

            // Tabla de participantes
            html.append("<table>\n");
            html.append("<tr><th>Correo</th><th>Nombre</th><th>Tipo</th><th>Método de Pago</th><th>Monto Pagado</th></tr>\n");

            if (e.getParticipantes() != null && !e.getParticipantes().isEmpty()) {
                for (Participante p : e.getParticipantes()) {
                    html.append("<tr>");
                    html.append("<td>").append(p.getCorreo()).append("</td>");
                    html.append("<td>").append(p.getNombre()).append("</td>");
                    html.append("<td>").append(p.getTipo()).append("</td>");

                    if (p.getPagoAEvento() != null) {
                        html.append("<td>").append(p.getPagoAEvento().getMetodoPago()).append("</td>");
                        html.append("<td>").append(String.format("%.2f", p.getPagoAEvento().getMonto())).append("</td>");
                    } else {
                        html.append("<td>-</td><td>-</td>");
                    }

                    html.append("</tr>\n");
                }
            } else {
                html.append("<tr><td colspan='5'>No hay participantes</td></tr>\n");
            }

            html.append("</table>\n");
        }

        html.append("</body></html>");

        try {
            generarHTML(html.toString(), url, "ReporteEventos.html");
            return new Resultado<>("Reporte creado en la ruta " + url, "");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return new Resultado<>("Error al crear el reporte", "");
        }
    }


}
