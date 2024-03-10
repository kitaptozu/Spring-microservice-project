package com.kitaptozu.student.repository;

import com.kitaptozu.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllBySchoolId(Long schoolId);

}