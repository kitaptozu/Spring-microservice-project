package com.kitaptozu.student.dto;

import lombok.Data;

@Data
public class RegisterStudentReqDTO {

    private String firstname;
    private String lastname;
    private String email;
    private Long schoolId;

}