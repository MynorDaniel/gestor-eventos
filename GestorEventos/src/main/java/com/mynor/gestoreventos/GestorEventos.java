/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.Resultado;
import com.mynor.gestoreventos.servicios.ParticipanteServicio;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        ParticipanteServicio ps = new ParticipanteServicio();
        Resultado r = ps.crearParticipante("mynordma@gmail.com", "Mynor Morales", "ESTUDIANTE", "CUNOC");
        Resultado r2 = ps.crearParticipante("zelda@hyrule.edu", "Zelda Hyrule", "ESTUDIANTE", "Universidad de Hyrule");
        System.out.println(r.getMensaje());
        System.out.println(r2.getMensaje());
    }
}