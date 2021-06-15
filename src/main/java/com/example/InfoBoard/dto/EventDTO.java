package com.example.InfoBoard.dto;



import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {

    private Long id;

    //patient's id
    private PatientDTO patient;

    //date of the event
    private LocalDate date;

    //time of the event
    private LocalTime time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
