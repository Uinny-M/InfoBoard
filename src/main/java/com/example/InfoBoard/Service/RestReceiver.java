package com.example.InfoBoard.Service;

import com.example.InfoBoard.dto.EventOutDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;


@Named
@Startup
@Stateless
@Dependent
public class RestReceiver extends Connector{
    java.util.logging.Logger log = Logger.getLogger(RestReceiver.class.getName());

    public List<EventOutDTO> getEvents() throws JsonProcessingException {

        log.info("getEvents()");

        return getObjectMapper().readValue(
                getEventTarget().request(MediaType.APPLICATION_JSON).get(String.class),
                new TypeReference<List<EventOutDTO>>(){}
        );
    }
}
