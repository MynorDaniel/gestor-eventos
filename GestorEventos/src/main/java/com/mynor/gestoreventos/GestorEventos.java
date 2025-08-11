/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mynor.gestoreventos;

import com.mynor.gestoreventos.modelos.Resultado;
import com.mynor.gestoreventos.modelos.enums.TipoParticipante;
import com.mynor.gestoreventos.servicios.ParticipanteServicio;

/**
 *
 * @author mynordma
 */
public class GestorEventos {

    public static void main(String[] args) {
        ParticipanteServicio ps = new ParticipanteServicio();
        TipoParticipante tipo = ps.obtenerTipo("mynordma@gmail.com");
        System.out.println(tipo.name());
    }
}