package com.example.jpademo.service;

import com.example.jpademo.entity.Course;

import java.util.List;

public interface CourseService {

    Course addCourse(Course course);
    Course getCourse(int id);
    List<Course> getAllCourses();
    Course updateCourse(Course course,int id);
    void deleteCourse(int id);
}
