package com.wad.firstmvc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate deadline;
    private String importance;
    private boolean status;

    @ManyToMany(mappedBy = "tasks")
    private List<User> users;

    public Task(String name, String description, LocalDate deadline, String importance, boolean status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.importance = importance;
        this.status = status;
    }
}
