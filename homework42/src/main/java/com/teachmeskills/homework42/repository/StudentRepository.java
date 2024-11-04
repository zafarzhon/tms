package com.teachmeskills.homework42.repository;

import com.teachmeskills.homework42.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByClassNumber(int classNumber);
}
