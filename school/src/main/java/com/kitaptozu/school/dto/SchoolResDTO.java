package com.kitaptozu.school.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolResDTO {

    private Long schoolId;
    private String name;
    private String email;

}