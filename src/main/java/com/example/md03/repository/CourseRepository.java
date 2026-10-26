package com.example.md03.repository;

import com.example.md03.model.Course;
import com.example.md03.model.CourseStatus;
import com.example.md03.dto.CourseResponseV2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("""
        SELECT new com.example.md03.dto.CourseResponseV2(
            c.id,
            c.title,
            c.status
        )
        FROM Course c
        WHERE c.status = :status
        """)
    Page<CourseResponseV2> findAllByStatusV2(
            @Param("status") CourseStatus status,
            Pageable pageable
    );
}