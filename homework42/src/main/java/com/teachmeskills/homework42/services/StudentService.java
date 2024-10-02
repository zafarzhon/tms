package com.teachmeskills.homework42.services;

import com.teachmeskills.homework42.dao.Student;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student save(Student student);

    Student update(Student student);

    void deleteStudentById(int id);

    List<Student> getByClassNumber(int classNumber);
}
