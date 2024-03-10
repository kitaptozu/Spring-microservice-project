package com.kitaptozu.student.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResDTO {

    private Long studentId;
    private String firstname;
    private String lastname;
    private String email;
    private Long schoolId;

}