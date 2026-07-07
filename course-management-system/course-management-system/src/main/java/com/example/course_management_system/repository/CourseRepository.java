package com.example.course_management_system.repository;

import com.example.course_management_system.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // Find course by course code (returns Optional)
    Optional<Course> findByCourseCode(String courseCode);

    // Find courses by instructor name
    List<Course> findByCourseInstructor(String instructor);

    // Check if course exists by course code
    boolean existsByCourseCode(String courseCode);

    // Find courses containing a keyword in course name (ignores case)
    List<Course> findByCourseNameContainingIgnoreCase(String keyword);
}