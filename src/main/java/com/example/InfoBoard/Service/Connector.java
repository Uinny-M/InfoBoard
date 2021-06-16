package com.example.InfoBoard.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
//@Getter
//@Setter
public class Connector {
    private Client eventClient;
    private WebTarget eventTarget;
    private ObjectMapper objectMapper;

    protected Connector() {
        eventClient = ClientBuilder.newClient();
        eventTarget = eventClient.target("http://localhost:8080/T_school_war_exploded/rest/events");
        objectMapper = new ObjectMapper();
    }

    public Client getEventClient() {
        return eventClient;
    }

    public void setEventClient(Client eventClient) {
        this.eventClient = eventClient;
    }

    public WebTarget getEventTarget() {
        return eventTarget;
    }

    public void setEventTarget(WebTarget eventTarget) {
        this.eventTarget = eventTarget;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
