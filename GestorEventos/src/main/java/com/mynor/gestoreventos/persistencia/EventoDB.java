/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        String sqlCuposApartados = """
                                   SELECT COUNT(*) AS cupos_apartados 
                                   FROM inscripcion i 
                                   INNER JOIN pago p 
                                    ON i.codigo_evento = p.codigo_evento 
                                    AND i.correo_participante = p.correo_participante 
                                   WHERE i.codigo_evento = ?
                                   """;
        
        String sqlCupoMaximo = "SELECT cupo_maximo FROM evento WHERE codigo = ?";
        
        int cuposApartados = 0;
        int cupoMaximo = 0;
        
        try(Connection conn = Conexion.obtenerConexion(); 
                PreparedStatement ps1 = conn.prepareStatement(sqlCuposApartados); 
                PreparedStatement ps2 = conn.prepareStatement(sqlCupoMaximo)){
            
            ps1.setString(1, codigoEvento);
            ResultSet rs1 = ps1.executeQuery();
            if(rs1.next()){
                cuposApartados = rs1.getInt("cupos_apartados");
            }else{
                return false;
            }
            
            ps2.setString(1, codigoEvento);
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
    
    public Resultado obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
            String cupoMinimo, String cupoMaximo){
        return new Resultado<>("", "");
    }
}
