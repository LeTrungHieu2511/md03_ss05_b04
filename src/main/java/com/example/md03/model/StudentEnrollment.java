package com.example.md03.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_enrollments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}