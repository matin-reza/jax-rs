package com.mkyong.client;

import com.mkyong.resource.Reza;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyClientGet {

    public static void main(String[] args) throws Exception {

        Client client = ClientBuilder.newClient();
        Response response = client.target("http://localhost:8082/hello").request().post(Entity.entity(new Reza(), MediaType.APPLICATION_JSON));

       /* ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8082/hello");
        Response response = target.request()
                .post(Entity.entity(new Reza(), "application/json"));*/
        System.out.println(((Reza) response.readEntity(Reza.class)).getBirthDate());
        response.close();

    }
}