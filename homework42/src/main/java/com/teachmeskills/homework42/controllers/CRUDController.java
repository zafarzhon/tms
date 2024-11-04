package com.teachmeskills.homework42.controllers;

import com.teachmeskills.homework42.dao.Student;
import com.teachmeskills.homework42.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class CRUDController {
    private final StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @GetMapping("/class/{classNumber}")
    public List<Student> getByClassNumber(@PathVariable int classNumber) {
        return studentService.getByClassNumber(classNumber);
    }
}
