package com.skatingSchool.v1.adapter.out.persistence;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateClassPort;
import com.skatingSchool.v1.domain.port.FindClassPort;
import com.skatingSchool.v1.domain.port.EnrollStudentPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.ClassMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.ClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class ClassAdapter implements CreateClassPort, FindClassPort, EnrollStudentPort {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public void save(Class skatingClass) {
        ClassEntity entity = ClassMapper.toEntity(skatingClass);
        classRepository.save(entity);
    }

    @Override
    public Class findById(Long classId) {
        return classRepository.findById(classId)
                .map(ClassMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Class> findByInstructorId(Long instructorId) {
        List<ClassEntity> entities =
                classRepository.findByInstructor_InstructorId(instructorId);

        return entities.stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Class> findBySchedule(LocalDateTime schedule) {
        List<ClassEntity> entities =
                classRepository.findBySchedule(schedule);

        return entities.stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Class> findAllClasses() {
        return classRepository.findAll()
                .stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Class> findClassesWithAvailableSpots() {
        List<ClassEntity> entities = classRepository.findAll();

        return entities.stream()
                .filter(entity -> entity.getStudents() == null || entity.getStudents().size() < 20)
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void enrollStudent(Long classId, Student student) {
        ClassEntity classEntity = classRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentId(student.getStudentId());
        studentEntity.setUserId(student.getUserId());
        studentEntity.setActive(student.getActive());

        if (classEntity.getStudents() == null) {
            classEntity.setStudents(new ArrayList<>());
        }

        classEntity.getStudents().add(studentEntity);
        classRepository.save(classEntity);
    }

    @Override
    public boolean isStudentEnrolled(Long classId, Long studentId) {
        return classRepository.findById(classId)
                .map(entity -> entity.getStudents() != null &&
                        entity.getStudents().stream()
                                .anyMatch(s -> s.getStudentId().equals(studentId)))
                .orElse(false);
    }


    @Override
    public List<Class> findByStudentId(Long studentId) {
        List<ClassEntity> entities = classRepository.findByStudents_StudentId(studentId);
        return entities.stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }
}