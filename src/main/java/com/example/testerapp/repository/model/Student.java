package com.example.testerapp.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentSeq")
  @SequenceGenerator(name = "StudentSq",
    sequenceName = "STUDENT_SEQ",
    allocationSize = 5,
    initialValue = 10000)
  @Column(name = "ID")
  @Access(AccessType.PROPERTY)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "COURSE")
  private Course course;
}
