package com.example.homew.service;


import com.example.homew.enitity.FiveLastStudents;
import com.example.homew.model.Faculty;
import com.example.homew.model.Student;
import com.example.homew.repository.StudentRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);


    public StudentService(StudentRepository studentRepository) {
        logger.debug("Вызван конструктор StudentService");
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.debug("Called method createStudent");
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(Long id) {
        logger.debug("Called method findStudent");
        return studentRepository.findById(id);
    }

    public Student editStudent(Student student) {
        logger.debug("Called method editStudent");
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.debug("Called method deleteStudent");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudents() {
        logger.debug("Called method getAllStudents");
        return studentRepository.findAll();
    }

    public List<Student> getStudentsAccordingAge(int age) {
        logger.debug("Called method getStudentsAccordingAge");
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> findStudentByAgeBetween(int minAge, int maxAge) {
        logger.debug("Called method findStudentByAgeBetween");
        return studentRepository.findStudentByAgeBetween(minAge, maxAge);
    }

    public List<Student> findStudentByFaculty(Faculty faculty) {
        logger.debug("Called method findStudentByFaculty");
        return studentRepository.findStudentByFaculty(faculty);
    }

    public List<Integer> getQuantityOfAllStudents() {
        logger.debug("Called method getQuantityOfAllStudents");
        return studentRepository.getQuantityOfAllStudents();
    }

    public List<Double> getAverageAge() {
        logger.debug("Called method getAverageAge");
        return studentRepository.getAverageAge();
    }

    public List<FiveLastStudents> getFiveLastStudents() {
        logger.debug("Called method getFiveLastStudents");
        return studentRepository.getFiveLastStudents();
    }

    public List<Student> findStudentByName(String name) {
        logger.debug("Called method findStudentByName");
        return studentRepository.findStudentByNameContainingIgnoreCase(name);
    }

    /**
     * The method capitalise first letters of student's names,
     * then looking all students whose name start from "A",
     * and then sort them in alphabetic order. Collection of sorted
     * students returns from method.
     */
    public List<Student> getStudentsAlphabetOrder() {
        logger.debug("Called method getStudentsAlphabetOrder");
        return studentRepository.findAll().stream()
                .map(student -> new Student(student.getId(),//creating a new student from database student
                        StringUtils.capitalize(student.getName()),//the capitalizing a first letter of student's name
                        student.getAge()))
                .filter(student -> student.getName().startsWith("А"))//filter students by first letter "A" of the name
                .sorted(Comparator.comparing(student -> student.getName()))//the sorting in alphabetical order
                .collect(Collectors.toList()); //puts the result to list
    }

    /**
     * The method returns average age of students using StreamAPI.
     */
    public double getMiddleAgeOfStudents() {
        logger.debug("Called method getMiddleAgeOfStudents");
        return studentRepository.findAll().stream()
                .mapToDouble(Student::getAge)//convert students age from int to double
                .average()//calculation of average age from all students
                .orElse(0d);//returns the result or 0 if there is no any students ages
    }

    /**
     * The method contains two threads just to see order of executions methods into each thread.
     * the method created for educational purposes.
     */
    public void doStudentsThread() {
        List<Student>studentList=studentRepository.findAll();
        logger.debug("Called method doStudentsThread");
        logger.debug("Name of the 0 student: " + studentRepository.findAll().get(0).getName());
        logger.debug("Name of the 1st student: " + studentRepository.findAll().get(1).getName());

        Thread thread1 = new Thread(() -> {//Threat object creating.
            logger.debug("Name of the 2nd student: " + studentRepository.findAll().get(2).getName());;
            logger.debug("Name of the 3rd student: " + studentRepository.findAll().get(3).getName());


        });
        thread1.start();//Thread starting

        Thread thread2 = new Thread(() -> {
            logger.debug("Name of the 4th student: " + studentRepository.findAll().get(4).getName());
            logger.debug("Name of the 5th student: " + studentRepository.findAll().get(5).getName());
        });
        thread2.start();
    }

    /**
     * The method contains two threads with thread synchronization.
     */
    public void doSynchronizedStudentsThread() {
        List<Student> students = studentRepository.findAll();
        // printStud(students);
        printStud(students);
        Thread thread = new Thread(() -> {
            printStud(students);
            synchronized (StudentService.class) {
                logger.debug("Name of the 3rd student: " + studentRepository.findAll().get(3).getName());
            }
            printStud(students);
        });
        Thread thread2 = new Thread(() -> {
            printStud(students);
            printStud(students);
        });
    }

    public void printStud(List<Student> students) {
        int count=0;
        Integer flag=0;
        synchronized (flag) {
            System.out.println(students.get(count).getName());
            count++;
        }
    }
}

