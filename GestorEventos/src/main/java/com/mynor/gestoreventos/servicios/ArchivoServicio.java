/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.Instruccion;
import com.mynor.gestoreventos.modelos.enums.TipoInstruccion;
import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mynordma
 */
public class ArchivoServicio {
    
    private final String URL;
    
    private final String REGEX_REGISTRO_EVENTO = 
        "REGISTRO_EVENTO\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*([^,]*)\\s*,\\s*([^)]*)\\s*\\);";

    private final String REGEX_REGISTRO_PARTICIPANTE = 
        "REGISTRO_PARTICIPANTE\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_INSCRIPCION = 
        "INSCRIPCION\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_PAGO = 
        "PAGO\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*([^)]*)\\s*\\);";

    private final String REGEX_VALIDAR_INSCRIPCION = 
        "VALIDAR_INSCRIPCION\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_REGISTRO_ACTIVIDAD = 
        "REGISTRO_ACTIVIDAD\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*([^)]*)\\s*\\);";

    private final String REGEX_ASISTENCIA = 
        "ASISTENCIA\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_CERTIFICADO = 
        "CERTIFICADO\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_REPORTE_PARTICIPANTES = 
        "REPORTE_PARTICIPANTES\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_REPORTE_ACTIVIDADES = 
        "REPORTE_ACTIVIDADES\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*\\);";

    private final String REGEX_REPORTE_EVENTOS = 
        "REPORTE_EVENTOS\\(\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*\"([^\"]*)\"\\s*,\\s*([^,]*)\\s*,\\s*([^)]*)\\s*\\);";

    public ArchivoServicio(String URL) {
        this.URL = URL;
    }
    
    public LinkedList<Instruccion> obtenerInstrucciones(){
        LinkedList<Instruccion> instrucciones = new LinkedList<>();
        
        File file = new File(URL);
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String linea = "";
            while((linea = br.readLine()) != null){
                //System.out.println(linea);
                instrucciones.add(procesarLinea(linea.trim()));
            }
            return instrucciones;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private Instruccion procesarLinea(String linea){
        if(linea.isEmpty()){
            return null;
        }
        
        String inicioInstruccion = "zzz";
        int parenIndex = linea.indexOf("(");
        if (parenIndex != -1) {
            inicioInstruccion = linea.substring(0, parenIndex).trim().replace("\r", "");
        }

        switch (inicioInstruccion) {
            case "REGISTRO_EVENTO" -> {
                return procesarLineaPorTipo(linea, REGEX_REGISTRO_EVENTO, TipoInstruccion.REGISTRO_EVENTO, 7);
            }
            case "REGISTRO_PARTICIPANTE" -> {
                return procesarLineaPorTipo(linea, REGEX_REGISTRO_PARTICIPANTE, TipoInstruccion.REGISTRO_PARTICIPANTE, 4);
            }
            case "INSCRIPCION" -> {
                return procesarLineaPorTipo(linea, REGEX_INSCRIPCION, TipoInstruccion.INSCRIPCION, 3);
            }
            case "PAGO" -> {
                return procesarLineaPorTipo(linea, REGEX_PAGO, TipoInstruccion.PAGO, 4);
            }
            case "VALIDAR_INSCRIPCION" -> {
                return procesarLineaPorTipo(linea, REGEX_VALIDAR_INSCRIPCION, TipoInstruccion.VALIDACION_INSCRIPCION, 2);
            }
            case "REGISTRO_ACTIVIDAD" -> {
                return procesarLineaPorTipo(linea, REGEX_REGISTRO_ACTIVIDAD, TipoInstruccion.REGISTRO_ACTIVIDAD, 8);
            }
            case "ASISTENCIA" -> {
                return procesarLineaPorTipo(linea, REGEX_ASISTENCIA, TipoInstruccion.REGISTRO_ASISTENCIA, 2);
            }
            case "CERTIFICADO" -> {
                return procesarLineaPorTipo(linea, REGEX_CERTIFICADO, TipoInstruccion.CERTIFICADO, 2);
            }
            case "REPORTE_PARTICIPANTES" -> {
                return procesarLineaPorTipo(linea, REGEX_REPORTE_PARTICIPANTES, TipoInstruccion.REPORTE_PARTICIPANTES, 3);
            }
            case "REPORTE_ACTIVIDADES" -> {
                return procesarLineaPorTipo(linea, REGEX_REPORTE_ACTIVIDADES, TipoInstruccion.REPORTE_ACTIVIDADES, 3);
            }
            case "REPORTE_EVENTOS" -> {
                return procesarLineaPorTipo(linea, REGEX_REPORTE_EVENTOS, TipoInstruccion.REPORTE_EVENTOS, 5);
            }
            default -> {
                System.out.println("Instrucción no reconocida: " + linea);
                return null;
            }
        }
    }
    
    private Instruccion procesarLineaPorTipo(String linea, String regex, TipoInstruccion tipo, int numeroParametros){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(linea);

        if (matcher.matches()) {
            Instruccion instruccion = new Instruccion();
            instruccion.setTipo(tipo);
            String[] parametros = new String[numeroParametros];
            for (int i = 0; i < numeroParametros; i++) {
                parametros[i] = matcher.group(i + 1).trim();
            }

            instruccion.setParametros(parametros);
            return instruccion;
        }

        return null;
    }
    
}
