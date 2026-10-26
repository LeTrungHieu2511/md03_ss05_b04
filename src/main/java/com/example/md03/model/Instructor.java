package com.example.md03.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses = new ArrayList<>();
}