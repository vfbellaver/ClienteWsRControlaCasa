/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi3212.main;

import br.ifms.tsi3212.arduino.ExecutaComando;
import br.ifms.tsi3212.ws.ClienteWs;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Evento;

/**
 *
 * @author Vagner Bellaver e Eder Soares Marques
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ligaVentilador = "1", desligaVentilador = "2",
                ligaLuzSala = "3", desligaLuzSala = "4",
                ligaTv = "5", desligaTv = "6",
                ligaLuzQuarto = "7", desligaLuzQuarto = "8";

        ClienteWs buscaEvento = new ClienteWs();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(new Date());
                    calendar.set(Calendar.SECOND, 0);
                    calendar.set(Calendar.MILLISECOND, 0);
                    Date data = calendar.getTime();
                    System.out.println("Data Consulta - "+new Date());
                    System.out.println("DATA CONSULTA - "+data);
                    System.out.println("DATA LONG - "+data.getTime());
                    System.out.println("----------------------------------------");
                    
                    Evento resultado = buscaEvento.verificarAgenda(data.getTime());
                    if (resultado != null) {
                        System.out.println("ID DO EVENTO - " + resultado.getIdEvento());
                        System.out.println("DATA HORA - " + resultado.getDataHora());
                        System.out.println("LUZ QUARTO - " + resultado.isLuzQuarto());
                        System.out.println("LUZ SALA - " + resultado.isLuzSala());
                        System.out.println("TV - " + resultado.isTv());
                        System.out.println("VENTILADOR - " + resultado.isVentilador());
                        System.out.println("STATUS EVENTO - "+resultado.isStatus());
                        ExecutaComando exec = new ExecutaComando();
                        try {
                            if (resultado.isVentilador() == true) {
                                exec.executarEvento(ligaVentilador);
                            } else {
                                exec.executarEvento(desligaVentilador);
                            }
                            if (resultado.isLuzSala() == true) {
                                exec.executarEvento(ligaLuzSala);
                            } else {
                                exec.executarEvento(desligaLuzSala);
                            }
                            if (resultado.isTv() == true) {
                                exec.executarEvento(ligaTv);
                            } else {
                                exec.executarEvento(desligaTv);
                            }
                            if (resultado.isLuzQuarto() == true) {
                                exec.executarEvento(ligaLuzQuarto);
                            } else {
                                exec.executarEvento(desligaLuzQuarto);
                            }
                        } catch (Exception e) {
                            System.out.println("ERRO AO EXECUTAR EVENTO - "+e.getMessage());
                        }

                        
                        resultado.setStatus(true);
                        new ClienteWs().atualizaStatusEvento(resultado);
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t1.start();
    }
}
