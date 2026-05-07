package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<StudentEntity> findByStudentId(Long studentId);

    Optional<StudentEntity> findByUserId(Long userId);

    Optional<StudentEntity> findByStudentIdAndActive(Long studentId, Boolean active);
}