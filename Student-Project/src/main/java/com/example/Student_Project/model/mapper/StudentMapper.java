package com.example.Student_Project.model.mapper;

import com.example.Student_Project.domain.entity.StudentEntity;
import com.example.Student_Project.model.dto.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentEntity studentToEntity(StudentDto studentDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(studentDto.getId());
        studentEntity.setName(studentDto.getName());
        studentEntity.setAge(studentDto.getAge());
        studentEntity.setGender(studentDto.getGender());
        studentEntity.setCreateDate(studentDto.getCreateDate());
        studentEntity.setUpdateDate(studentDto.getUpdateDate());
        studentEntity.setGrade(studentDto.getGrade());
        return studentEntity;
    }
    public StudentDto entityToDto(StudentEntity studentEntity) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(studentEntity.getId());
        studentDto.setName(studentEntity.getName());
        studentDto.setAge(studentEntity.getAge());
        studentDto.setGender(studentEntity.getGender());
        studentDto.setCreateDate(studentEntity.getCreateDate());
        studentDto.setUpdateDate(studentEntity.getUpdateDate());
        studentDto.setGrade(studentEntity.getGrade());
        return studentDto;
    }
}
