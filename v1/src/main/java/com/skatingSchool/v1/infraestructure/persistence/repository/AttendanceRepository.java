package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

    List<AttendanceEntity> findByClassSession_ClassId(Long classId);

    List<AttendanceEntity> findByStudent_StudentId(Long studentId);

    List<AttendanceEntity> findByClassSession_ClassIdAndAttendanceDate(Long classId, LocalDate date);

    List<AttendanceEntity> findByAttendanceDate(LocalDate date);
}