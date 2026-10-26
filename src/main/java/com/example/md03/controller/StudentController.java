package com.example.md03.controller;
import com.example.md03.dto.ApiResponse;
import com.example.md03.dto.StudentCreateRequest;
import com.example.md03.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody StudentCreateRequest req) {
        studentService.createStudent(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Student Created Successfully", true, null));
    }
}
