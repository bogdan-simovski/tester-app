package com.example.testerapp.service;

import com.example.testerapp.repository.CourseRepository;
import com.example.testerapp.repository.StudentPersistence;
import com.example.testerapp.repository.StudentRepository;
import com.example.testerapp.repository.model.Course;
import com.example.testerapp.repository.model.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OneService {

  private StudentRepository studentRepository;
  private CourseRepository courseRepository;
  private StudentPersistence studentPersistence;

  @Transactional
  public String createStudentAndCourseWithTransaction(String studentName, String courseName) {
    Student student = Student.builder().name(studentName).build();
    try {
      studentPersistence.save(student);
    } catch (Exception ex) {
      log.debug(ex.getMessage());
    }

    List<Student> students = new ArrayList<>();
    students.add(student);
    Course course = Course.builder().name(courseName).students(students).build();
    courseRepository.save(course);
    return courseName;
  }

  public String createStudentAndCourseWithoutTransaction(String studentName, String courseName) {
    Student student = Student.builder().name(studentName).build();
    try {
      studentPersistence.save(student);
    } catch (Exception ex) {
      log.debug(ex.getMessage());
    }

    List<Student> students = new ArrayList<>();
    students.add(student);
    Course course = Course.builder().name(courseName).students(students).build();
    courseRepository.save(course);
    return courseName;
  }

}
