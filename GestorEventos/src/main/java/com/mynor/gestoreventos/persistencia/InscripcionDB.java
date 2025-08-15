/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoInscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
public class InscripcionDB {
    
    public Resultado crearInscripcion(Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion (codigo_evento, correo_participante, tipo) VALUES (?, ?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, inscripcion.getCodigoEvento());
            ps.setString(2, inscripcion.getCorreoParticipante());
            ps.setString(3, inscripcion.getTipo().name());
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Inscripcion de " + inscripcion.getCorreoParticipante() + " al evento " + inscripcion.getCodigoEvento()+ " registrado exitosamente", inscripcion);
            }else{
                return new Resultado<>("Error al registrar la inscripcion", "");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Error al registrar la inscripcion", "");
        }
    }
    
    public Resultado confirmarInscripcion(String codigoEvento, String correoParticipante){
        String sql = "UPDATE inscripcion SET confirmada = TRUE WHERE codigo_evento = ? AND correo_participante = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ps.setString(2, correoParticipante);
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Inscripcion confirmada", "");
            }else{
                return new Resultado<>("Error al confirmar la inscripcion de " + correoParticipante + " a " + codigoEvento, "");
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Error al confirmar la inscripcion", "");
        }
    }

    public boolean existeInscripcion(String codigoEvento, String correoParticipante) {
        return true;
    }
    
    public TipoInscripcion obtenerTipo(String correoImpartidor, String codigoEvento){
        String sql = "SELECT tipo FROM inscripcion WHERE codigo_evento = ? AND correo_participante = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ps.setString(2, correoImpartidor);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TipoInscripcion tipo = TipoInscripcion.valueOf(rs.getString("tipo"));
                return tipo;
            }else{
                return null;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
