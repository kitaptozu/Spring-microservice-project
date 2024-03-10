package com.kitaptozu.student.service;

import com.kitaptozu.student.dto.RegisterStudentReqDTO;
import com.kitaptozu.student.dto.StudentResDTO;

import java.util.List;

public interface StudentService {

    Long saveStudent(RegisterStudentReqDTO reqDTO);

    List<StudentResDTO> findAllStudents();

    List<StudentResDTO> findAllStudentsBySchoolId(Long schoolId);

}