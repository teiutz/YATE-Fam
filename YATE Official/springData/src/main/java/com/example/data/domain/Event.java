package com.example.data.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String name;
    private String location;
    public Event(LocalDate startDate, LocalDate endDate, String name, String location){
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.location = location;
    }
}
