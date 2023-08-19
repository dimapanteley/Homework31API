package com.example.homew.repository;

import com.example.homew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student>  findStudentByAge(int age);
}
