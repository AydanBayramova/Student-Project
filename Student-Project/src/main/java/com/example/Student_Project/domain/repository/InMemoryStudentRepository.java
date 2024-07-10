package com.example.Student_Project.domain.repository;

import com.example.Student_Project.domain.entity.StudentEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryStudentRepository implements StudentRepository {

    private List<StudentEntity> students = new ArrayList<>();

//  @PostConstruct
//    public void init() {
//        students.addAll(List.of(
//                new StudentEntity(1L, "Selen", 22, true, LocalDateTime.now(), null, null),
//                new StudentEntity(2L, "Vusal", 21, null, LocalDateTime.now(), null, null),
//                new StudentEntity(3L, "Beshir", 18, null, LocalDateTime.now(), null, null)
//        ));
//    }

    @Override
    public StudentEntity save(StudentEntity student) {
        students.add(student);
        return student;
    }

    @Override
    public List<StudentEntity> findAll() {
        return students;
    }

    @Override
    public Optional<StudentEntity> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        Iterator<StudentEntity> iterator = students.iterator();
        while (iterator.hasNext()) {
            StudentEntity student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Id not found " + id);
    }
}
