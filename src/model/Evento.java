/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author vfbellaver & EderSMarques
 */
public class Evento {
    private int idEvento;
    private Timestamp dataHora;
    private boolean ventilador;
    private boolean luzSala;
    private boolean tv;
    private boolean luzQuarto;
    private boolean status;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isVentilador() {
        return ventilador;
    }

    public void setVentilador(boolean ventilador) {
        this.ventilador = ventilador;
    }

    public boolean isLuzSala() {
        return luzSala;
    }

    public void setLuzSala(boolean luzSala) {
        this.luzSala = luzSala;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isLuzQuarto() {
        return luzQuarto;
    }

    public void setLuzQuarto(boolean luzQuarto) {
        this.luzQuarto = luzQuarto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
