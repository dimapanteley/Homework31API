package com.example.homew.service;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import com.example.homew.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        logger.debug("Вызван контроллер FacultyService");
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Вызван метод createFaculty");
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findFaculty(Long id) {
        logger.debug("Вызван метод findFaculty");
        return facultyRepository.findById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.debug("Вызван метод editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        logger.debug("Вызван метод deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculties() {
        logger.debug("Вызван метод getAllFaculties");
        return facultyRepository.findAll();
    }

    public List<Faculty> getFacultyAccordingName(String name) {
        logger.debug("Вызван метод getFacultyAccordingName");
        return facultyRepository.findFacultyByNameContainingIgnoreCase(name);
    }

    public List<Faculty> getFacultyAccordingColor(String color) {
        logger.debug("Вызван метод getFacultyAccordingName");
        return facultyRepository.findFacultyByColorContainsIgnoreCase(color);
    }

    public Faculty findFacultyByStudent(Student student) {
        logger.debug("Вызван метод findFacultyByStudent");
        return facultyRepository.findFacultyByStudent(student);
    }

    public List<Faculty> findFacultyByNameAndColor(String name, String color) {
        logger.debug("Вызван метод findFacultyByNameAndColor");
        return facultyRepository.findFacultyByNameContainingIgnoreCaseAndColorContainingIgnoreCase(name, color);
    }
}
