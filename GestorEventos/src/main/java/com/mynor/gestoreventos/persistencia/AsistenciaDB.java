/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
public class AsistenciaDB {
    
    public Resultado crearAsistencia(Asistencia asistencia){
        String sql = "INSERT INTO asistencia (codigo_actividad, correo_participante) VALUES (?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, asistencia.getCodigoActividad());
            ps.setString(2, asistencia.getCorreoParticipante());
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Asistencia de " + asistencia.getCorreoParticipante() + " a la actividad " + asistencia.getCodigoActividad()+ " registrada exitosamente", asistencia);
            }else{
                return new Resultado<>("Error al registrar la asistencia", "");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Asistencia duplicada, ignorando...", "");
        }
    }
    
    public boolean existeAsistencia(String codigoEvento, String correoParticipante){
        String sql = """
                     SELECT 1
                     FROM asistencia AS a
                     JOIN actividad AS ac 
                         ON a.codigo_actividad = ac.codigo
                     WHERE ac.codigo_evento = ?
                       AND a.correo_participante = ?
                     LIMIT 1;
                     """;
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ps.setString(2, correoParticipante);
            ResultSet rs = ps.executeQuery();
            return rs.next();
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
