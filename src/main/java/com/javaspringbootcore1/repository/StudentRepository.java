package com.javaspringbootcore1.repository;

import com.javaspringbootcore1.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private String dbUrl = "jdbc:postgresql://localhost:5432/student_db";
    private String dbUser = "kevalsardhara";
    private String dbPassword = "123456";
    private String dbDriver = "org.postgresql.Driver";
    private Connection connection = null;
    private Statement statement = null;

    public void createStudent() throws Exception {
        try {
            // --------------------------------------------------- //
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            if (connection == null || statement == null) {
                throw new SQLException("Connection failed ERROR throws!");
            }
            System.out.println("Connection established successfully");
            // --------------------------------------------------- //

            String sql = "INSERT INTO students (id, name, email, age) VALUES (3, 'abc def', 'abc@gov.ac.com', 29)";

            int result = statement.executeUpdate(sql); // CREATE, INSERT, DELETE

            if (result > 0) {
                System.out.println("Student created successfully");
            } else {
                System.out.println("Failed to create student");
            }

            // --------------------------------------------------- //
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void updateStudent() throws Exception {
        try {
            // --------------------------------------------------- //
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            if (connection == null || statement == null) {
                throw new SQLException("Connection failed ERROR throws!");
            }
            System.out.println("Connection established successfully");
            // --------------------------------------------------- //

            String sql = "UPDATE students SET name = 'Keval Sardhara', email = 'keval.sardhara@ac.com', age = 25 WHERE id = 1";

            int result = statement.executeUpdate(sql); // CREATE, INSERT, DELETE

            if (result > 0) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Failed to updated student");
            }

            // --------------------------------------------------- //
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void deleteStudent() throws Exception {
        try {
            // --------------------------------------------------- //
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            if (connection == null || statement == null) {
                throw new SQLException("Connection failed ERROR throws!");
            }
            System.out.println("Connection established successfully");
            // --------------------------------------------------- //

            String sql = "DELETE FROM students WHERE id = 1";

            int result = statement.executeUpdate(sql); // CREATE, INSERT, DELETE

            if (result > 0) {
                System.out.println("Student deleted successfully");
            } else {
                System.out.println("Failed to delete student");
            }

            // --------------------------------------------------- //
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void getStudent() throws Exception {
        try {
            // --------------------------------------------------- //
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            if (connection == null || statement == null) {
                throw new SQLException("Connection failed ERROR throws!");
            }
            System.out.println("Connection established successfully");
            // --------------------------------------------------- //

//            String sql = "SELECT * FROM students WHERE id = 1";
            String sql = "SELECT * FROM students";

            ResultSet result = statement.executeQuery(sql); // SELECT, READ

            List<String> studentList = new ArrayList<>();

            while (result.next()) {
                Student student = mapToStudent(result);
                String studentToString = student.toString();
                studentList.add(studentToString);
            }

            System.out.println("StudentList : " + studentList);
            // --------------------------------------------------- //
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection");
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void completeCrud() throws Exception {
        try {
            // --------------------------------------------------- //
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            statement = connection.createStatement();
            if (connection == null || statement == null) {
                throw new SQLException("Connection failed ERROR throws!");
            }
            System.out.println("Connection established successfully");
            // --------------------------------------------------- //

            String sql = "INSERT INTO students (id, name, email, age) VALUES (6, 'John Doe1', 'john5.doe6@example.com', 29)";

//            String sql = "SELECT * FROM students";

//            String sql = "UPDATE students SET name = 'John Doe1' WHERE id = 1";

//            String sql = "DELETE FROM students WHERE id = 1";

            boolean result = statement.execute(sql); // SELECT, READ

            if (result) {
                ResultSet resultSet = statement.getResultSet();

                if (resultSet == null) {
                    throw new SQLException("Result set is null");
                }
                List<String> studentList = new ArrayList<>();
                System.out.println("---------------------------------");
                while (resultSet.next()) {
                    Student student = mapToStudent(resultSet);
                    String studentToString = student.toString();
                    studentList.add(studentToString);
                    System.out.println(student);
                }
                System.out.println("---------------------------------");

                System.out.println("StudentList : " + studentList);
            } else {
                int rowsAffected = statement.getUpdateCount();

                if(rowsAffected == 0) {
                    throw new SQLException("Failed to insert student");
                } else {
                    System.out.println("Student inserted successfully");
                }

            }




            // --------------------------------------------------- //
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    private Student mapToStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
