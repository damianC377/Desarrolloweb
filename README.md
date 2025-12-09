# Desarrolloweb

# Integrantes
Manuela Bolivar
Juan Esteban Martinez
Damian Cardenas

# API Rolling Skate
## 📋 Tabla de Contenidos

## Descripción General
Arquitectura del Sistema
Tecnologías Utilizadas
Modelo de Datos
Endpoints de la API
Flujo de Ejecución del Código
Seguridad y Autenticación
Despliegue


## 🎯 Descripción General
Rolling Skate es una aplicación web para la gestión integral de una escuela de patinaje. Permite administrar usuarios, estudiantes, instructores, clases, pagos y asistencias.
Características principales:

✅ Sistema de autenticación con JWT
✅ Gestión de roles (Admin, Instructor, Estudiante)
✅ CRUD completo para todas las entidades
✅ Sistema de pagos mensuales
✅ Control de asistencia a clases
✅ Frontend React + Backend Spring Boot
✅ Base de datos MySQL


## 🏗️ Arquitectura del Sistema
La aplicación sigue una Arquitectura Hexagonal (Puertos y Adaptadores) con Clean Architecture:
graph TD
    A[CAPA DE PRESENTACIÓN<br/>Controllers REST API] --> B[CAPA DE APLICACIÓN<br/>Use Cases]
    B --> C[CAPA DE DOMINIO<br/>Modelos, Services y Ports]
    C --> D[CAPA DE INFRAESTRUCTURA<br/>Adapters y Repositories]
    D --> E[MySQL Database]
    
    style A fill:#e1f5ff
    style B fill:#fff4e1
    style C fill:#ffe1f5
    style D fill:#e1ffe1
    style E fill:#f0f0f0
    # Arquitectura del Sistema

La aplicación sigue una **Arquitectura Hexagonal** (Puertos y Adaptadores) con **Clean Architecture**.

---

## 📋 Estructura por Capas

### 🎯 Capa de Presentación
> Controllers (REST API)

- `UserController`
- `AuthController`
- `StudentController`
- `PaymentController`
- `AdministrativeController`

**↓**

### 📦 Capa de Aplicación
> Use Cases

- `UserUseCase`
- `LoginUseCase`
- `StudentUseCase`
- `PaymentUseCase`
- `AdministrativeUseCase`

**↓**

### 💎 Capa de Dominio

#### Modelos
- `User`
- `Student`
- `Instructor`
- `Payment`
- `Class`
- `Attendance`

#### Services
- `CreateUserService`
- `FindUserService`
- `AuthService`
- `CreateStudentService`

#### Ports (Interfaces)
- `CreateUserPort`, `FindUserPort`
- `AuthenticationPort`
- `CreateStudentPort`, `FindStudentPort`

**↓**

### 🔧 Capa de Infraestructura

#### Adapters (Implementaciones)
- `UserAdapter`
- `StudentAdapter`
- `JwtAdapter`
- `PaymentAdapter`

#### Entities JPA
- `UserEntity`
- `StudentEntity`
- `InstructorEntity`

#### Repositories
- `UserRepository`
- `StudentRepository`

**↓**

### 🗄️ Base de Datos
- **MySQL**

---

## 🔄 Flujo de Datos

```
HTTP Request
    ↓
Controllers (Presentación)
    ↓
Use Cases (Aplicación)
    ↓
Domain Services (Dominio)
    ↓
Ports/Interfaces (Dominio)
    ↓
Adapters (Infraestructura)
    ↓
Repositories (Infraestructura)
    ↓
MySQL Database
```

---

## ✨ Principios de Diseño

| Principio | Descripción |
|-----------|-------------|
| **Arquitectura Hexagonal** | Separación clara entre lógica de negocio e infraestructura |
| **Clean Architecture** | Las dependencias apuntan hacia el dominio |
| **Inversión de Dependencias** | Las capas externas dependen de las internas |
| **Puertos y Adaptadores** | Interfaces definidas en dominio, implementadas en infraestructura |

---

## 📝 Notas

- La capa de **Dominio** es independiente de frameworks y librerías externas
- Los **Ports** actúan como contratos que la infraestructura debe cumplir
- Los **Adapters** conectan el dominio con tecnologías específicas (JPA, JWT, etc.)
- El flujo de datos siempre va de afuera hacia adentro (hacia el dominio)

# 🛠️ Tecnologías Utilizadas
## Backend

Java 21
Spring Boot 4.0.0
Spring Security (JWT)
Spring Data JPA
MySQL (Base de datos)
Lombok (Reducción de boilerplate)
JJWT 0.11.5 (JSON Web Tokens)
Maven (Gestión de dependencias)

Frontend

React 18
Vite
React Router DOM
Lucide React (Iconos)
CSS Modules

Despliegue

Railway (Backend + Base de datos)
Railway (Frontend)
Docker (Containerización)


## 📊 Modelo de Datos
Diagrama Entidad-Relación
┌──────────────┐       ┌──────────────┐       ┌──────────────┐
│    USERS     │       │  INSTRUCTORS │       │   STUDENTS   │
├──────────────┤       ├──────────────┤       ├──────────────┤
│ userid (PK)  │◄──────│ id (PK)      │       │ studentId(PK)│
│ document     │       │ user_id (FK) │       │ userId (FK)  │
│ name         │       │ experience   │       │ active       │
│ lastname     │       └──────────────┘       └──────────────┘
│ email        │              │                      │
│ phone        │              │                      │
│ address      │              │                      │
│ username     │              ▼                      ▼
│ password     │       ┌──────────────┐       ┌──────────────┐
│ rol          │       │   CLASSES    │       │   PAYMENTS   │
└──────────────┘       ├──────────────┤       ├──────────────┤
                       │ classId (PK) │       │ id (PK)      │
                       │ className    │       │ studentId(FK)│
                       │ level        │       │ paymentDate  │
                       │ schedule     │       │ amount       │
                       │ instructor_id│       │ paymentMethod│
                       └──────────────┘       └──────────────┘
                              │
                              │ M:N
                              ▼
                       ┌──────────────┐
                       │CLASS_STUDENTS│
                       ├──────────────┤
                       │ class_id (FK)│
                       │ student_id FK│
                       └──────────────┘
                              │
                              ▼
                       ┌──────────────┐
                       │ ATTENDANCES  │
                       ├──────────────┤
                       │ attendanceId │
                       │ class_id (FK)│
                       │ student_id FK│
                       │ attendanceDate│
                       │ present      │
                       └──────────────┘
Entidades Principales
1. User (Usuario)
java- userid: Long (PK)
- document: Long (UNIQUE)
- name: String
- lastname: String
- email: String (UNIQUE)
- phone: String (UNIQUE)
- address: String
- username: String (UNIQUE)
- password: String (Encriptado con BCrypt)
- rol: Enum (ADMIN, INSTRUCTOR, STUDENT)
2. Student (Estudiante)
java- studentId: Long (PK)
- userId: Long (FK → User)
- active: Boolean (default: false)
3. Instructor
java- instructorId: Long (PK)
- userId: Long (FK → User, UNIQUE)
- experience: String
4. Payment (Pago)
java- paymentId: Long (PK)
- studentId: Long (FK → Student)
- paymentDate: LocalDate
- amount: Double
- paymentMethod: String
5. Class (Clase)
java- classId: Long (PK)
- className: String
- level: String
- schedule: LocalDateTime
- instructorId: Long (FK → Instructor)
- students: List<Student> (ManyToMany)
6. Attendance (Asistencia)
java- attendanceId: Long (PK)
- classSessionId: Long (FK → Class)
- studentId: Long (FK → Student)
- attendanceDate: LocalDate
- present: Boolean
```

---

## 🔗 Endpoints de la API

### Base URL
```
Producción: https://backend-desrrollo-production.up.railway.app
Local: http://localhost:8080

🔐 Autenticación
POST /api/auth/login
Inicia sesión y devuelve un JWT.
Request:
json{
  "username": "usuario123",
  "password": "contraseña"
}
Response:
json{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "id": 1  // studentId, instructorId o userId según el rol
}

👤 Usuarios
POST /api/v1/users/register-student
Registra un nuevo estudiante (crea User + Student).
Request:
json{
  "document": "1234567890",
  "name": "Juan",
  "lastname": "Pérez",
  "email": "juan@email.com",
  "phone": "+57 300 1234567",
  "address": "Calle 123",
  "username": "juanperez",
  "password": "password123"
}
Response:
json{
  "user": {
    "document": 1234567890,
    "name": "Juan",
    "lastname": "Pérez",
    "email": "juan@email.com",
    "phone": "+57 300 1234567",
    "address": "Calle 123",
    "username": "juanperez",
    "rol": "STUDENT"
  },
  "studentId": 1
}

🎓 Estudiantes
GET /api/v1/administrative/students
Obtiene todos los estudiantes.
Response:
json[
  {
    "studentId": 1,
    "active": false,
    "userId": 1,
    "user": {
      "document": 1234567890,
      "name": "Juan",
      "lastname": "Pérez",
      "email": "juan@email.com",
      "phone": "+57 300 1234567",
      "address": "Calle 123",
      "username": "juanperez",
      "rol": "STUDENT"
    }
  }
]

👨‍🏫 Instructores
POST /api/v1/administrative/instructors
Crea un nuevo instructor.
Request:
json{
  "userId": "1",
  "experience": "5 años enseñando patinaje"
}
Response:
json{
  "userId": 1,
  "experience": "5 años enseñando patinaje"
}

💳 Pagos
POST /api/v1/payments/register
Registra un nuevo pago.
Request:
json{
  "studentId": "1",
  "paymentDate": "2025-12-08",
  "amount": "150000",
  "paymentMethod": "credit_card"
}
Response:
json{
  "paymentId": 1,
  "studentId": 1,
  "paymentDate": "2025-12-08",
  "amount": 150000.0,
  "paymentMethod": "credit_card"
}
```

---

## 🔄 Flujo de Ejecución del Código

### **Flujo 1: Registro de Usuario y Estudiante**
```
┌─────────────┐
│   Cliente   │
│  (React)    │
└──────┬──────┘
       │ POST /api/v1/users/register-student
       │ { document, name, email, username, password ... }
       ▼
┌──────────────────────────────────────────────────────┐
│           UserController                             │
│  @PostMapping("/register-student")                   │
└──────┬───────────────────────────────────────────────┘
       │ 1. UserRestMapper.toDomain(request)
       │    → Convierte UserRequest a User
       │ 2. UserUseCase.createUserStudent(user)
       ▼
┌──────────────────────────────────────────────────────┐
│           UserUseCase                                │
│  - user.setRol(Rol.STUDENT)                         │
│  - CreateUserService.createUser(user)                │
│  - CreateStudentService.createStudent(student)       │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      CreateUserService                               │
│  1. Valida si existe (documento, email, username)    │
│  2. Encripta contraseña (BCrypt)                     │
│  3. UserAdapter.save(user)                           │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      UserAdapter                                     │
│  - UserMapper.toEntity(user)                         │
│  - UserRepository.save(entity)                       │
│  - UserMapper.toDomain(savedEntity)                  │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      MySQL Database                                  │
│  INSERT INTO users (document, name, email...)        │
└──────┬───────────────────────────────────────────────┘
       │ Retorna User con userid generado
       ▼
┌──────────────────────────────────────────────────────┐
│      CreateStudentService                            │
│  1. student.setUserId(user.getUserid())              │
│  2. Valida que userId no tenga estudiante            │
│  3. StudentAdapter.save(student)                     │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      StudentAdapter                                  │
│  - StudentMapper.toEntity(student)                   │
│  - StudentRepository.save(entity)                    │
│  - StudentMapper.toDomain(savedEntity)               │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      MySQL Database                                  │
│  INSERT INTO students (user_id, active)              │
└──────┬───────────────────────────────────────────────┘
       │ Retorna Student con studentId generado
       ▼
       UserController devuelve:
       { user: {...}, studentId: 1 }
```

---

### **Flujo 2: Login y Generación de JWT**
```
┌─────────────┐
│   Cliente   │
└──────┬──────┘
       │ POST /api/auth/login
       │ { username, password }
       ▼
┌──────────────────────────────────────────────────────┐
│           AuthController                             │
└──────┬───────────────────────────────────────────────┘
       │ 1. AuthRestMapper.toDomain(request)
       │    → AuthCredentials
       │ 2. LoginUseCase.login(credentials)
       ▼
┌──────────────────────────────────────────────────────┐
│      AuthenticationService                           │
│  1. FindUserPort.findUserByUsername(username)        │
│  2. PasswordEncoder.matches(password, hash)          │
│  3. Identifica el ROL del usuario                    │
│  4. Busca ID específico:                             │
│     - STUDENT → FindStudentPort.findByUserId()       │
│     - INSTRUCTOR → FindInstructorPort.findByUserId() │
│     - ADMIN → userId                                 │
│  5. AuthenticationPort.authenticate(credentials,     │
│                                      role, finalId)  │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      JwtAdapter                                      │
│  - Genera JWT con:                                   │
│    * subject: username                               │
│    * claim "role": STUDENT/INSTRUCTOR/ADMIN          │
│    * claim "id": studentId/instructorId/userId       │
│    * expiration: 3 minutos                           │
│  - Firma con SECRET_KEY (HS256)                      │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
       AuthController devuelve:
       {
         "token": "eyJhbGci...",
         "id": 1
       }
```


### **Flujo 3: Registro de Pago**
```
┌─────────────┐
│   Cliente   │
└──────┬──────┘
       │ POST /api/v1/payments/register
       │ { studentId, paymentDate, amount, paymentMethod }
       ▼
┌──────────────────────────────────────────────────────┐
│      PaymentController                               │
└──────┬───────────────────────────────────────────────┘
       │ 1. PaymentRestMapper.toDomain(request)
       │ 2. PaymentUseCase.createPayment(payment)
       ▼
┌──────────────────────────────────────────────────────┐
│      CreatePaymentService                            │
│  1. Valida que studentId sea válido                  │
│  2. Valida que amount > 0                            │
│  3. Valida que paymentMethod no esté vacío           │
│  4. FindPaymentPort.findLatestPaymentByStudent()     │
│  5. Verifica que NO haya pago en el mismo mes/año    │
│  6. CreatePaymentPort.save(payment)                  │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      PaymentAdapter                                  │
│  - PaymentMapper.toEntity(payment)                   │
│  - PaymentRepository.save(entity)                    │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│      MySQL Database                                  │
│  INSERT INTO payments (student_id, payment_date...)  │
└──────────────────────────────────────────────────────┘

🔒 Seguridad y Autenticación
JWT (JSON Web Token)
La aplicación utiliza JWT para autenticación stateless.
Estructura del Token:
json{
  "sub": "usuario123",           // Username
  "role": "STUDENT",             // Rol del usuario
  "id": 1,                       // studentId/instructorId/userId
  "iat": 1733678400,             // Timestamp de emisión
  "exp": 1733678580              // Timestamp de expiración (3 min)
}
```

#### Proceso de Validación:
```
┌─────────────┐
│   Request   │
│  Headers:   │
│  Authorization: Bearer eyJhbGci... │
└──────┬──────┘
       │
       ▼
┌──────────────────────────────────────────────────────┐
│    JwtAuthenticationFilter                           │
│  1. Extrae token del header "Authorization"          │
│  2. AuthenticationPort.validateToken(token)          │
│  3. Extrae username y role                           │
│  4. Crea UsernamePasswordAuthenticationToken         │
│  5. Establece en SecurityContext                     │
└──────┬───────────────────────────────────────────────┘
       │
       ▼
  El request continúa con autenticación establecida
Encriptación de Contraseñas
Las contraseñas se encriptan usando BCrypt:
java// En CreateUserService
user.setPassword(passwordEncoder.encode(user.getPassword()));

// En AuthenticationService (login)
if (!passwordEncoder.matches(credentials.getPassword(), user.getPassword())) {
    throw new Exception("Contraseña incorrecta");
}
CORS Configuration
Configurado en WebConfig.java para permitir requests desde el frontend:
java.allowedOrigins(
    "https://frontend-desarollo-production.up.railway.app",
    "https://backend-desrrollo-production.up.railway.app",
    "http://localhost:5173"
)

🚀 Despliegue
Docker
El proyecto incluye un Dockerfile multi-stage:
dockerfile# Stage 1: Build Backend
FROM maven:3.9.6-eclipse-temurin-21 AS backend-build
WORKDIR /build
COPY v1/pom.xml ./v1/
COPY v1/src ./v1/src/
RUN mvn -f v1/pom.xml clean package -DskipTests

# Stage 2: Build Frontend
FROM node:20 AS frontend-build
WORKDIR /build
COPY frontend/package*.json ./frontend/
WORKDIR /build/frontend
RUN npm install
COPY frontend/ .
RUN npm run build

# Stage 3: Final Container
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=backend-build /build/v1/target/*.jar app.jar
COPY --from=frontend-build /build/frontend/dist /app/static
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
Railway Deployment

Backend + DB: Desplegado en Railway con MySQL

URL: https://backend-desrrollo-production.up.railway.app


Frontend: Desplegado separadamente

URL: https://frontend-desarollo-production.up.railway.app



Variables de Entorno
properties# application.properties
spring.datasource.url=jdbc:mysql://host:port/railway
spring.datasource.username=root
spring.datasource.password=***
bash# Frontend .env
VITE_API_URL=https://backend-desrrollo-production.up.railway.app

📝 Notas Importantes
Validaciones

Todos los endpoints validan los datos de entrada usando Validators
Los builders (UserBuilder, StudentBuilder, etc.) aseguran consistencia

Manejo de Errores

Excepciones personalizadas: BusinessException, InputsException
Respuestas HTTP apropiadas (400, 401, 404, 500)

Transaccionalidad

Los servicios críticos usan @Transactional para garantizar atomicidad

Mappers

Se utilizan mappers para convertir entre:

Request DTO → Domain Model
Domain Model → Response DTO
Domain Model → Entity
Entity → Domain Model
