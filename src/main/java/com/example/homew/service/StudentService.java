package com.example.homew.service;

import com.example.homew.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class StudentService {
    private Map< Long, Student> studentMap=new HashMap<>();
    private long lastStudentId=0;
    public Student createStudent(Student student) {
        student.setId(++lastStudentId);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student findStudent(Long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(Long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

    public List<Student> getStudentsAccordingAge(int age) {
        List<Student> studentList = studentMap.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
        return studentList;
    }
}
