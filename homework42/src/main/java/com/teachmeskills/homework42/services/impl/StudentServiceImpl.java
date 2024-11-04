package com.teachmeskills.homework42.services.impl;

import com.teachmeskills.homework42.dao.Student;
import com.teachmeskills.homework42.repository.StudentRepository;
import com.teachmeskills.homework42.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudentById(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<Student> getByClassNumber(int classNumber) {
        return repository.findByClassNumber(classNumber);
    }
}
