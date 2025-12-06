package com.skatingSchool.v1.domain.service;

import com.skatingSchool.v1.domain.model.User;
import com.skatingSchool.v1.domain.model.Student;
import com.skatingSchool.v1.domain.model.Instructor;
import com.skatingSchool.v1.domain.model.auth.AuthCredentials;
import com.skatingSchool.v1.domain.model.auth.TokenResponse;
import com.skatingSchool.v1.domain.port.AuthenticationPort;
import com.skatingSchool.v1.domain.port.FindUserPort;
import com.skatingSchool.v1.domain.port.FindStudentPort;
import com.skatingSchool.v1.domain.port.FindInstructorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationPort authenticationPort;

    @Autowired
    private FindUserPort userPort;

    @Autowired
    private FindStudentPort studentPort;

    @Autowired
    private FindInstructorPort instructorPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {

    // Buscar el usuario por username
    User user = userPort.findUserByUsername(credentials.getUsername());
    if (user == null) {
        throw new Exception("Usuario no encontrado");
    }

    // Verificar contraseña
    if (!passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
        throw new Exception("Contraseña incorrecta");
    }

    Long finalId;

    // Determinar el ID dependiendo del rol
    switch (user.getRol()) {

        case STUDENT:
            Student student = studentPort.findByUserId(user.getUserid());
            if (student == null) {
                throw new Exception("No se encontró un Student asociado al usuario");
            }
            finalId = student.getStudentId();
            break;

        case INSTRUCTOR:
            Instructor instructor = instructorPort.findByUserId(user.getUserid());
            if (instructor == null) {
                throw new Exception("No se encontró un Instructor asociado al usuario");
            }
            finalId = instructor.getInstructorId();
            break;

        default:
            // Admin, secretaria, etc.
            finalId = user.getUserid();
            break;
    }

    // Generar token usando AuthenticationPort
    return authenticationPort.authenticate(
            credentials,
            user.getRol().name(),
            finalId
    );
}
}