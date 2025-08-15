/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public boolean hayCupo(Actividad actividad){
        return true;
    }
    
    public boolean participanteAceptado(Asistencia asistencia){
        return true;
    }
    
    public Resultado obtenerActividades(String evento, String tipoActividad, String correoEncargado){
        return new Resultado<>("", "");
    }
}
