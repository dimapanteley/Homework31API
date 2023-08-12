package com.example.homew.controller;

import com.example.homew.model.Student;
import com.example.homew.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // public StudentController(StudentService studentService) {
    //this.studentService = studentService;
    //}
    @PostMapping //CREATE  http://localhost:8080/student
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("{id}") //READ  http://localhost:8080/student/1
    public ResponseEntity<Student> findStudent(@RequestBody @PathVariable Long id){
         Student student = studentService.findStudent(id).get();
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PutMapping("{id}") //UPDATE  http://localhost:8080/student/1
    public ResponseEntity<Student> editStudent(@RequestBody Student student){
        Student edittingStudent = studentService.editStudent(student);
        if(edittingStudent == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("{id}") //DELETE  http://localhost:8080/student/1
    public void  deleteStudent(@RequestBody @PathVariable Long id){
         studentService.deleteStudent(id);
    }
    @GetMapping //READ  http://localhost:8080/student
    public ResponseEntity<Collection<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/filter_by_age/{age}") //READ  http://localhost:8080/student/filter_by_age/20
    public List<Student> getStudentsAccordingAge(@PathVariable int age){
        return studentService.getStudentsAccordingAge(age);
    }
}
