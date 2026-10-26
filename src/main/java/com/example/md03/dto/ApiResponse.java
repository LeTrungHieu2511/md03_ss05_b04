package com.example.md03.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private boolean status;
    private T data;
}
