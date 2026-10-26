package com.example.md03.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;
}