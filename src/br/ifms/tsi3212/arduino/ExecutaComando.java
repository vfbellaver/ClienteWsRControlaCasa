/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi3212.arduino;

import br.ifms.tsi3212.rxtx.RXTXUtil;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;

/**
 *
 * @author vfbellaver & EderSMarques
 */
public class ExecutaComando {
     RXTXUtil rx = new RXTXUtil();
    //-------------------- EXECUÇÃO DO ARDUINO ----------------------------//
    public void executarEvento(String valor) throws PortInUseException, IOException, UnsupportedCommOperationException{
        try {
            rx.conectar(rx.listarPortasSeriais().get(0));
            rx.enviarDados(valor);
            rx.desconectar();
        } catch (Exception e) {
            System.out.println("ERRO "+e.getMessage());
        }

    }
}
