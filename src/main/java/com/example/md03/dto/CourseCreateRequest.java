package com.example.md03.dto;

import com.example.md03.model.CourseStatus;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CourseCreateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;
}