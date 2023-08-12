package com.example.homew.service;

import com.example.homew.model.Student;
import com.example.homew.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student student) {
         return studentRepository.save(student);

    }

    public Optional<Student> findStudent(Long id) {
        return studentRepository.findById(id);
    }

    public Student editStudent(Student student) {
            return studentRepository.save(student);


    }

    public  void  deleteStudent(Long id){
         studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsAccordingAge(int age) {
        return (List<Student>) studentRepository.findStudentByAge(age);

    }
}
