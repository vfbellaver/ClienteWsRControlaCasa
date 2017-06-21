/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi3212.rxtx;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author Vagner Bellaver e Eder Soares Marques
 */
public class RXTXUtil {
     private OutputStream serialOut;
    private SerialPort serialPort;

    public List<CommPortIdentifier> listarPortasSeriais() {       
        // TODO - RXTX Listar Portas
        Enumeration<CommPortIdentifier> identificadoresDasPortas = CommPortIdentifier.getPortIdentifiers();
        List<CommPortIdentifier> listaDePortas = new ArrayList<CommPortIdentifier>();        
        
        CommPortIdentifier porta;    
            //esse while faz a mesma coisa do WHILE do ResultSet
            while (identificadoresDasPortas.hasMoreElements()) {
                porta = identificadoresDasPortas.nextElement();
                listaDePortas.add(porta);
            }
            return listaDePortas;
    }
    /**
     * Realiza a conexão 
     * @param porta 
     */
    public void conectar(CommPortIdentifier porta) throws PortInUseException, IOException, UnsupportedCommOperationException{
        serialPort = (SerialPort) porta.open("Comunicação Serial", 9600);
        serialOut = serialPort.getOutputStream();
        
        serialPort.setSerialPortParams(9600, 
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);
    }
    /**
     * Desconecta a porta
     * @throws IOException 
     */
    public void desconectar() throws IOException{
        serialPort.close();
        serialOut.close();
    }
    /**
     * Envia dados para o arduino convertendo a mensagem em bites
     * @param valor
     * @throws IOException 
     */
    public void enviarDados(String valor) throws IOException {
        serialOut.write(valor.getBytes());
    }
}
