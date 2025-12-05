package com.skatingSchool.v1.adapter.in.validator;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends SimpleValidator {

    public Long documentValidator(String document) throws Exception {
        return longValidator("Documento de la persona: ", document);
    }

    public String nameValidator(String name) throws Exception {
        return stringValidator("Nombre completo de la persona: ", name);
    }

    public String lastnameValidator(String lastname) throws Exception {
        return stringValidator("Apellido completo de la persona: ", lastname);
    }   

    public String emailValidator(String email) throws Exception {
        return stringValidator("Correo electronico de la persona: ", email);
    }

    public String phoneValidator(String phone) throws Exception {
        return stringValidator("Telefono de la persona: ", phone.trim());
    }

    public String addressValidator(String address) throws Exception {
        return stringValidator("Direccion de la persona: ", address);
    }

    public String usernameValidator(String username) throws Exception {
        return stringValidator("Nombre de usuario de la persona: ", username);
    }

    public String passwordValidator(String password) throws Exception {
        return stringValidator("Contrasena de la persona: ", password); 
    }

    public String rolValidator(String rol) throws Exception {
        return stringValidator("Rol de la persona: ", rol);
    }

}