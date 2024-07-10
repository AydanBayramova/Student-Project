package com.example.Student_Project.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    private Long id;
    private String name;
    private Integer age;
    private Boolean gender;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Float grade;


}
