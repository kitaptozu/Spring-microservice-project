package com.kitaptozu.school.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResDTO {

    private Long studentId;
    private String firstname;
    private String lastname;
    private String email;

}