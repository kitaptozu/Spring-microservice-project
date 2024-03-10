package com.kitaptozu.school.controller;

import com.kitaptozu.school.dto.RegisterSchoolReqDTO;
import com.kitaptozu.school.dto.SchoolResDTO;
import com.kitaptozu.school.dto.SchoolWithStudentsResDTO;
import com.kitaptozu.school.service.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody RegisterSchoolReqDTO reqDTO) {
        return schoolService.saveSchool(reqDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SchoolResDTO> findAllSchools() {
        return schoolService.findAllSchool();
    }

    @GetMapping("with-student/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolWithStudentsResDTO findSchoolWithStudents(@PathVariable("schoolId") Long schoolId) {
        return schoolService.findSchoolWithStudents(schoolId);
    }

}