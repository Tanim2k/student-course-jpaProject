package com.example.jpademo.repository;

import com.example.jpademo.entity.Course;
import com.example.jpademo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepo extends JpaRepository<Course,Integer> {
}
