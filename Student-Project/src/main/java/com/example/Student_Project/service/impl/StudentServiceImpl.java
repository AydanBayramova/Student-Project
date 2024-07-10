package com.example.Student_Project.service.impl;

import com.example.Student_Project.domain.entity.StudentEntity;
import com.example.Student_Project.domain.repository.StudentRepository;
import com.example.Student_Project.exception.StudentNotFoundException;
import com.example.Student_Project.model.dto.StudentDto;
import com.example.Student_Project.model.mapper.StudentMapper;
import com.example.Student_Project.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public StudentDto save(StudentDto student) {
        StudentEntity studentEntity = studentMapper.studentToEntity(student);
            studentEntity = studentRepository.save(studentEntity);
            return studentMapper.entityToDto(studentEntity);

    }


    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto findById(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .map(studentMapper::entityToDto)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
        }else {
            throw new RuntimeException();
        }

    }
    @Override
    public StudentDto update(Long id, StudentDto studentDto) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();
            studentEntity.setName(studentDto.getName());
            studentEntity.setAge(studentDto.getAge());
            studentEntity.setGender(studentDto.getGender());
            studentEntity.setGrade(studentDto.getGrade());
            studentEntity.setUpdateDate(LocalDateTime.now());

            return save(studentMapper.entityToDto(studentEntity));
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public StudentDto partialUpdate(Long id, StudentDto studentDto) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()) {
            StudentEntity studentEntity = optionalStudentEntity.get();

            if (studentDto.getName() != null) {
                studentEntity.setName(studentDto.getName());
            }
            if (studentDto.getAge() != null) {
                studentEntity.setAge(studentDto.getAge());
            }
            if (studentDto.getGender() != null) {
                studentEntity.setGender(studentDto.getGender());
            }
            studentEntity.setUpdateDate(LocalDateTime.now());

            return save(studentMapper.entityToDto(studentEntity));
        } else {
            throw new RuntimeException();
        }
    }


}

