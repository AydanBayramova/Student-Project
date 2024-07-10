package com.example.Student_Project.service;

import com.example.Student_Project.domain.entity.StudentEntity;
import com.example.Student_Project.exception.StudentNotFoundException;
import com.example.Student_Project.model.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto student);

    List<StudentDto> findAll();

    StudentDto findById(Long id) throws StudentNotFoundException;

    void deleteById(Long id) throws StudentNotFoundException;

    StudentDto update(Long id, StudentDto studentDto);

    StudentDto partialUpdate(Long id, StudentDto studentDto);
}

