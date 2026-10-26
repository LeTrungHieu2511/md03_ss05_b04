package com.example.md03.service;
import com.example.md03.dto.StudentCreateRequest;
import com.example.md03.model.Student;
import com.example.md03.repository.StudentRepository;
import org.springframework.stereotype.Service;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail());
        studentRepository.save(student);
    }
}