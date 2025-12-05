package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    StudentEntity findByStudentId(Long studentId);

    StudentEntity findByUserId(Long userId);

    StudentEntity findByStudentIdAndActive(Long studentId, Boolean active);
}
