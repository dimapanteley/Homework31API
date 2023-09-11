package com.example.homew.repository;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);
    List<Faculty> findFacultyByNameContainingIgnoreCase(String name);

     List<Faculty> findFacultyByColorContainsIgnoreCase(String color);

    Faculty findFacultyByStudent(Student student);

    List<Faculty> findFacultyByNameContainingIgnoreCaseAndColorContainingIgnoreCase(String name, String color);
}
//