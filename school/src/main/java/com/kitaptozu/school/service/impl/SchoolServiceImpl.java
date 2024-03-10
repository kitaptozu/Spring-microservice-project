package com.kitaptozu.school.service.impl;

import com.kitaptozu.school.client.StudentClient;
import com.kitaptozu.school.dto.RegisterSchoolReqDTO;
import com.kitaptozu.school.dto.SchoolResDTO;
import com.kitaptozu.school.dto.SchoolWithStudentsResDTO;
import com.kitaptozu.school.entity.SchoolEntity;
import com.kitaptozu.school.repository.SchoolRepository;
import com.kitaptozu.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    @Override
    public Long saveSchool(RegisterSchoolReqDTO reqDTO) {
        SchoolEntity newSchool = SchoolEntity.builder()
                .name(reqDTO.getName())
                .email(reqDTO.getEmail())
                .build();

        return schoolRepository.save(newSchool).getSchoolId();
    }

    @Override
    public List<SchoolResDTO> findAllSchool() {
        return schoolRepository.findAll().stream()
                .map(schoolEntity -> SchoolResDTO.builder()
                        .schoolId(schoolEntity.getSchoolId())
                        .name(schoolEntity.getName())
                        .email(schoolEntity.getEmail())
                        .build()
                ).collect(Collectors.toList());
    }

    @Override
    public SchoolWithStudentsResDTO findSchoolWithStudents(Long schoolId) {

        SchoolEntity schoolEntity = schoolRepository.findById(schoolId).orElseThrow(() -> new RuntimeException("School not found!"));

        return SchoolWithStudentsResDTO.builder()
                .schoolId(schoolEntity.getSchoolId())
                .name(schoolEntity.getName())
                .email(schoolEntity.getEmail())
                .studentList(studentClient.findAllStudentsBySchoolId(schoolId))
                .build();

    }

}