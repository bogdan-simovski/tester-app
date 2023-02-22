package com.example.testerapp.repository;

import com.example.testerapp.repository.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class StudentPersistence {

  private final StudentRepository studentRepository;

  @Transactional
  public void save(Student student){
    studentRepository.save(student);
    throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
  }
}
