package com.example.md03.service;
import com.example.md03.dto.CourseCreateRequest;
import com.example.md03.dto.CourseUpdateRequest;
import com.example.md03.dto.CourseResponse;
import com.example.md03.dto.PageResponse;
import com.example.md03.dto.CourseResponseV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.md03.model.Course;
import com.example.md03.model.CourseStatus;
import com.example.md03.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public void createCourse(CourseCreateRequest req) {
        Course course = new Course();
        course.setTitle(req.getTitle());
        // gán các field còn lại từ req cho khớp entity Course của bạn
        courseRepository.save(course);
    }

    public void updateCourse(Long id, CourseUpdateRequest req) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
        course.setTitle(req.getTitle());
        // cập nhật các field còn lại từ req
        courseRepository.save(course);
    }

    public PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction) {
        if (page < 0) page = 0;
        if (size < 1) size = 10;

        String sortField = (sortBy == null || sortBy.isBlank()) ? "id" : sortBy;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));

        Page<CourseResponse> coursePage = courseRepository.findAll(pageable).map(this::toCourseResponse);

        return new PageResponse<>(
                coursePage.getContent(),
                coursePage.getNumber(),
                coursePage.getSize(),
                coursePage.getTotalElements(),
                coursePage.getTotalPages(),
                coursePage.isLast()
        );
    }

    public PageResponse<CourseResponseV2> getPagedCoursesByStatus(int page, int size, String sortBy,
                                                                  Sort.Direction direction, CourseStatus status) {
        if (page < 0) page = 0;
        if (size < 1) size = 10;

        String sortField = (sortBy == null || sortBy.isBlank()) ? "id" : sortBy;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortField));

        Page<CourseResponseV2> coursePage = courseRepository.findAllByStatusV2(status, pageable);

        return new PageResponse<>(
                coursePage.getContent(),
                coursePage.getNumber(),
                coursePage.getSize(),
                coursePage.getTotalElements(),
                coursePage.getTotalPages(),
                coursePage.isLast()
        );
    }

    private CourseResponse toCourseResponse(Course c) {
        return new CourseResponse(c.getId(), c.getTitle(), c.getStatus());
    }
}