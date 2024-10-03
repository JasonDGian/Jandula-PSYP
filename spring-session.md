# 📌 ¿Qué es Spring Session?
Spring Session es un módulo de Spring que **gestiona la sesión del usuario de manera independiente del contenedor de aplicaciones** (como Tomcat). 
Permite almacenar sesiones en diferentes almacenes, como Redis, bases de datos o incluso en la memoria.

Este mecanismo permite mejorar la escalabilidad y permite compartir sesiones entre múltiples aplicaciones o instancias.

**Que es una sesión?**
Una sesión es un conjunto de datos que almacena información sobre un usuario durante su interacción con una aplicación, como su 
estado de autenticación o preferencias, permitiendo que la aplicación lo "recuerde" entre diferentes solicitudes.

# 📌 ¿Cómo funciona Spring Session?
Spring Session se encarga de manejar las sesiones de los usuarios en una aplicación de manera centralizada y externa. Normalmente, la sesión 
de un usuario (como su información de inicio de sesión) se guarda en el servidor donde está corriendo la aplicación. Con Spring Session, en 
lugar de guardarla en el servidor, se guarda en un lugar externo, como una base de datos o `Redis`.

<p align="center" > 
<img src="https://github.com/user-attachments/assets/e5c5efd4-0c9c-41ea-a9af-fb30644c0269">
</p>

Esto permite que, si la aplicación tiene varias instancias (como en una nube), todas compartan la misma sesión de usuario, sin importar en cuál servidor esté trabajando en ese momento

**¿Qué es REDIS?**
Redis es una herramienta poderosa y eficiente para gestionar datos en memoria y es muy utilizada en aplicaciones que requieren un rendimiento rápido. **Es una alternativa al uso de bases de datos como almacén de datos de sesión**.
   
# 📌 ¿Cómo se usa Spring Session?

## 🔹 Dependencias.
Lo primero es agregar las dependencias necesarias calculadas en base al proyecto , ya sea mediante el POM o con Spring Boot Initializr si se trata de un nuevo proyecto.

**Por POM de Maven**
```xml
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId> <!-- O el conector de tu base de datos -->
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

**Por Spring Initializr**   

![imagen](https://github.com/user-attachments/assets/6125b98d-13e5-4d9a-8c56-07721ca2e256)   
   

## 🔹 Configurar la conexión a BBDD.
Configura tu conexión a la base de datos en el archivo `application.yaml`.
   
**Ejemplo completo.**    
Ejemplo de fichero application.yaml con configuración basica de Spring Data JPA y Spring Session para uso de BBDD.
```yaml
spring:
  session:
    store-type: jdbc  # Almacenamiento de sesiones en la base de datos mediante JDBC.
    jdbc:
      table-name: SPRING_SESSION  # Tabla para almacenar datos de sesión; se puede cambiar si se desea.

  jpa:
    hibernate:
      ddl-auto: create  # Crea el esquema de la base de datos al iniciar la aplicación.
    show-sql: true  # Habilita el registro de las sentencias SQL para depuración.

  datasource:
    url: jdbc:mysql://localhost:3306/incidencias  # URL de conexión a la base de datos MySQL.
    username: root  # Usuario para la conexión a la base de datos.
    password: 1234  # Contraseña del usuario especificado.
    driver-class-name: com.mysql.cj.jdbc.Driver  # Controlador JDBC para interactuar con MySQL.
```

## 🔹 Crear Tablas para la Sesión
Spring Session utiliza tablas en la base de datos para almacenar las sesiones. Debes crear las tablas necesarias en tu base de datos. 
Puedes utilizar el esquema SQL proporcionado por Spring Session.    

Este seria el repositorio del script oficial. -> Actualmente me da error por algun motivo.
https://github.com/spring-projects/spring-session/blob/main/spring-session-jdbc/src/main/resources/org/springframework/session/jdbc/schema-mysql.sql


>[!CAUTION]
>Si utilizas Spring Boot como base, la creación de esta tabla se realizará automaticamente siempre y cuando se incluya la linea `store-type: jdbc` En application.yaml

**Tabla por defecto para MySQL:**
```mysql
CREATE TABLE SPRING_SESSION (
	PRIMARY_ID CHAR(36) NOT NULL,
	SESSION_ID CHAR(36) NOT NULL,
	CREATION_TIME BIGINT NOT NULL,
	LAST_ACCESS_TIME BIGINT NOT NULL,
	MAX_INACTIVE_INTERVAL INT NOT NULL,
	EXPIRY_TIME BIGINT NOT NULL,
	PRINCIPAL_NAME VARCHAR(100),
	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
	ATTRIBUTE_BYTES BLOB NOT NULL,
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;
```

>[!CAUTION]
>Este esquema puede variar dependiendo de la base de datos que estés utilizando, así que asegúrate de consultar la documentación oficial de Spring Session para obtener el esquema correcto.

## 🔹 Configurar el manejo de sesión de `Spring Session`.
Habilita Spring Session en tu aplicación con la anotación `@EnableJdbcHttpSession` en tu clase de configuración.

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableJdbcHttpSession // Permite el manejo de sesiones a través de JDBC
public class SessionConfig {
    // Opcional: Puedes definir configuraciones adicionales aquí
}
```

**¿Qué es una clase de configuración?**   
En el contexto de Spring Session, una clase de configuración es una clase que se utiliza para definir y configurar aspectos específicos del manejo de sesiones en una aplicación Spring. 




