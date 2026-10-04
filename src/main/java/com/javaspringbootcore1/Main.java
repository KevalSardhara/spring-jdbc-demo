package com.javaspringbootcore1;

import com.javaspringbootcore1.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        StudentRepository studentRepository = new StudentRepository();
//        studentRepository.createStudent();
//        studentRepository.updateStudent();
//        studentRepository.deleteStudent();
//        studentRepository.getStudent();
        studentRepository.completeCrud();
    }

}