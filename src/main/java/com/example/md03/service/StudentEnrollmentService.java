package com.example.md03.service;
import com.example.md03.model.Course;
import com.example.md03.model.Student;
import com.example.md03.model.StudentEnrollment;
import com.example.md03.repository.CourseRepository;
import com.example.md03.repository.StudentEnrollmentRepository;
import com.example.md03.repository.StudentRepository;
import org.springframework.stereotype.Service;
@Service
public class StudentEnrollmentService {

    private final StudentEnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentEnrollmentService(StudentEnrollmentRepository enrollmentRepository,
                                    StudentRepository studentRepository,
                                    CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found: " + courseId));
        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
    }
}