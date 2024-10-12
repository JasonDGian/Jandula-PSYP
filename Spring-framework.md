# 📌 Spring.
Spring es un framework centrado en crear aplicaciones de calibre comercial con Java.  Esto significa que con este framework podemos evitar muchisimo "Boilerplate code" que ya no es necesario escribir a mano.
**Spring ofrece además técnicas IOC (Inversion of Control) y posibilita el uso de Transacciones.**
   
https://spring.io/   








# 📌 Sub-marcos y componentes de Spring.
Una de las cosas que hace de Spring una autentica maravilla son las capas y marcos de trabajo adicionales que proporciona al programador.   
Entre ellas podemos mencionar las siguientes:   
1. **Spring Boot**: Ayuda a crear aplicaciones Java de forma rápida y sin tantas configuraciones.
2. **Spring Data JPA**: Facilita trabajar con bases de datos, haciendo que sea más fácil guardar y leer datos.
3. **Spring Security**: Protege las aplicaciones, controlando quién puede acceder y qué pueden hacer.
4. **Spring MVC**: Organiza el código para manejar solicitudes web y mostrar páginas.
5. **Spring Session**: Gestiona las sesiones de usuarios, manteniéndolas activas aunque cambien de servidor.
6. **Spring MySQL Driver**: Es la combinación de Spring con el driver JDBC de MySQL para permitir la conexión y operaciones con bases de datos MySQL desde una aplicación Java/Spring.

## 🔹 Spring Boot
Es un marco de trabajo que facilita la creación de aplicaciones Java, especialmente aplicaciones web. Spring Boot te permite empezar rápidamente con configuraciones mínimas, ya que proporciona configuraciones predeterminadas, sin tener que escribir mucho código o configuraciones adicionales.

## 🔹 Spring Data JPA
Es una herramienta dentro del ecosistema de Spring que simplifica la interacción con bases de datos. Usa JPA (Java Persistence API) para hacer que trabajar con bases de datos relacionales sea más fácil, permitiendo realizar consultas y operaciones en tablas de manera sencilla, con poco código.

## 🔹 Spring Security
Es un módulo que se encarga de la seguridad en aplicaciones Spring. Ayuda a proteger tu aplicación controlando el acceso a las rutas, gestionando la autenticación de usuarios (por ejemplo, inicio de sesión) y asegurando que los datos estén protegidos.

## 🔹 Spring MVC
Es un modelo que sigue el patrón de arquitectura "Modelo-Vista-Controlador" para crear aplicaciones web. Te permite manejar las solicitudes HTTP, procesar datos en el servidor y devolver respuestas, normalmente en forma de páginas web.

## 🔹 Spring Session
Es un módulo que gestiona las sesiones de usuario de manera independiente del servidor de aplicaciones. Esto permite que las sesiones de los usuarios se mantengan a través de varios servidores o instancias, lo que es útil en aplicaciones distribuidas o cuando se usa un balanceador de carga.

## 🔹 Spring MySQL Driver
Spring MySQL Driver no es un componente oficial de Spring, pero generalmente se refiere al uso del conector JDBC de MySQL dentro de una aplicación Spring para interactuar con bases de datos MySQL.

El MySQL JDBC Driver es una biblioteca que permite que las aplicaciones Java se conecten a bases de datos MySQL. En una aplicación Spring, este driver se incluye como dependencia (por ejemplo, en el archivo pom.xml si se usa Maven) para que la aplicación pueda realizar operaciones en la base de datos MySQL.
   
