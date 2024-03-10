package com.kitaptozu.school.repository;

import com.kitaptozu.school.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

}