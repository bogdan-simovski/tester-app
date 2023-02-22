package com.example.testerapp.web;

import com.example.testerapp.repository.CourseRepository;
import com.example.testerapp.repository.StudentRepository;
import com.example.testerapp.repository.model.Course;
import com.example.testerapp.repository.model.Student;
import com.example.testerapp.service.OneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

  private OneService oneService;
  private StudentRepository studentRepository;
  private CourseRepository courseRepository;


  @PostMapping(path = "/transaction/{studentName}/{courseName}")
  public ResponseEntity saveCourseIfThereIsAStudent(@PathVariable String courseName, @PathVariable String studentName) {
    oneService.createStudentAndCourseWithTransaction(courseName, studentName);
    return ResponseEntity.ok("ok");
  }

  @PostMapping("{studentName}/{courseName}")
  public ResponseEntity saveCourse(@PathVariable String courseName, @PathVariable String studentName) {
    oneService.createStudentAndCourseWithoutTransaction(courseName, studentName);
    return ResponseEntity.ok("ok");
  }

  @GetMapping("/courses")
  public ResponseEntity getCourses(){
    List<Course> courseList = courseRepository.findAll();
    return ResponseEntity.ok(courseList.toString());
  }

  @GetMapping(path = "/students")
  public ResponseEntity getStudents(){
    List<Student> studentList = studentRepository.findAll();
    return ResponseEntity.ok(studentList.toString());
  }

}
