package com.example.jpademo.service;

import com.example.jpademo.entity.Course;
import com.example.jpademo.exception.CourseIdNotFound;
import com.example.jpademo.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course addCourse(Course course) {
        courseRepo.save(course);
        return course;
    }

    @Override
    public Course getCourse(int id) {
        return courseRepo.findById(id).orElseThrow(()-> new CourseIdNotFound("Course id Not found"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course updateCourse(Course course, int id) {
       Course course1=courseRepo.findById(id).orElseThrow(()-> new CourseIdNotFound("Course id Not found"));
       course1.setCode(course.getCode());
       course1.setName(course.getName());
       course1.setStudents(course.getStudents());
       courseRepo.save(course1);
       return course1;
    }

    @Override
    public void deleteCourse(int id) {
        Course course1=courseRepo.findById(id).orElseThrow(()-> new CourseIdNotFound("Course id Not found"));
        courseRepo.deleteById(id);
    }
}
