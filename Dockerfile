# ============================
#   1. Construcción BACKEND
# ============================
FROM maven:3.9.6-eclipse-temurin-21 AS backend-build
WORKDIR /v1
COPY v1/pom.xml .
COPY v1/src ./src
RUN mvn clean package -DskipTests

# ============================
#   2. Construcción FRONTEND
# ============================
FROM node:20 AS frontend-build
WORKDIR /frontend
COPY frontend/package*.json ./
RUN npm install
COPY frontend/ .
RUN npm run build

# ============================
#   3. CONTENEDOR FINAL
# ============================
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar JAR del backend
COPY --from=backend-build /v1/target/*.jar app.jar

# Copiar frontend compilado
COPY --from=frontend-build /frontend/dist /app/static

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
