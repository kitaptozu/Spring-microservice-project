package com.kitaptozu.student.service.impl;

import com.kitaptozu.student.dto.RegisterStudentReqDTO;
import com.kitaptozu.student.dto.StudentResDTO;
import com.kitaptozu.student.entity.StudentEntity;
import com.kitaptozu.student.repository.StudentRepository;
import com.kitaptozu.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Long saveStudent(RegisterStudentReqDTO reqDTO) {
        StudentEntity newStudent = StudentEntity.builder()
                .firstname(reqDTO.getFirstname())
                .lastname(reqDTO.getLastname())
                .email(reqDTO.getEmail())
                .schoolId(reqDTO.getSchoolId())
                .build();

        return studentRepository.save(newStudent).getStudentId();
    }

    @Override
    public List<StudentResDTO> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentEntity -> StudentResDTO.builder()
                        .studentId(studentEntity.getStudentId())
                        .firstname(studentEntity.getFirstname())
                        .lastname(studentEntity.getLastname())
                        .email(studentEntity.getEmail())
                        .schoolId(studentEntity.getSchoolId())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public List<StudentResDTO> findAllStudentsBySchoolId(Long schoolId) {
        return studentRepository.findAllBySchoolId(schoolId).stream()
                .map(studentEntity -> StudentResDTO.builder()
                        .studentId(studentEntity.getStudentId())
                        .firstname(studentEntity.getFirstname())
                        .lastname(studentEntity.getLastname())
                        .email(studentEntity.getEmail())
                        .schoolId(studentEntity.getSchoolId())
                        .build()
                ).collect(Collectors.toList());
    }

}