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
 * Clase encargada de realizar operaciones en la tabla Pago
 * @author mynordma
 */
public class PagoDB {
    
    public Resultado crearPago(Pago pago){
        String sql = "INSERT INTO pago (codigo_evento, correo_participante, monto, metodo_pago) VALUES (?, ?, ?, ?)";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, pago.getCodigoEvento());
            ps.setString(2, pago.getCorreoParticipante());
            ps.setDouble(3, pago.getMonto());
            ps.setString(4, pago.getMetodoPago().name());
            
            int columnasAfectadas = ps.executeUpdate();
            
            if(columnasAfectadas>0){
                return new Resultado<>("Pago registrado exitosamente", pago);
            }else{
                return new Resultado<>("Error, pago ya existe", "");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return new Resultado<>("Error, pago ya existe", "");
        }
    }
    
    public boolean existePago(String codigoEvento, String correoParticipante){
        String sql = "SELECT * FROM pago WHERE codigo_evento = ? AND correo_participante = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ps.setString(2, correoParticipante);
            
            ResultSet rs = ps.executeQuery();
            return rs.next();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}