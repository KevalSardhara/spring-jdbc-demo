package com.javaspringbootcore1;

import com.javaspringbootcore1.model.Student;
import com.javaspringbootcore1.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Student student = new Student(2L, "AAA_BBB", "aaabbbccc@example.com", 29);
        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent(student);
//        studentRepository.updateStudent(student, 7L);
//        studentRepository.deleteStudent(4l);
//        studentRepository.getStudent(2L);
        studentRepository.completeCrud(student, 2L);
    }

}