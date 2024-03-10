package com.kitaptozu.school.service;

import com.kitaptozu.school.dto.RegisterSchoolReqDTO;
import com.kitaptozu.school.dto.SchoolResDTO;
import com.kitaptozu.school.dto.SchoolWithStudentsResDTO;

import java.util.List;

public interface SchoolService {

    Long saveSchool(RegisterSchoolReqDTO reqDTO);

    List<SchoolResDTO> findAllSchool();

    SchoolWithStudentsResDTO findSchoolWithStudents(Long schoolId);

}