# Usar una imagen base liviana con Java 17
FROM eclipse-temurin:17-jre-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el jar construido
COPY ../target/api-capitole-1.0-SNAPSHOT.jar api-capitole.jar

# Exponer el puerto
EXPOSE 8080

# Variables de entorno para el datasource
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "api-capitole.jar"]