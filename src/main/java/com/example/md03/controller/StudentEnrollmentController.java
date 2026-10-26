package com.example.md03.controller;
import com.example.md03.dto.ApiResponse;
import com.example.md03.dto.EnrollmentRequest;
import com.example.md03.service.StudentEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/students-enrollments")
public class StudentEnrollmentController {

    private final StudentEnrollmentService enrollmentService;

    public StudentEnrollmentController(StudentEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> enroll(@RequestBody EnrollmentRequest req) {
        enrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Student Enrolled Successfully", true, null));
    }
}
