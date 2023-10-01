# Seleccionar una imagen base de Java (por ejemplo, OpenJDK 11)
FROM openjdk:17-jdk-alpine

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR de tu aplicación Spring Boot en el contenedor
COPY build/libs/primeraAPIREST-0.0.1-SNAPSHOT.jar myapp.jar

# Exponer el puerto en el que tu aplicación Spring Boot se ejecuta
EXPOSE 9000

# Comando de inicio para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "myapp.jar"]
