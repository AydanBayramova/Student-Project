package com.example.Student_Project.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;
    private Boolean gender;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Float grade;

}
