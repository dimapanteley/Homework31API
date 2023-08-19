package com.example.homew.controller;

import com.example.homew.model.Faculty;
import com.example.homew.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping //CREATE  http://localhost:8080/faculty
    public Faculty createStudent(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @GetMapping("{id}") //READ  http://localhost:8080/faculty/1
    public ResponseEntity<Faculty> findFaculty(@RequestBody @PathVariable Long id){
        Faculty faculty = facultyService.findFaculty(id).get();
        if(faculty == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @PutMapping("{id}") //UPDATE  http://localhost:8080/faculty
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty){
        Faculty editiedFaculty = facultyService.editFaculty(faculty);
        if(editiedFaculty == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @DeleteMapping("{id}") //DELETE  http://localhost:8080/faculty/1
    public void  deleteFaculty(@RequestBody @PathVariable Long id){
        facultyService.deleteFaculty(id);
    }
    @GetMapping //READ  http://localhost:8080/faculty
    public ResponseEntity<Collection<Faculty>> getAllFaculties(){
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/filter_by_color") //READ  http://localhost:8080/faculty/filter_by_color
    public List<Faculty> getFacultyAccordingColor(@RequestParam String color){
        return facultyService.getFacultyAccordingColor(color);
    }
}