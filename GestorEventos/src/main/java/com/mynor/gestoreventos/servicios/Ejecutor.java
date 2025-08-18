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
    
    public void ejecutar(String url, Instruccion i, int tiempoProcesamiento, Consumer<String> callback) {
        //Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(tiempoProcesamiento);
                String log = i.ejecutar(url).getMensaje();
                callback.accept(log);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                callback.accept("Error al ejecutar instrucción");
            }
        //});
        //hilo.start();
    }
}