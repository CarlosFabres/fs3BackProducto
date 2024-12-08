# Imagen base de OpenJDK
FROM openjdk:21-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado al contenedor
COPY target/*.jar app.jar

# Copiar la wallet al contenedor
COPY ./Wallet_fs3 /app/wallet

# Configurar la variable de entorno para la wallet
ENV TNS_ADMIN=/app/wallet

# Exponer el puerto en el que se ejecutará el backend
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]