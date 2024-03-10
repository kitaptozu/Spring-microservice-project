package com.kitaptozu.school.client;

import com.kitaptozu.school.dto.StudentResDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("api/v1/students/school/{schoolId}")
    List<StudentResDTO> findAllStudentsBySchoolId(@PathVariable("schoolId") Long schoolId);

}