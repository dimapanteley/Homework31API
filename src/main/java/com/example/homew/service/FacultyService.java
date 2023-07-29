package com.example.homew.service;

import com.example.homew.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service

public class FacultyService {
    private Map<Long, Faculty> facultyMap;
    private  long lastFacultyId=0;
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastFacultyId);
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return facultyMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultyMap.containsKey(faculty.getId())) {
            facultyMap.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return facultyMap.values();
    }

    public List<Faculty> getFacultyAccordingColor(String color) {
        List<Faculty> facultyList = facultyMap.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
        return facultyList;
    }


}
