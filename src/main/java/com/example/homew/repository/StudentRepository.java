package com.example.homew.repository;

import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface StudentRepository<FiveLastStudents> extends JpaRepository <Student, Long> {
    List<Student> findStudentByAge(int age);
    List<Student> findStudentByAgeBetween(int minAge, int maxAge);
    List<Student> findStudentByFaculty(Faculty faculty);
    @Query(value = "select count(*) from student", nativeQuery = true)
    List<Integer> getQuantityOfAllStudents();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    List<Double> getAverageAge();

    @Query(value = "select * from student order by id desc limit 5;", nativeQuery = true)
    List<FiveLastStudents> getFiveLastStudents();
}