package com.kitaptozu.school.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SchoolWithStudentsResDTO {

    private Long schoolId;
    private String name;
    private String email;
    private List<StudentResDTO> studentList;

}