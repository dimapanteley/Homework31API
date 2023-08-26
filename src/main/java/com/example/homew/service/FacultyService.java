package com.example.homew.service;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import com.example.homew.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
   private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findFaculty(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
       return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<Faculty> getFacultyAccordingName(String name) {
       return facultyRepository.findFacultyByNameContainingIgnoreCase(name);
    }
    public List<Faculty> getFacultyAccordingColor(String color) {
        return facultyRepository.findFacultyByColorContainsIgnoreCase(color);
    }

    public Faculty findFacultyByStudent(Student student) {
        return facultyRepository.findFacultyByStudent(student);
    }
}
