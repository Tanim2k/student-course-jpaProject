package com.example.jpademo.controller;

import com.example.jpademo.entity.Course;
import com.example.jpademo.entity.Student;
import com.example.jpademo.service.CourseService;
import com.example.jpademo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private CourseService courseService;
    private StudentService studentService;

    public DemoController(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping("/allCourse")
  public String getAllCourse(Model model)
    {
        List<Course>courses=courseService.getAllCourses();
        model.addAttribute("courses",courses);
        return "All-Courses";
    }
    @GetMapping("/stuDetails/{code}")
    public String studentDetails(@PathVariable int code,Model model)
    {
        Course course=courseService.getCourse(code);
        List<Student>students=course.getStudents();
        model.addAttribute("students",students);
        return "student-details";
    }


}
