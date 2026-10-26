package com.example.md03.dto;

import com.example.md03.model.CourseStatus;

public class CourseResponse {
    private Long id;
    private String title;
    private CourseStatus status;

    public CourseResponse(Long id, String title, CourseStatus status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public CourseStatus getStatus() { return status; }
}
