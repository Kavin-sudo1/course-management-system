package com.example.course_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_code", nullable = false, unique = true, length = 20)
    @NotBlank(message = "Course code is required")
    @Size(max = 20, message = "Course code must be less than 20 characters")
    private String courseCode;

    @Column(name = "course_name", nullable = false, length = 100)
    @NotBlank(message = "Course name is required")
    @Size(max = 100, message = "Course name must be less than 100 characters")
    private String courseName;

    @Column(name = "course_time", nullable = false, length = 50)
    @NotBlank(message = "Course time is required")
    @Size(max = 50, message = "Course time must be less than 50 characters")
    private String courseTime;

    @Column(name = "course_instructor", nullable = false, length = 100)
    @NotBlank(message = "Course instructor is required")
    @Size(max = 100, message = "Course instructor must be less than 100 characters")
    private String courseInstructor;

    public Course() {
    }

    public Course(Long id, String courseCode, String courseName, String courseTime, String courseInstructor) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.courseInstructor = courseInstructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }
}