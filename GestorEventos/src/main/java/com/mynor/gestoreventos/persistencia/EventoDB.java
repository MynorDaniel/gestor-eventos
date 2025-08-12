/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mynordma
 */
public class EventoDB {
    
    public Resultado crearEvento(Evento evento){
        String sql = "INSERT INTO evento (codigo, ubicacion, cupo_maximo, titulo, tipo, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, evento.getCodigo());
            ps.setString(2, evento.getUbicacion());
            ps.setInt(3, evento.getCupoMaximo());
            ps.setString(4, evento.getTitulo());
            ps.setString(5, evento.getTipo().name());
            ps.setDate(6, Date.valueOf(evento.getFecha()));
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Evento " + evento.getCodigo()+ " registrado exitosamente", evento);
            }else{
                return new Resultado<>("Error al registrar el evento", "");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Error al registrar el evento", "");
        }
    }
    
    public boolean hayCupo(String codigoEvento){
        return true;
    }
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo){
        return new Resultado<>("", "");
    }
}
