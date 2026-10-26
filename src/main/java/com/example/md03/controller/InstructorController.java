package com.example.md03.controller;

import com.example.md03.dto.ApiResponse;
import com.example.md03.dto.InstructorCreateRequest;
import com.example.md03.model.Instructor;
import com.example.md03.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody InstructorCreateRequest req) {
        instructorService.createInstructor(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Instructor Created Successfully", true, null));
    }
}