package com.example.Student_Project.domain.repository;

import com.example.Student_Project.domain.entity.StudentEntity;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    StudentEntity save(StudentEntity student);

    List<StudentEntity> findAll();

    Optional<StudentEntity> findById(Long id);

    void deleteById(Long id);
}
