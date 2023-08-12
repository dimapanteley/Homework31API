package com.example.homew.repository;

import com.example.homew.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    List<Faculty> findFacultyByColorContainsIgnoreCase(String color);
}

