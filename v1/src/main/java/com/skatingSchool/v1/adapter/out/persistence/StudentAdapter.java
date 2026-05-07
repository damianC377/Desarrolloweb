package com.skatingSchool.v1.adapter.out.persistence;

import java.util.stream.Collectors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.port.CreateStudentPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import com.skatingSchool.v1.infraestructure.persistence.entities.StudentEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.StudentMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.ClassRepository;
import com.skatingSchool.v1.infraestructure.persistence.repository.StudentRepository;

@Service
@Primary
public class StudentAdapter implements CreateStudentPort, FindStudentPort {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public Student save(Student student) {
        StudentEntity entity = studentRepository.save(StudentMapper.toEntity(student));
        return StudentMapper.toDomain(entity);
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findByStudentId(studentId)
                .map(StudentMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Student findByUserId(Long userId) {
        return studentRepository.findByUserId(userId)
                .map(StudentMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Student findActiveStudent(Long studentId) {
        return studentRepository.findByStudentIdAndActive(studentId, true)
                .map(StudentMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Student> findAll() {
        List<StudentEntity> entities = studentRepository.findAll();
        return entities.stream()
                .map(StudentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByClassId(Long classId) {
        ClassEntity classEntity = classRepository.findByClassId(classId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        return classEntity.getStudents()
                .stream()
                .map(StudentMapper::toDomain)
                .collect(Collectors.toList());
    }
}