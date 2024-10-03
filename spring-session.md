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

```yaml
spring:
  jpa.hibernate.ddl-auto: create # Configura cómo se debe gestionar el esquema de la base de datos.
  datasource:
    url: jdbc:mysql://localhost:3306/universidad # URL de conexión a la base de datos MySQL.
    username: root # Nombre de usuario para conectarse a la base de datos.
    password: 1234 # Contraseña correspondiente al usuario especificado.
    hikari: # Hikari es un mecanismo de eficiencia de conexiones. Cnoocido como "Pool de conexiones".
    connection-timeout: 60000 # Establece el tiempo máximo de espera en milisegundos (60 segundos) para obtener una conexión antes de lanzar un error.
    maximum-pool-size: 5 # Especifica el número máximo de conexiones permitidas en el pool de conexiones simultáneas.
```



## 🔹 Crear Tablas para la Sesión
Spring Session utiliza tablas en la base de datos para almacenar las sesiones. Debes crear las tablas necesarias en tu base de datos. 
Puedes utilizar el esquema SQL proporcionado por Spring Session.    
Ejemplo para MySQL:
```mysql
CREATE TABLE spring_session (
    primary_id VARCHAR(36) NOT NULL,
    session_id VARCHAR(36) NOT NULL,
    session serialized_value BLOB NOT NULL,
    last_access_time BIGINT NOT NULL,
    creation_time BIGINT NOT NULL,
    expiry_time BIGINT NOT NULL,
    index (session_id),
    PRIMARY KEY (primary_id)
);
```

>[!CAUTION]
>Este esquema puede variar dependiendo de la base de datos que estés utilizando, así que asegúrate de consultar la documentación oficial de Spring Session para obtener el esquema correcto.

## 🔹 Habilitar la sesión de spring `Spring Session`.
Habilita Spring Session en tu aplicación con la anotación `@EnableJdbcHttpSession` en tu clase de configuración:

```java
  import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableJdbcHttpSession
public class SessionConfig {
    // Puedes configurar parámetros adicionales aquí si es necesario
}
```







