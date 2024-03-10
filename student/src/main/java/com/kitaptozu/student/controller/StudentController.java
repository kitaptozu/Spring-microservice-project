package com.kitaptozu.student.controller;

import com.kitaptozu.student.dto.RegisterStudentReqDTO;
import com.kitaptozu.student.dto.StudentResDTO;
import com.kitaptozu.student.service.StudentService;
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
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody RegisterStudentReqDTO reqDTO) {
        return studentService.saveStudent(reqDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResDTO> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("school/{schoolId}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResDTO> findAllStudentsBySchoolId(@PathVariable("schoolId") Long schoolId) {
        return studentService.findAllStudentsBySchoolId(schoolId);
    }

}