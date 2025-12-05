package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {

    List<ClassEntity> findByInstructorId(Long instructorId);

    List<ClassEntity> findBySchedule(LocalDateTime schedule);
}
