package com.example.InfoBoard.Service;

import com.example.InfoBoard.dto.EventDTO;

import java.util.List;

public interface RestService {
    List<EventDTO> getEvents();
}
