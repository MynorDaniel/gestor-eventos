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
import java.sql.Time;

/**
 *
 * @author mynordma
 */
public class ActividadDB {
    
    public Resultado crearActividad(Actividad actividad){
        String sql = "INSERT INTO actividad (codigo, correo_impartidor, codigo_evento, hora_inicio, hora_fin, cupo_maximo, tipo, titulo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, actividad.getCodigo());
            ps.setString(2, actividad.getCorreoImpartidor());
            ps.setString(3, actividad.getCodigoEvento());
            ps.setTime(4, Time.valueOf(actividad.getHoraInicio()));
            ps.setTime(5, Time.valueOf(actividad.getHoraFin()));
            ps.setInt(6, actividad.getCupoMaximo());
            ps.setString(7, actividad.getTipo().name());
            ps.setString(8, actividad.getTitulo());
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Actividad " + actividad.getCodigo()+ " registrada exitosamente", actividad);
            }else{
                return new Resultado<>("Error al registrar la actividad", "");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Error al registrar la actividad", "");
        }
    }
    
    public boolean hayCupo(String codigoActividad){
        String sqlCuposApartados = "SELECT COUNT(*) AS cupos_apartados FROM asistencia WHERE codigo_actividad = ?";
        String sqlCupoMaximo = "SELECT cupo_maximo FROM actividad WHERE codigo = ?";
        
        int cuposApartados = 0;
        int cupoMaximo = 0;
        
        try(Connection conn = Conexion.obtenerConexion(); 
                PreparedStatement ps1 = conn.prepareStatement(sqlCuposApartados); 
                PreparedStatement ps2 = conn.prepareStatement(sqlCupoMaximo)){
            
            ps1.setString(1, codigoActividad);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                cuposApartados = rs1.getInt("cupos_apartados");
            }else{
                return false;
            }
            
            ps2.setString(1, codigoActividad);
            ResultSet rs2 = ps2.executeQuery();
            if(rs2.next()){
                cupoMaximo = rs2.getInt("cupo_maximo");
            }else{
                return false;
            }
            
            return cuposApartados < cupoMaximo;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean participanteAceptable(String codigoActividad, String correoParticipante) {
        String sql = "SELECT * FROM inscripcion WHERE correo_participante = ? AND confirmada = TRUE AND codigo_evento = (SELECT codigo_evento FROM actividad WHERE codigo = ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, correoParticipante);
            ps.setString(2, codigoActividad);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Resultado obtenerActividades(String evento, String tipoActividad, String correoEncargado){
        return new Resultado<>("", "");
    }
}
