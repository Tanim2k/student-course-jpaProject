package com.example.jpademo.controller;

import com.example.jpademo.entity.Course;
import com.example.jpademo.entity.Student;
import com.example.jpademo.service.CourseService;
import com.example.jpademo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private CourseService courseService;
    private StudentService studentService;

    public DemoRestController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    @GetMapping("course/{id}")
    public ResponseEntity<Course>getCourse(@PathVariable int id)
    {
       Course course= courseService.getCourse(id);
       return new ResponseEntity<>(course,HttpStatus.OK);
    }
    @GetMapping("/allCourse")
  public ResponseEntity<List<Course>> getAllCourse()
    {
        List<Course>allCourse=courseService.getAllCourses();
        return new ResponseEntity<>(allCourse,HttpStatus.ACCEPTED);
    }
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course,@PathVariable int id)
    {
        Course course1=courseService.updateCourse(course,id);
        return new ResponseEntity<>(course1,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id)
    {
        Course course=courseService.getCourse(id);
        courseService.deleteCourse(id);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        Student student1=studentService.addStudent(student);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);
    }
   @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id)
   {
       Student student=studentService.getStudent(id);
       return new ResponseEntity<>(student,HttpStatus.OK);
   }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student>students=studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
   @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable int id)
   {
       Student student1=studentService.updateStudent(student,id);
        return new ResponseEntity<>(student1,HttpStatus.ACCEPTED);
   }

   @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id)
   {
       Student student=studentService.getStudent(id);
       studentService.deleteStudent(id);
       return new ResponseEntity<>(student,HttpStatus.ACCEPTED);
   }


}
