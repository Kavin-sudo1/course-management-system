package com.example.course_management_system.service.implementation;

import com.example.course_management_system.dto.CourseDTO;
import com.example.course_management_system.entity.Course;
import com.example.course_management_system.exception.ResourceNotFoundException;
import com.example.course_management_system.repository.CourseRepository;
import com.example.course_management_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseTime(courseDTO.getCourseTime());
        course.setCourseInstructor(courseDTO.getCourseInstructor());

        Course savedCourse = courseRepository.save(course);
        return toDto(savedCourse);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
        return toDto(course);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        // Check if course exists
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        // Update fields
        existingCourse.setCourseCode(courseDTO.getCourseCode());
        existingCourse.setCourseName(courseDTO.getCourseName());
        existingCourse.setCourseTime(courseDTO.getCourseTime());
        existingCourse.setCourseInstructor(courseDTO.getCourseInstructor());

        // Save updated course
        Course updatedCourse = courseRepository.save(existingCourse);
        
        return toDto(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));

        courseRepository.delete(course);
    }

    private CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCourseCode(course.getCourseCode());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseTime(course.getCourseTime());
        courseDTO.setCourseInstructor(course.getCourseInstructor());
        return courseDTO;
    }
}