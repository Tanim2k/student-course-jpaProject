package com.example.jpademo.service;

import com.example.jpademo.entity.Course;
import com.example.jpademo.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    Student getStudent(int id);
    List<Student> getAllStudents();
    Student updateStudent(Student student,int id);
    void deleteStudent(int id);
}
