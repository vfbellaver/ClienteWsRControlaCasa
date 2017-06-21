/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi3212.ws;

import br.ifms.tsi3212.rxtx.RXTXUtil;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.sql.Timestamp;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Evento;

/**
 *
 * @author vfbellaver e EderSMarques
 */
public class ClienteWs {
    //-------------------- RECURSOS DO WEBSERVICEREST----------------------------//

    public Evento verificarAgenda(Long valor) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/WSRestControlaCasa");
        Evento evento = target.path("/consultaevento/" + valor).request().get(Evento.class);
        return evento;
    }
    
    public void atualizaStatusEvento(Evento evento) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8084/WSRestControlaCasa");
        Entity<Evento> entity = Entity.entity(evento, MediaType.APPLICATION_JSON);
        Response response = target.path("/consultaevento").request().put(entity);
      
    }
}
