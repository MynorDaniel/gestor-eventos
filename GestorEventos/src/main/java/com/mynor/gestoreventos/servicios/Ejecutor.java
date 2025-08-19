/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.gestoreventos.servicios;

import com.mynor.gestoreventos.modelos.Instruccion;
import java.util.function.Consumer;

/**
 *
 * @author mynordma
 */
public class Ejecutor {
    
    /**
     * Ejecuta una instruccion
     * Al terminar, ejecuta el callback para procesar el log en el frontend
     * @param url
     * @param i
     * @param tiempo
     * @param callback
     */
    public void ejecutar(String url, Instruccion i, String tiempo, Consumer<String> callback) {
        //Thread hilo = new Thread(() -> {
            try {
                int tiempoProcesamiento = Integer.parseInt(tiempo);
                if(tiempoProcesamiento < 0) throw new NumberFormatException();
                Thread.sleep(tiempoProcesamiento);
                String log = i.ejecutar(url).getMensaje();
                callback.accept(log);
            } catch (InterruptedException | NumberFormatException e) {
                System.out.println(e.getMessage());
                callback.accept("Error, verifica que el tiempo sea valido");
            }
        //});
        //hilo.start();
    }
}