package com.example.homew.service;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import com.example.homew.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        logger.debug("Вызван контроллер FacultyService");
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Called method createFaculty");
        return facultyRepository.save(faculty);
    }

    public Optional<Faculty> findFaculty(Long id) {
        logger.debug("Called method findFaculty");
        return facultyRepository.findById(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.debug("Called method editFaculty");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        logger.debug("Called method deleteFaculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAllFaculties() {
        logger.debug("Called method getAllFaculties");
        return facultyRepository.findAll();
    }

    public List<Faculty> getFacultyAccordingName(String name) {
        logger.debug("Called method getFacultyAccordingName");
        return facultyRepository.findFacultyByNameContainingIgnoreCase(name);
    }

    public List<Faculty> getFacultyAccordingColor(String color) {
        logger.debug("Called method getFacultyAccordingName");
        return facultyRepository.findFacultyByColorContainsIgnoreCase(color);
    }

    public Faculty findFacultyByStudent(Student student) {
        logger.debug("Called method findFacultyByStudent");
        return facultyRepository.findFacultyByStudent(student);
    }

    public List<Faculty> findFacultyByNameAndColor(String name, String color) {
        logger.debug("Called method findFacultyByNameAndColor");
        return facultyRepository.findFacultyByNameContainingIgnoreCaseAndColorContainingIgnoreCase(name, color);
    }


    public Faculty getLongestFacultyName() {
        return facultyRepository.findAll().stream()
                .max(Comparator.comparing(faculty -> faculty.getName().length()))
                .orElse(null);
    }


    public int getIntegerNumber() {
        return Stream
                .iterate(1, a -> a + 1)
                .limit(1_000_000)
                .reduce(0, (a, b) -> a + b);
    }
}
