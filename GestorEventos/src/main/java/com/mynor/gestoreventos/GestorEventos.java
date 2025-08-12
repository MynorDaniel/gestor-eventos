/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.*;
import com.mynor.gestoreventos.servicios.*;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        InscripcionServicio i = new InscripcionServicio();
        
        String codigo = "EVT-10";
        String correo = "mynordma@gmail.com";
        String tipo = "TALERISTA";

        Resultado r = i.crearInscripcion(codigo, correo, tipo);
        System.out.println(r.getMensaje());
        
    }
}