/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.persistencia;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.modelos.enums.MetodoPago;
import com.mynor.gestoreventos.modelos.enums.TipoEvento;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
    
    public LinkedList<Evento> obtenerEventos(String tipoEvento, String fechaInicial, String fechaFinal,
                                                    String cupoMinimo, String cupoMaximo) {
        LinkedList<Evento> eventos = new LinkedList<>();
        Map<String, Evento> mapaEventos = new HashMap<>();

        StringBuilder sql = new StringBuilder("""
                     SELECT e.codigo, e.fecha, e.titulo, e.tipo AS tipo_evento, e.ubicacion, e.cupo_maximo,
                            p.correo, p.nombre, p.tipo AS tipo_participante, p.institucion,
                            pg.metodo_pago, pg.monto
                     FROM evento e
                     LEFT JOIN inscripcion i ON e.codigo = i.codigo_evento
                     LEFT JOIN participante p ON i.correo_participante = p.correo
                     LEFT JOIN pago pg 
                            ON i.codigo_evento = pg.codigo_evento 
                           AND i.correo_participante = pg.correo_participante
                    WHERE 1=1 
                     """);
        
        if((fechaInicial != null && !fechaInicial.isEmpty()) && (fechaFinal != null && !fechaFinal.isEmpty())){
            sql.append("AND e.fecha BETWEEN ? AND ? ");
        }
        
        if((cupoMinimo != null && !cupoMinimo.isEmpty()) && (cupoMaximo != null && !cupoMaximo.isEmpty())){
            sql.append("AND e.cupo_maximo BETWEEN ? AND ? ");
        }
        
        if(tipoEvento != null && !tipoEvento.isEmpty()){
            sql.append("AND e.tipo = ? ");
        }
        
        sql.append("ORDER BY e.codigo, p.correo");
        

        try (Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql.toString());) {
            
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate fechaInicialNueva = LocalDate.parse(fechaInicial, formatoEntrada);
            LocalDate fechaFinalNueva = LocalDate.parse(fechaFinal, formatoEntrada);
            
            int contador = 1;
            
            if((fechaInicial != null && !fechaInicial.isEmpty()) && (fechaFinal != null && !fechaFinal.isEmpty())){
                ps.setString(contador, fechaInicialNueva.toString());
                contador++;
                ps.setString(contador, fechaFinalNueva.toString());
                contador++;
            }

            if((cupoMinimo != null && !cupoMinimo.isEmpty()) && (cupoMaximo != null && !cupoMaximo.isEmpty())){
                ps.setString(contador, cupoMinimo);
                contador++;
                ps.setString(contador, cupoMaximo);
                contador++;
            }
            
            if(tipoEvento != null && !tipoEvento.isEmpty()){
                ps.setString(contador, tipoEvento.toUpperCase());
            }
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                String codigoEvento = rs.getString("codigo");

                Evento evento = mapaEventos.get(codigoEvento);
                if (evento == null) {
                    evento = new Evento();
                    evento.setCodigo(codigoEvento);
                    evento.setTitulo(rs.getString("titulo"));
                    evento.setUbicacion(rs.getString("ubicacion"));
                    evento.setCupoMaximo(rs.getInt("cupo_maximo"));
                    evento.setFecha(rs.getDate("fecha").toLocalDate());
                    evento.setTipo(TipoEvento.valueOf(rs.getString("tipo_evento")));
                    evento.setParticipantes(new LinkedList<>());
                    
                    double montoTotal = obtenerMontoTotal(codigoEvento);
                    int participantesValidos = obtenerParticipantesPorValidacion(codigoEvento, "1");
                    int participantesInvalidos = obtenerParticipantesPorValidacion(codigoEvento, "0");
                    
                    if(montoTotal < 0 || participantesValidos < 0 || participantesInvalidos < 0){
                        return null;
                    }
                    
                    evento.setMontoTotal(montoTotal);
                    evento.setParticipantesValidos(participantesValidos);
                    evento.setParticipantesInvalidos(participantesInvalidos);

                    mapaEventos.put(codigoEvento, evento);
                    eventos.add(evento);
                }

                String correo = rs.getString("correo");
                if (correo != null) {
                    Participante participante = new Participante();
                    participante.setCorreo(correo);
                    participante.setNombre(rs.getString("nombre"));
                    participante.setTipo(TipoParticipante.valueOf(rs.getString("tipo_participante")));
                    participante.setInstitucion(rs.getString("institucion"));

                    String metodoPago = rs.getString("metodo_pago");
                    if (metodoPago != null) {
                        Pago pago = new Pago();
                        pago.setCodigoEvento(codigoEvento);
                        pago.setCorreoParticipante(correo);
                        pago.setMonto(rs.getDouble("monto"));
                        pago.setMetodoPago(MetodoPago.valueOf(metodoPago));
                        participante.setPagoAEvento(pago);
                    }

                    evento.getParticipantes().add(participante);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return eventos;
    }

    private double obtenerMontoTotal(String codigoEvento) throws SQLException{
        String sql = "SELECT monto FROM pago WHERE codigo_evento = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            
            ResultSet rs = ps.executeQuery();
            double montoTotal = 0;
            while(rs.next()){
                montoTotal = montoTotal + rs.getDouble("monto");
            }
            
            return montoTotal;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return -1;
    }
    
    private int obtenerParticipantesPorValidacion(String codigoEvento, String confirmada){
        String sql = "SELECT COUNT(*) AS participantes FROM inscripcion WHERE confirmada = ? AND codigo_evento = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, confirmada);
            ps.setString(2, codigoEvento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("participantes");
            }else{
                return -1;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
    public Evento obtenerEvento(String codigoEvento) {
        String sql = "SELECT * FROM evento WHERE codigo = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String ubicacion = rs.getString("ubicacion");
                int cupoMaximo = rs.getInt("cupo_maximo");
                String titulo = rs.getString("titulo");
                TipoEvento tipo = TipoEvento.valueOf(rs.getString("tipo"));
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                double precio = rs.getDouble("precio");
                return new Evento(codigoEvento, ubicacion, cupoMaximo, titulo, tipo, fecha, precio);
            }else{
                return null;
            }
            
        } catch (SQLException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public double obtenerPrecio(String codigoEvento) {
        String sql = "SELECT precio FROM evento WHERE codigo = ?";
        
        try(Connection conn = Conexion.obtenerConexion(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, codigoEvento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getDouble("precio");
            }else{
                return -1;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
