package com.example.jpademo.service;

import com.example.jpademo.entity.Student;
import com.example.jpademo.exception.StudentIdNotFound;
import com.example.jpademo.repository.CourseRepo;
import com.example.jpademo.repository.StudentRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student addStudent(Student student) {
        studentRepo.save(student);
        return student;
    }

    @Override
    public Student getStudent(int id) {
        return studentRepo.findById(id).orElseThrow(()->new StudentIdNotFound("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(Student student, int id) {
       Student student1=studentRepo.findById(id).orElseThrow(()->new StudentIdNotFound("Student not found"));
       student1.setFirstName(student.getFirstName());
       student1.setLastName(student.getLastName());
       studentRepo.save(student1);
       return student1;
    }

    @Override
    public void deleteStudent(int id) {
        Student student1=studentRepo.findById(id).orElseThrow(()->new StudentIdNotFound("Student not found"));
        studentRepo.deleteById(id);
    }
}
