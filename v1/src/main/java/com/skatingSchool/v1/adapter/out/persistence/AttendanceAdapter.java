package com.skatingSchool.v1.adapter.out.persistence;

import com.skatingSchool.v1.domain.model.Attendance;
import com.skatingSchool.v1.domain.port.CreateAttendancePort;
import com.skatingSchool.v1.domain.port.FindAttendancePort;
import com.skatingSchool.v1.infraestructure.persistence.entities.AttendanceEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.AttendanceMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceAdapter implements CreateAttendancePort, FindAttendancePort {

    private final AttendanceRepository attendanceRepository;

    public AttendanceAdapter(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public void save(Attendance attendance) {
        AttendanceEntity entity = AttendanceMapper.toEntity(attendance);
        attendanceRepository.save(entity);
    }

    @Override
    public Attendance findById(Long attendanceId) {
        return attendanceRepository.findById(attendanceId)
                .map(AttendanceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Attendance> findByClassId(Long classId) {
        return attendanceRepository.findByClassSession_ClassId(classId)
                .stream()
                .map(AttendanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendance> findByStudentId(Long studentId) {
        return attendanceRepository.findByStudent_StudentId(studentId)
                .stream()
                .map(AttendanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendance> findByDate(LocalDate date) {
        return attendanceRepository
                .findByAttendanceDate(date)
                .stream()
                .map(AttendanceMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Attendance> findByClassIdAndDate(Long classId, LocalDate date) {
        return attendanceRepository
                .findByClassSession_ClassIdAndAttendanceDate(classId, date)
                .stream()
                .map(AttendanceMapper::toDomain)
                .collect(Collectors.toList());
    }
}