package com.example.homew.repository;

import com.example.homew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositry extends JpaRepository<Student,Long> {
}
