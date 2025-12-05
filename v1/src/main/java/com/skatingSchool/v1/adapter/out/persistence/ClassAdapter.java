package com.skatingSchool.v1.adapter.out.persistence;

import com.skatingSchool.v1.domain.model.Class;
import com.skatingSchool.v1.domain.port.CreateClassPort;
import com.skatingSchool.v1.domain.port.FindClassPort;
import com.skatingSchool.v1.infraestructure.persistence.entities.ClassEntity;
import com.skatingSchool.v1.infraestructure.persistence.mapper.ClassMapper;
import com.skatingSchool.v1.infraestructure.persistence.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassAdapter implements CreateClassPort, FindClassPort {

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
        List<ClassEntity> entities = classRepository.findByInstructorId(instructorId);
        return entities.stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Class> findBySchedule(LocalDateTime schedule) {
        List<ClassEntity> entities = classRepository.findBySchedule(schedule);
        return entities.stream()
                .map(ClassMapper::toDomain)
                .collect(Collectors.toList());
    }
}
