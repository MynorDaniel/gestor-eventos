/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import com.mynor.gestoreventos.modelos.enums.TipoReporte;
import com.mynor.gestoreventos.servicios.Reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author mynordma
 */
public class ParticipanteDB {
    
    public Resultado crearParticipante(Participante participante){
        String sql = "INSERT INTO participante (correo, nombre, tipo, institucion) VALUES(?, ?, ?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, participante.getCorreo());
            ps.setString(2, participante.getNombre());
            ps.setString(3, participante.getTipo().name());
            ps.setString(4, participante.getInstitucion());
            ps.executeUpdate();
            return new Resultado<>("Participante " + participante.getCorreo() + " registrado exitosamente", participante);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new Resultado<>("Error al registrar al participante", "");
        }
    }
    
    public TipoParticipante obtenerTipo(String correoParticipante){
        String sql = "SELECT tipo FROM participante WHERE correo = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, correoParticipante);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                TipoParticipante tipo = TipoParticipante.valueOf(rs.getString("tipo"));
                return tipo;
            }else{
                return null;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Resultado obtenerParticipantes(String evento, String tipoParticipante, String institucion, String url){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT i.codigo_evento, p.tipo, p.nombre, p.institucion, i.confirmada AS `validado_si(1)_no(0)` FROM inscripcion AS i JOIN participante AS p ON i.correo_participante = p.correo WHERE i.codigo_evento = ? ");
        
        if(tipoParticipante != null && !tipoParticipante.isEmpty()){
            sql.append("AND p.tipo = ? ");
        }
        
        if(institucion != null && !institucion.isEmpty()){
            sql.append("AND p.institucion = ? ");
        }
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql.toString())){
            ps.setString(1, evento);
            
            int i = 2;
            
            if(tipoParticipante != null && !tipoParticipante.isEmpty()){
                ps.setString(i, tipoParticipante);
                i++;
            }
            
            if(institucion != null && !institucion.isEmpty()){
                ps.setString(i, institucion);
            }
            
            ResultSet rs = ps.executeQuery();
            
            
            
            if(!rs.isBeforeFirst()){
                return new Resultado<>("No hay participantes en el evento", "");
            }
            
            Reporte reporte = new Reporte();
            return reporte.generarReporte(url, rs, TipoReporte.PARTICIPANTES);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Participante obtenerParticipante(String correoParticipante) {
        String sql = "SELECT * FROM participante WHERE correo = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, correoParticipante);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                TipoParticipante tipo = TipoParticipante.valueOf(rs.getString("tipo"));
                String institucion = rs.getString("institucion");
                return new Participante(correo, nombre, tipo, institucion);
            }else{
                return null;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}