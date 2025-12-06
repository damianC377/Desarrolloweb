package com.skatingSchool.v1.application.usecases;

import com.skatingSchool.v1.domain.service.CreateStudentService;
import com.skatingSchool.v1.domain.service.CreateUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.enums.Rol;



/**
 * Caso de uso para gestión de usuarios.
 * Combina las operaciones de autenticación, registro y gestión de usuarios.
 */
@Service
public class UserUseCase {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private CreateStudentService createStudentService;



    public Long createUserStudent(User user) throws Exception {
    user.setRol(Rol.STUDENT);
    User createdUser = createUserService.createUser(user);
    
    Student student = new Student();
    student.setUserId(createdUser.getUserid());
    
    // Modificar CreateStudentService para que DEVUELVA el estudiante creado
    Student createdStudent = createStudentService.createStudent(student);
    
    // Usa el estudiante que YA TE DEVOLVIÓ el servicio, no lo busques
    return createdStudent.getStudentId();
}

}
