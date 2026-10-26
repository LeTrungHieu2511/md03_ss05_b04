package com.example.md03.controller;
import com.example.md03.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.md03.service.CourseService;
import com.example.md03.model.CourseStatus;
import com.example.md03.dto.CourseResponseV2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody CourseCreateRequest req) {
        courseService.createCourse(req);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Course Created Successfully", true, null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> update(@PathVariable Long id,
                                                    @RequestBody CourseUpdateRequest req) {
        courseService.updateCourse(id, req);
        return ResponseEntity.ok(new ApiResponse<>("Course Updated Successfully", true, null));
    }
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CourseResponseV2>>> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction,
            @RequestParam(defaultValue = "ACTIVE") CourseStatus status) {

        PageResponse<CourseResponseV2> result =
                courseService.getPagedCoursesByStatus(page, size, sortBy, direction, status);

        return ResponseEntity.ok(new ApiResponse<>("Ok", true, result));
    }
}