package com.example.course_management_system.mapper;

import com.example.course_management_system.dto.CourseDTO;
import com.example.course_management_system.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDto(Course course) {
        if (course == null) {
            return null;
        }

        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCourseCode(course.getCourseCode());
        dto.setCourseName(course.getCourseName());
        dto.setCourseTime(course.getCourseTime());
        dto.setCourseInstructor(course.getCourseInstructor());
        return dto;
    }

    public Course toEntity(CourseDTO dto) {
        if (dto == null) {
            return null;
        }

        Course course = new Course();
        course.setId(dto.getId());
        course.setCourseCode(dto.getCourseCode());
        course.setCourseName(dto.getCourseName());
        course.setCourseTime(dto.getCourseTime());
        course.setCourseInstructor(dto.getCourseInstructor());
        return course;
    }
}