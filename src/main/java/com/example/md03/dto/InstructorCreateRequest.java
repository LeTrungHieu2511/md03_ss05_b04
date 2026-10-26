package com.example.md03.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class InstructorCreateRequest {
    private String name;
    private String email;
}