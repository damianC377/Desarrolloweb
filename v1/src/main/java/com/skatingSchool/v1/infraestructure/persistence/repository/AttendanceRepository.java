package com.skatingSchool.v1.infraestructure.persistence.repository;

import com.skatingSchool.v1.infraestructure.persistence.entities.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {

    // Busca todas las asistencias de una clase específica
    List<AttendanceEntity> findByClassSession_ClassId(Long classId);

    // Busca todas las asistencias de un estudiante específico
    List<AttendanceEntity> findByStudent_StudentId(Long studentId);

    // Buscar asistencia por clase y fecha exacta
    List<AttendanceEntity> findByClassSession_ClassIdAndAttendanceDate(Long classId, java.time.LocalDate date);
}
