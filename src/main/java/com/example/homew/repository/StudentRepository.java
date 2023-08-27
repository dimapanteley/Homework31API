package com.example.homew.repository;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    List<Student> findStudentByAge(int age);
    List<Student> findStudentByAgeBetween(int minAge, int maxAge);
    List<Student> findStudentByFaculty(Faculty faculty);

    List<Integer> getQuantityOfAllStudents();

    List<Double> getAverageAge();

    <FiveLastStudents> List<FiveLastStudents> getFiveLastStudents();
}
