package com.example.Student_Project.controller;

import com.example.Student_Project.exception.StudentNotFoundException;
import com.example.Student_Project.model.dto.StudentDto;
import com.example.Student_Project.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        log.info("Get all students:\"GET -> /api/v1/students\"");
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) throws StudentNotFoundException {
        log.info("Get student by id:\"{}\"", id);
        return studentService.findById(id);
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto studentDto) {
        log.info("Create student:\"{}\"", studentDto);
        return studentService.save(studentDto);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) throws StudentNotFoundException {
        log.info("Delete student by id:\"{}\"", id);
        studentService.deleteById(id);
    }
    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) throws StudentNotFoundException {
        log.info("Update student with id:\"{}\"", id);
        return studentService.update(id, studentDto);
    }

    @PatchMapping("/{id}")
    public StudentDto partialUpdateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) throws StudentNotFoundException {
        log.info("Partially update student with id:\"{}\"", id);
        return studentService.partialUpdate(id, studentDto);
    }

}
